package com.sp.pojo.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ABTests {
    @JsonProperty("Parent::Dashboard")
    private String parentDashboard;
    @JsonProperty("Parent::DashboardBytesize2")
    private String parentDashboardByteSize2;
    @JsonProperty("Teacher::AssesmentPitchPage")
    private String teacherAssessmentPitchPage;
    @JsonProperty("Teacher::HomeWidgetAndAccessPage")
    private String teacherHomeWidgetAndAccessPage;
    @JsonProperty("Teacher::AssignmentMandatorySetting")
    private String teacherAssignmentMandatorySetting;
    @JsonProperty("Teacher::PtlInvitation")
    private String teacherPtlInvitation;
    @JsonProperty("Teacher::ClassHealthMeter")
    private String teacherClassHealthMeter;
    @JsonProperty("Teacher::PtlHomePopupExp")
    private String teacherPtlHomePopupExp;
    @JsonProperty("Teacher::GamificationC4OneVsOneTeacher")
    private String teacherGamificationC4OneVsOneTeacher;
    @JsonProperty("Teacher::New::Playzone")
    private String teacherNewPlayzone;
    @JsonProperty("Teacher::Freemium_Topics_Out")
    private String teacherFreemium_Topics_Out;
    @JsonProperty("Teacher::HomeAccessRevampPage")
    private String teacherHomeAccessRevampPage;
    @JsonProperty("Teacher::MathFactAdaptiveDefaultQuestion")
    private String teacherMathFactAdaptiveDefaultQuestion;
    @JsonProperty("Teacher::FreemiumNoBlocker")
    private String teacherFreemiumNoBlocker;
    @JsonProperty("Teacher::CircleCommunity")
    private String teacherCircleCommunity;
    @JsonProperty("Teacher::DashboardRevamp")
    private String teacherDashboardRevamp;
    @JsonProperty("Teacher::MultiplayerGamesLocked")
    private String teacherMultiplayerGamesLocked;
    @JsonProperty("Teacher::ServiceWorkerCaching")
    private String teacherServiceWorkerCaching;
    @JsonProperty("Teacher::HomeSchoolScreen")
    private String teacherHomeSchoolScreen;
    @JsonProperty("Teacher::SummerLearningWithoutDiscount")
    private String teacherSummerLearningWithoutDiscount;
    @JsonProperty("Teacher::OneClickAssignment")
    private String teacherOneClickAssignment;
    @JsonProperty("Teacher::IaDashboard")
    private String teacherIaDashboard;
    @JsonProperty("Teacher::RemoteLogin")
    private String teacherRemoteLogin;
    @JsonProperty("Teacher::CommonPassword")
    private String teacherCommonPassword;
    @JsonProperty("Teacher::DailyActivityReporting")
    private String teacherDailyActivityReporting;
    @JsonProperty("Teacher::GridReports")
    private String teacherGridReports;
    @JsonProperty("Teacher::Post3PmPtlSignup")
    private String teacherPost3PmPtlSignup;
    @JsonProperty("Teacher::StudentCenter")
    private String teacherStudentCenter;
    @JsonProperty("Teacher::TiledDashboard")
    private String teacherTiledDashboard;
    @JsonProperty("Teacher::PtlHookOnAssignment")
    private String teacherPtlHookOnAssignment;
    @JsonProperty("Teacher::NewMathFacts")
    private String teacherNewMathFacts;
    @JsonProperty("Teacher::AssignmentThroughGridReport")
    private String teacherAssignmentThroughGridReport;
    @JsonProperty("Teacher::TeacherGettingStarted")
    private String teacherTeacherGettingStarted;
    @JsonProperty("Teacher::GamificationC4Teacher")
    private String teacherGamificationC4Teacher;
    @JsonProperty("Teacher::Survey")
    private String teacherSurvey;
    @JsonProperty("Teacher::HomeAccessButtonName")
    private String teacherHomeAccessButtonName;
    @JsonProperty("Teacher::AddParentEmailScreen")
    private String teacherAddParentEmailScreen;
}
