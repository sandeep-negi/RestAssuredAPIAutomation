package com.sp.pojo.klass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateKlassRequest {
    @JsonProperty("grade_code")
    private String gradeCode;
    @JsonProperty("name")
    private String klassName;
    @JsonProperty("subject_preference_cd")
    private String subjectPreferenceCd;
}
