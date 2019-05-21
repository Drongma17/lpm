package com.thonglam.lpmdthong.repository;



import com.thonglam.lpmdthong.dao.Redeem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeemRepo  extends JpaRepository<Redeem, Long> {
}
