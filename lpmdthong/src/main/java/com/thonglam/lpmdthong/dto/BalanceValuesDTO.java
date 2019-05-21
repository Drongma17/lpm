package com.thonglam.lpmdthong.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceValuesDTO {

  @JsonProperty("entityId")
  private String entityId;
  @JsonProperty("entityName")
  private String entityName;
  @JsonProperty("pointBalance")
  private String pointBalance;

  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }

  public String getEntityName() {
    return entityName;
  }

  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }

  public String getPointBalance() {
    return pointBalance;
  }

  public void setPointBalance(String pointBalance) {
    this.pointBalance = pointBalance;
  }
}
