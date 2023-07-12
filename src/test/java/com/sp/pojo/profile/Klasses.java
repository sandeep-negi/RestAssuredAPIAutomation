package com.sp.pojo.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Klasses {
    @JsonProperty("id")
    private String KlassId;
    @JsonProperty("is_enrolled_in_springboard")
    private boolean isEnrolledInSpringboard;
    @JsonProperty("is_eligible_for_springboard")
    private boolean isEligibleForSpringboard;
    @JsonProperty("is_eligible_for_springboard_tab")
    private boolean isEligibleForSpringboardTab;

}
