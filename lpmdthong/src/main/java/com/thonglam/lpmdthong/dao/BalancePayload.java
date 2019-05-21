package com.thonglam.lpmdthong.dao;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "balance_payload")
public class BalancePayload {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long bid;


    private String token;

    @OneToMany(cascade = CascadeType.ALL,  targetEntity= BalanceValues.class)
    @Column(name = "balanceValues")
    List<BalanceValues> balanceValues ;


   @Column(name = "lpmId")
    private String lpmId;
    private String transactionId;

    public Long getBid() {
        return bid;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public List<BalanceValues> getBalanceValues() {
        return balanceValues;
    }

    public void setBalanceValues(List<BalanceValues> balanceValues) {
        this.balanceValues = balanceValues;
    }

    public BalancePayload() {
    }
}
