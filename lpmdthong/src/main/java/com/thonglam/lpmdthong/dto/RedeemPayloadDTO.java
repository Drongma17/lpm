package com.thonglam.lpmdthong.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RedeemPayloadDTO {

   @JsonProperty("isRedeemCancelled")
   private boolean isRedeemCancelled ;
   @JsonProperty("lpmId")
   private String lpmId;
   @JsonProperty("transactionId")
   private String transactionId;


    public boolean isRedeemCancelled() {
        return isRedeemCancelled;
    }

    public void setRedeemCancelled(boolean redeemCancelled) {
        isRedeemCancelled = redeemCancelled;
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


}
