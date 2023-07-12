package com.sp.tests;

import com.aventstack.extentreports.ExtentTest;
import com.sp.api.DownloadWorksheetApi;
import com.sp.api.ProfileApi;
import com.sp.pojo.User;
import com.sp.pojo.profile.WebProfileResponse;
import com.sp.reporting.Setup;
import com.sp.utils.JsonUtility;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadWorksheetTest{
    @Test(groups = {"@regression", "@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithValidData() {
        User user  = JsonUtility.getUserData("@TC010");
        ExtentTest test = Setup.extentReports.createTest("Verify Download Worksheet Api for Valid Data").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 201, "Unable to Download Worksheet");

    }

    @Test(groups = {"@smoke", "@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithInValidEntityId() {
        User user  = JsonUtility.getUserData("@TC011");
        ExtentTest test = Setup.extentReports.createTest("Verify Download Worksheet Api for Invalid Entity ID").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }

    @Test(groups = {"@smoke", "@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithInValidEntityType() {
        User user  = JsonUtility.getUserData("@TC012");
        ExtentTest test = Setup.extentReports.createTest("Verify Download Worksheet Api for Invalid Entity Type").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }

    @Test(groups = {"@smoke", "@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithoutEntityId() {
        User user  = JsonUtility.getUserData("@TC013");
        ExtentTest test = Setup.extentReports.createTest("Verify Api without passing Entity ID value ").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }

    @Test(groups = {"@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithoutEntityType() {
        User user  = JsonUtility.getUserData("@TC014");
        ExtentTest test = Setup.extentReports.createTest("Verify Api without passing Entity Type value ").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }
    @Test(groups = {"@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithoutPassingEntityId() {
        User user  = JsonUtility.getUserData("@TC015");
        ExtentTest test = Setup.extentReports.createTest("Verify Api without passing Entity Id key ").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }
    @Test(groups = {"@staging", "@prod", "@download_worksheet"})
    public void verifyDownloadWorksheetWithoutPassingEntityType() {
        User user  = JsonUtility.getUserData("@TC016");
        ExtentTest test = Setup.extentReports.createTest("Verify Api without passing Entity Type key ").assignCategory("Download Worksheet");
        Setup.extentTest.set(test);

        Response getProfileResponse = ProfileApi.getWebProfile(user);
        WebProfileResponse webProfileResponse = getProfileResponse.as(WebProfileResponse.class);

        Response downloadWorksheetResponse = DownloadWorksheetApi.downloadWorksheet(user, webProfileResponse.getTeacher().getTeacherId());
        Assert.assertEquals(downloadWorksheetResponse.statusCode(), 400, "Worksheet Downloaded");
    }
}
