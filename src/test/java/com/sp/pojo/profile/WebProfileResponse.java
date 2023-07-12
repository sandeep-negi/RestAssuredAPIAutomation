package com.sp.pojo.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebProfileResponse {
    private Teacher teacher ;
    private List<Klasses> klasses;
    @JsonProperty("ab_Tests")
    private ABTests abTests;
    @JsonProperty("is_active_springboard_contest")
    private boolean isActiveSpringboardContest ;
}
