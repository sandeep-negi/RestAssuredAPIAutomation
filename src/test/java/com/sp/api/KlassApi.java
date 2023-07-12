package com.sp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.constants.EndPoints;
import com.sp.pojo.User;
import com.sp.pojo.klass.CreateKlassRequest;
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

public class KlassApi {
    public static Response createKlass(User user) throws JsonProcessingException {
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
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSchoolServiceBaseUrl());
        restDTO.setBasePath(EndPoints.KLASS);

        restDTO.setHeaders(header);
        restDTO.setCookies(cookies);
        restDTO.setBody(getRequestBody(user));
        restDTO.setMethod(RestMethods.POST);
        response = new RestActions().send(restDTO);
        ReportLogBuilder.printRequestLogInReport(restDTO);
        ReportLogBuilder.printResponseLogInReport(response);

        return response;
    }
    public static Response deleteKlass(User user, String klassId){
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
        Map<String, String> pathParam = new HashMap<>();
        cookies.put(SESSION_COOKIE_NAME, sessionId);
        cookies.put(JWT_AUTHORIZATION, jwtToken);
        header.put(XCSRF_TOKEN_NAME, csrfToken);
        header.put("content-type", "application/json");
        pathParam.put("klassId", klassId);

        RestDTO restDTO = new RestDTO();
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSchoolServiceBaseUrl());
        restDTO.setBasePath(EndPoints.DELETE_KLASS);
        restDTO.setPathParams(pathParam);
        restDTO.setHeaders(header);
        restDTO.setCookies(cookies);
        restDTO.setMethod(RestMethods.DELETE);
        response = new RestActions().send(restDTO);
        ReportLogBuilder.printRequestLogInReport(restDTO);
        ReportLogBuilder.printResponseLogInReport(response);
        return  response;
    }

    public static String getRequestBody(User user) throws JsonProcessingException {
        CreateKlassRequest kl = new CreateKlassRequest();
        if(user.getData().get("klassName")!=null){
            kl.setKlassName((String) user.getData().get("klassName"));
        }
        if(user.getData().get("gradeCode")!=null){
            kl.setGradeCode((String) user.getData().get("gradeCode"));
        }
        if(user.getData().get("subjectPreferenceCd")!=null){
            kl.setSubjectPreferenceCd((String) user.getData().get("subjectPreferenceCd"));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(kl);
    }

}
