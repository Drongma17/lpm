package com.thonglam.lpmdthong.dao;



import javax.persistence.*;

@Entity
@Table(name = "cancel_reedem")
public class CancelRedeem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lpmErrorDescription;
    private String lpmMessage;
    @JoinColumn(name = "lpmId", referencedColumnName = "lpmId")
    private String lpmId;
    @OneToOne(targetEntity = CancelRedeemPayload.class, cascade = CascadeType.ALL)
    private CancelRedeemPayload payload;
    private String lpmStatusCode;
    private String message;
    private String statusCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public CancelRedeemPayload getPayload() {
        return payload;
    }

    public void setPayload(CancelRedeemPayload payload) {
        this.payload = payload;
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
}
