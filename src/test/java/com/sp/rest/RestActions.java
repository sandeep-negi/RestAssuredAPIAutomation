package com.sp.rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestActions {

    public Response send(RestDTO restDTO) {
        // Check because You can either send form parameters OR body content in POST, not both!!
        if(restDTO.getFormParams().size()!=0){
            return RestAssured.given()
                    .baseUri(restDTO.getBaseUrl())
                    .basePath(restDTO.getBasePath())
                    .contentType(restDTO.getContentType())
                    .headers(restDTO.getHeaders())
                    .queryParams(restDTO.getQueryParams())
                    .formParams(restDTO.getFormParams())
                    .pathParams(restDTO.getPathParams())
                    .cookies(restDTO.getCookies())
                    .log().all()
                    .request(String.valueOf(restDTO.getMethod()))
                    .then().log().all()
                    .extract().response();
        }
        else{
            return RestAssured.given()
                    .baseUri(restDTO.getBaseUrl())
                    .basePath(restDTO.getBasePath())
                    .contentType(restDTO.getContentType())
                    .headers(restDTO.getHeaders())
                    .queryParams(restDTO.getQueryParams())
                    .pathParams(restDTO.getPathParams())
                    .cookies(restDTO.getCookies())
                    .body(restDTO.getBody())
                    .log().all()
                    .request(String.valueOf(restDTO.getMethod()))
                    .then().log().all()
                    .extract().response();
        }
        // Build Request
    }
}
