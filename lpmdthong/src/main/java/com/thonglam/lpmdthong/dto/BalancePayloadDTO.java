package com.thonglam.lpmdthong.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalancePayloadDTO {


    @JsonProperty("token")
    private String token;
    @JsonProperty("balanceValues")
    List<BalanceValuesDTO> balanceValueDTO ;
    @JsonProperty("lpmId")
    private String lpmId;
    @JsonProperty("transactionId")
    private String transactionId;



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

  public List<BalanceValuesDTO> getBalanceValueDTO() {
        return balanceValueDTO;
    }

    public void setBalanceValueDTO(List<BalanceValuesDTO> balanceValueDTO) {
        this.balanceValueDTO = balanceValueDTO;
    }



    public String getLpmId() {
        return lpmId;
    }

    public void setLpmId(String lpmId) {
        this.lpmId = lpmId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BalancePayloadDTO() {
    }
}
