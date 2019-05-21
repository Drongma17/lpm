package com.thonglam.lpmdthong.dao;
import javax.persistence.*;

@Entity
@Table(name = "redeem_table")
public class Redeem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lpmErrorDescription;
    private String lpmMessage;
    @JoinColumn(name = "lpmId", referencedColumnName = "lpmId")
    private String lpmId;
    @OneToOne(targetEntity = RedeemPayload.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RedeemPayload payload;
    private String lpmStatusCode;
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

    public RedeemPayload getPayload() {
        return payload;
    }

    public void setPayload(RedeemPayload payload) {
        this.payload = payload;
    }

    public String getLpmStatusCode() {
        return lpmStatusCode;
    }

    public void setLpmStatusCode(String lpmStatusCode) {
        this.lpmStatusCode = lpmStatusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
