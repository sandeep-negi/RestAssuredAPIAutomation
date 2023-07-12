package com.sp.api;

import com.sp.constants.EndPoints;
import com.sp.pojo.User;
import com.sp.reporting.ReportLogBuilder;
import com.sp.rest.RestActions;
import com.sp.rest.RestDTO;
import com.sp.rest.RestMethods;
import com.sp.utils.ConfigLoader;
import io.restassured.response.Response;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.Map;

import static com.sp.constants.AppConstants.*;

public class ProfileApi {
    public static Response getWebProfile(User user){
        String sessionId;
        String jwtToken;
        Response response;
        response = LoginApi.doLogin(user);
        jwtToken = response.getCookies().get(JWT_AUTHORIZATION);

        response = LoginApi.getCsrfToken(response);

        String csrfToken = Jsoup.parse(response.getBody().asString()).select("meta[name=csrf-token]")
                .attr("content");
        sessionId = response.getCookies().get(SESSION_COOKIE_NAME);

        Map<String, String> header = new HashMap<>();
        Map<String, String> cookies = new HashMap<>();

        cookies.put(SESSION_COOKIE_NAME, sessionId);
        cookies.put(JWT_AUTHORIZATION, jwtToken);
        header.put(XCSRF_TOKEN_NAME, csrfToken);
        header.put("content-type", "application/json");
        RestDTO restDTO = new RestDTO();
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSplashBaseUrl());
        restDTO.setBasePath(EndPoints.WEB_PROFILE);

        restDTO.setHeaders(header);
        restDTO.setCookies(cookies);
        restDTO.setMethod(RestMethods.GET);
        response = new RestActions().send(restDTO);
        ReportLogBuilder.printRequestLogInReport(restDTO);
        ReportLogBuilder.printResponseLogInReport(response);
        return response;
    }
}
