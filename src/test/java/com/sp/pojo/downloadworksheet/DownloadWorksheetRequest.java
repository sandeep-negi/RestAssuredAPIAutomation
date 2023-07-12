package com.sp.pojo.downloadworksheet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadWorksheetRequest {
    @JsonProperty("entity_id")
    private String entityId;
    @JsonProperty("entity_type")
    private String entityType;
}
