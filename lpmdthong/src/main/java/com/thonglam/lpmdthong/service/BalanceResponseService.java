package com.thonglam.lpmdthong.service;


import com.thonglam.lpmdthong.dao.BalanceResponse;
import com.thonglam.lpmdthong.dto.BalanceResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BalanceResponseService {

     ResponseEntity<BalanceResponse> postBalance(BalanceResponseDTO balanceResponseDTO);

     ResponseEntity<BalanceResponse> updateBalanceResponse(Long id, BalanceResponseDTO balanceResponseDTO);

    List<BalanceResponseDTO> listAllBalanceResponse();

}
