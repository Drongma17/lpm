package com.thonglam.lpmdthong.dao;

import javax.persistence.*;

@Entity
@Table(name = "cancel_payload")
public class CancelRedeemPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isRedeemCancelled;
    @Column(name = "IpmId")
    private String lpmId;
    private String transactionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
