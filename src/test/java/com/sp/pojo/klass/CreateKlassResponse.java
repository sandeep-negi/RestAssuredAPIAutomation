package com.sp.pojo.klass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateKlassResponse {
    private String id;
    private String name;
    private String slug;
    @JsonProperty("grade_id")
    private String gradeId;
    @JsonProperty("students_count")
    private int studentsCount;
    @JsonProperty("school_year")
    private int schoolYear;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("teacher_id")
    private String teacherId;
    @JsonProperty("co_teaching_klass")
    private boolean coTeachingKlass;
}
