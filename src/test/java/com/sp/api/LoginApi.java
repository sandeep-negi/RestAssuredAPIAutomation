package com.sp.api;

import com.sp.constants.EndPoints;
import com.sp.pojo.User;
import com.sp.reporting.ReportLogBuilder;
import com.sp.rest.RestActions;
import com.sp.rest.RestDTO;
import com.sp.rest.RestMethods;
import com.sp.utils.ConfigLoader;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.sp.constants.AppConstants.JWT_AUTHORIZATION;
import static com.sp.constants.AppConstants.SESSION_COOKIE_NAME;

public class LoginApi {
    public static Response doLogin(User user) {
        RestDTO restDTO = new RestDTO();
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSplashBaseUrl());
        restDTO.setBasePath(EndPoints.SIGN_IN);

        Map<String, String> queryParams = new HashMap<>();
        Map<String, String> header = new HashMap<>();
        Map<String, String> formParam = new HashMap<>();

        header.put("content-type", "application/x-www-form-urlencoded");
        queryParams.put("source", "Parent/Teacher Login");
        queryParams.put("send_to_mixpanel", "true");
        formParam.put("user[login]", user.getEmail());
        formParam.put("user[password]", user.getPassword());
        formParam.put("user[remember_me]", "0");
        formParam.put("commit", "Login");

        restDTO.setQueryParams(queryParams);
        restDTO.setHeaders(header);
        restDTO.setFormParams(formParam);

        restDTO.setMethod(RestMethods.POST);
        Response response = new RestActions().send(restDTO);

        ReportLogBuilder.printRequestLogInReport(restDTO);
        ReportLogBuilder.printResponseLogInReport(response);

        if (!(response.statusCode() == 200 || response.statusCode() == 301)) {
            throw new RuntimeException("Invalid Response");
        } else {
            return response;
        }
    }

    public static Response getCsrfToken(Response response) {
        Map<String, String> header = new HashMap<>();
        Map<String, String> cookies = new HashMap<>();
        cookies.put(JWT_AUTHORIZATION, response.getCookies().get("jwt_authorization"));
        cookies.put(SESSION_COOKIE_NAME, response.getCookies().get("_session_id"));

        RestDTO restDTO = new RestDTO();
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSplashBaseUrl());
        restDTO.setBasePath("/");
        header.put("content-type", "application/json");
        restDTO.setCookies(cookies);
        restDTO.setHeaders(header);
        restDTO.setMethod(RestMethods.GET);

        Response getTokenresponse = new RestActions().send(restDTO);
        if (getTokenresponse.getStatusCode() != 200) {
            throw new RuntimeException("Failed to get CSRF Token");
        }
        return getTokenresponse;
    }
}
