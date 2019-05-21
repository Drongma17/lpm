package com.thonglam.lpmdthong.repository;




        import com.thonglam.lpmdthong.dao.CancelRedeem;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface CancelRedeemRep extends JpaRepository<CancelRedeem, Long> {
}
