package com.sp.pojo.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Teacher {
    @JsonProperty("id")
    private String teacherId;
}
