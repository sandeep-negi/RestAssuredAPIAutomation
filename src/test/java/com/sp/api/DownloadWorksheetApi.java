package com.sp.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.constants.EndPoints;
import com.sp.pojo.User;
import com.sp.pojo.downloadworksheet.DownloadWorksheetRequest;
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

public class DownloadWorksheetApi {
    public static Response downloadWorksheet(User user, String userId) {
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
        pathParam.put("userId", userId);

        RestDTO restDTO = new RestDTO();
        restDTO.setBaseUrl(ConfigLoader.getInstance().getSchoolServiceBaseUrl());
        restDTO.setBasePath(EndPoints.DOWNLOAD_WORKSHEET);

        restDTO.setHeaders(header);
        restDTO.setCookies(cookies);
        restDTO.setPathParams(pathParam);
        restDTO.setBody(getRequestBody(user));
        restDTO.setMethod(RestMethods.POST);
        response = new RestActions().send(restDTO);
        ReportLogBuilder.printRequestLogInReport(restDTO);
        ReportLogBuilder.printResponseLogInReport(response);

        return response;
    }

    public static String getRequestBody(User user) {
        DownloadWorksheetRequest dwl = new DownloadWorksheetRequest();
        if (user.getData().get("entityId") != null) {
            dwl.setEntityId((String) user.getData().get("entityId"));
        }
        if (user.getData().get("entityType") != null) {
            dwl.setEntityType((String) user.getData().get("entityType"));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(dwl);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
