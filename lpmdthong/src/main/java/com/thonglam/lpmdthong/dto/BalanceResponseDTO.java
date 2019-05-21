package com.thonglam.lpmdthong.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceResponseDTO {


    @JsonProperty("lpmErrorDescription")
    private String lpmErrorDescription;

    @JsonProperty("lpmMessage")
    private String lpmMessage;
    @JsonProperty("lpmId")
    private String lpmId;
    @JsonProperty("payload")
    private BalancePayloadDTO balancepayloadDTO;
    @JsonProperty("lpmStatusCode")
    private String lpmStatusCode;

    @JsonProperty("message")
    private String  message;
    @JsonProperty("statusCode")
    private String statusCode;

    public String getLpmErrorDescription() {
        return lpmErrorDescription;
    }

    public void setLpmErrorDescription(String lpmErrorDescription) {
        this.lpmErrorDescription = lpmErrorDescription;
    }

    public String getLpmMessage() {
        return lpmMessage;
    }

    public void setLpmMessage(String lpmMessage) {
        this.lpmMessage = lpmMessage;
    }

    public String getLpmId() {
        return lpmId;
    }

    public void setLpmId(String lpmId) {
        this.lpmId = lpmId;
    }

    public String getLpmStatusCode() {
        return lpmStatusCode;
    }

    public void setLpmStatusCode(String lpmStatusCode) {
        this.lpmStatusCode = lpmStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public BalancePayloadDTO getBalancepayloadDTO() {
        return balancepayloadDTO;
    }

    public void setBalancepayloadDTO(BalancePayloadDTO balancepayloadDTO) {
        this.balancepayloadDTO = balancepayloadDTO;
    }
}
