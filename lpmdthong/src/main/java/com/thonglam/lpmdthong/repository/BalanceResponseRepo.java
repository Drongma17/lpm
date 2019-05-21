package com.thonglam.lpmdthong.repository;




import com.thonglam.lpmdthong.dao.BalanceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceResponseRepo extends JpaRepository<BalanceResponse, Long> {
}
