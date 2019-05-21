package com.thonglam.lpmdthong.controller;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.thonglam.lpmdthong.dao.BalanceResponse;
import com.thonglam.lpmdthong.dao.CancelRedeem;
import com.thonglam.lpmdthong.dao.Redeem;
import com.thonglam.lpmdthong.dto.BalanceResponseDTO;
import com.thonglam.lpmdthong.dto.CancelRedeemDTO;
import com.thonglam.lpmdthong.dto.RedeemDTO;
import com.thonglam.lpmdthong.service.BalanceResponseService;
import com.thonglam.lpmdthong.service.CancelRedeemService;
import com.thonglam.lpmdthong.service.RedeemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lpmUrlMapping")
public class LPMRestController {


    private final Logger LOGGER = LoggerFactory.getLogger(LPMRestController.class);

    @Autowired
    private BalanceResponseService balanceResponseService;



    @Autowired
    private RedeemService redeemService;


    @Autowired
    private CancelRedeemService cancelRedeemService;



    @PostMapping("/postBalanceResponse")
    public ResponseEntity<BalanceResponse> postBalance(@RequestBody BalanceResponseDTO balanceResponseDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Request "+ mapper.writeValueAsString(balanceResponseDTO));

        }catch (Exception e){
            LOGGER.error("Balance is not able to save into DB"+e.getCause());
        }
        return balanceResponseService.postBalance(balanceResponseDTO);
    }



    @PostMapping("/postRedeem")
    public ResponseEntity<Redeem> postRedeem(@RequestBody RedeemDTO redeemDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Request "+ mapper.writeValueAsString(redeemDTO));

        }catch (Exception e){
            LOGGER.error("Redeem is not able to save into DB"+e.getCause());
        }
        return redeemService.postRedeem(redeemDTO);
    }





    @PostMapping("/postCancelredeem")
    public ResponseEntity<CancelRedeem> postCancelRedeem(@RequestBody CancelRedeemDTO cancelRedeemDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Request "+ mapper.writeValueAsString(cancelRedeemDTO));

        }catch (Exception e){
            LOGGER.error("Cancel Redeem is not able to save into DB"+e.getCause());
        }
        return cancelRedeemService.postCancelRedeem(cancelRedeemDTO);
    }



    @PutMapping("/updateBalanceResponse/{id}")
    public ResponseEntity<BalanceResponse> updateBalanceResponse(@PathVariable(value = "id") Long id, @RequestBody BalanceResponseDTO balanceResponseDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Update Request "+ mapper.writeValueAsString(balanceResponseDTO));

        }catch (Exception e){
            LOGGER.error("Balance Response is not able to update into DB"+e.getCause());
        }
        return balanceResponseService.updateBalanceResponse(id, balanceResponseDTO);
    }



    @PutMapping("/updateRedeem/{id}")
    public ResponseEntity<Redeem> updateRedeem(@PathVariable Long id, @RequestBody RedeemDTO redeemDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Request "+ mapper.writeValueAsString(redeemDTO));

        }catch (Exception e){
            LOGGER.error("Redeem is not able to update into DB"+e.getCause());
        }

        return redeemService.updateRedeem(id, redeemDTO);
    }




    @PutMapping("/updateCancelRedeem/{id}")
    public ResponseEntity<CancelRedeem> updateCancelRedeem(@PathVariable(value = "id") Long id, @RequestBody CancelRedeemDTO cancelRedeemDTO){
        ObjectMapper mapper =new ObjectMapper();
        try {
            LOGGER.info("Request "+ mapper.writeValueAsString(cancelRedeemDTO));

        }catch (Exception e){
            LOGGER.error("Cancel Redeem is not able to update into DB"+e.getCause());
        }
        return cancelRedeemService.updateCancelRedeem(id,cancelRedeemDTO);
    }




    @GetMapping("/listJsonOfBalanceResponse")
    public List<BalanceResponseDTO> listBalanceResponse(){
        return balanceResponseService.listAllBalanceResponse();
    }

}
