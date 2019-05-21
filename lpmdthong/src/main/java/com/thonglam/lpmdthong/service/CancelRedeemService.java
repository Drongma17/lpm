package com.thonglam.lpmdthong.service;


import com.thonglam.lpmdthong.dao.CancelRedeem;
import com.thonglam.lpmdthong.dto.CancelRedeemDTO;
import org.springframework.http.ResponseEntity;

public interface CancelRedeemService {

    ResponseEntity<CancelRedeem> postCancelRedeem(CancelRedeemDTO cancelRedeemDTO);
    ResponseEntity<CancelRedeem> updateCancelRedeem(Long id, CancelRedeemDTO cancelRedeemDTO);
}
