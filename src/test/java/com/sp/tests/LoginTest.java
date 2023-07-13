package com.sp.tests;

import com.aventstack.extentreports.ExtentTest;
import com.sp.api.LoginApi;
import com.sp.constants.StatusCode;
import com.sp.pojo.User;
import com.sp.reporting.Setup;
import com.sp.utils.JsonUtility;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test(groups = {"@regression", "@smoke", "@staging", "@prod", "@TC001"})
    public void verifyLoginUsingValidData() {
        User user = JsonUtility.getUserData("@TC001");
        ExtentTest test = Setup.extentReports.createTest("Verify Uer login with valid Data").assignCategory("User Login");
        Setup.extentTest.set(test);
        Response response = LoginApi.doLogin(user);
        Assert.assertTrue(response.statusCode() == StatusCode.SUCCESS.code || response.statusCode() == 301);
    }
}
