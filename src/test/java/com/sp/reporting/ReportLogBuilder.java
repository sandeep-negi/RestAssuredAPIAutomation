package com.sp.reporting;

import com.sp.rest.RestDTO;
import io.restassured.response.Response;

public class ReportLogBuilder {
    public static void printRequestLogInReport(RestDTO restDTO) {
        ExtentReportManager.logInfoDetails("URL is " + restDTO.getBaseUrl() + restDTO.getBasePath());
        ExtentReportManager.logInfoDetails("Method is " + restDTO.getMethod());

        if(!restDTO.getHeaders().isEmpty()){
            ExtentReportManager.logInfoDetails("Headers are ");
            ExtentReportManager.logHeaders(restDTO.getHeaders());
        }
        if(restDTO.getBody()!= null){
            ExtentReportManager.logInfoDetails("Request body is ");
            ExtentReportManager.logJson(restDTO.getBody());
        }
    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());

    }
}
