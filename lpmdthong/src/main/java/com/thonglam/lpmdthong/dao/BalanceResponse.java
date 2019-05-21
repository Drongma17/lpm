package com.thonglam.lpmdthong.dao;

import javax.persistence.*;

@Entity
@Table(name = "balance_response")
public class BalanceResponse {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
 private String lpmErrorDescription;
 private String lpmMessage;
 @JoinColumn(name = "lpmId", referencedColumnName = "lpmId")
 private String lpmId;
 @OneToOne(targetEntity = BalancePayload.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL )
 private BalancePayload balancePayload;
 private String lpmStatusCode;
 private String  message;
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

 public BalancePayload getBalancePayload() {
  return balancePayload;
 }

 public void setBalancePayload(BalancePayload balancePayload) {
  this.balancePayload = balancePayload;
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

 public BalanceResponse() {
 }
}
