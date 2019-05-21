package com.thonglam.lpmdthong.dao;

import javax.persistence.*;

@Entity
@Table(name = "balance_values")
public class BalanceValues {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "balanceValues")
  private Long id;
  private String entityId;
  private String entityName;
  private String pointBalance;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
