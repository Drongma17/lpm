package com.thonglam.lpmdthong.service;


import com.thonglam.lpmdthong.dao.Redeem;
import com.thonglam.lpmdthong.dto.RedeemDTO;
import org.springframework.http.ResponseEntity;

public interface RedeemService {


    ResponseEntity<Redeem> postRedeem(RedeemDTO redeemDTO);
    ResponseEntity<Redeem> updateRedeem(Long id, RedeemDTO redeemDTO);
}
