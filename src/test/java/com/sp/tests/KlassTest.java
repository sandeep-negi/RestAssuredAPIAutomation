package com.sp.tests;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sp.api.KlassApi;
import com.sp.pojo.User;
import com.sp.pojo.klass.CreateKlassResponse;
import com.sp.reporting.Setup;
import com.sp.utils.JsonUtility;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KlassTest {
    @Test(groups = {"@regression","@staging","@prod", "@Klass"})
    public void verifyCreateKlassUsingValidData() throws JsonProcessingException {
        User user  = JsonUtility.getUserData("@TC005");
        ExtentTest test = Setup.extentReports.createTest("Verify Create Klass Api Using Valid Data").assignCategory("Create Klass");
        Setup.extentTest.set(test);

        Response response = KlassApi.createKlass(user);
        CreateKlassResponse createKlassResponse = response.as(CreateKlassResponse.class);
        Assert.assertEquals(response.statusCode(), 201);

        Response deleteKlassResponse = KlassApi.deleteKlass(user, createKlassResponse.getId());
        Assert.assertEquals(deleteKlassResponse.statusCode(), 200);
    }

    @Test(groups = {"@smoke","@staging","@prod", "@Klass"})
    public void verifyCreateKlassUsingInValidGradeCode() throws JsonProcessingException {
        User user  = JsonUtility.getUserData("@TC006");
        ExtentTest test = Setup.extentReports.createTest("Verify Create Klass Api Using Invalid GradeCode").assignCategory("Create Klass");
        Setup.extentTest.set(test);
        Response response = KlassApi.createKlass(user);
        Assert.assertEquals(response.statusCode(), 400);
    }
    @Test(groups = {"@staging","@prod", "@Klass"})
    public void verifyCreateKlassWithoutKlassName() throws JsonProcessingException {
        User user  = JsonUtility.getUserData("@TC007");
        ExtentTest test = Setup.extentReports.createTest("Verify Create Klass Api without KlassName").assignCategory("Create Klass");
        Setup.extentTest.set(test);
        Response response = KlassApi.createKlass(user);
        Assert.assertEquals(response.statusCode(), 400);
    }
    @Test(groups = {"@staging","@prod", "@Klass"})
    public void verifyCreateKlassWithoutGradeCode() throws JsonProcessingException {
        User user  = JsonUtility.getUserData("@TC008");
        ExtentTest test = Setup.extentReports.createTest("Verify Create Klass Api without GradeKode").assignCategory("Create Klass");
        Setup.extentTest.set(test);
        Response response = KlassApi.createKlass(user);
        Assert.assertEquals(response.statusCode(), 400);
    }
    @Test(groups = {"@staging","@prod", "@Klass"})
    public void verifyCreateKlassWithoutSubjectCode() throws JsonProcessingException {
        User user  = JsonUtility.getUserData("@TC009");
        ExtentTest test = Setup.extentReports.createTest("Verify Create Klass Api without SubjectCode").assignCategory("Create Klass");
        Setup.extentTest.set(test);
        Response response = KlassApi.createKlass(user);
        Assert.assertEquals(response.statusCode(), 400);
    }
}
