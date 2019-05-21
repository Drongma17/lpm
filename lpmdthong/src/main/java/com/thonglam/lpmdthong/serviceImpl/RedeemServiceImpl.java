package com.thonglam.lpmdthong.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.thonglam.lpmdthong.dao.Redeem;
import com.thonglam.lpmdthong.dao.RedeemPayload;
import com.thonglam.lpmdthong.dto.RedeemDTO;
import com.thonglam.lpmdthong.repository.RedeemRepo;
import com.thonglam.lpmdthong.service.RedeemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("redeemService")
public class RedeemServiceImpl implements RedeemService {

 private final Logger LOGGER =LoggerFactory.getLogger(RedeemServiceImpl.class);

    @Autowired
    private RedeemRepo redeemRepo;


    @Override
    public ResponseEntity<Redeem> postRedeem(RedeemDTO redeemDTO) {
        Redeem redeem= new Redeem();
        RedeemPayload payload = new RedeemPayload();

        payload.setLpmId(redeemDTO.getPayloadDTO().getLpmId());
        payload.setTransactionId(redeemDTO.getPayloadDTO().getTransactionId());
        payload.setRedeemCancelled(redeemDTO.getPayloadDTO().isRedeemCancelled());

        redeem.setLpmErrorDescription(redeemDTO.getLpmErrorDescription());
        redeem.setLpmId(redeemDTO.getLpmId());
        redeem.setLpmMessage(redeemDTO.getLpmMessage());
        redeem.setLpmStatusCode(redeemDTO.getLpmStatusCode());
        redeem.setStatusCode(redeemDTO.getStatusCode());

        redeem.setPayload(payload);


        Redeem rm = redeemRepo.save(redeem);
        return ResponseEntity.ok().body(rm);
    }




    @Override
    public ResponseEntity<Redeem> updateRedeem(Long id, RedeemDTO redeemDTO){

        ObjectMapper mapper = new ObjectMapper();

        try{
            LOGGER.info("balanceRequestDtoUpdate" + mapper.writeValueAsString(redeemDTO));
        }catch (Exception e){
            LOGGER.error("Ex" ,e);
        }


        Optional<Redeem> redeemExistence =Optional.ofNullable(redeemRepo.getOne(id));

        Redeem updateRedeem =null;

        if(redeemExistence.isPresent()){

            Redeem redeem =redeemExistence.get();
            RedeemPayload payload = new RedeemPayload();

            payload.setLpmId(redeemDTO.getPayloadDTO().getLpmId());
            payload.setTransactionId(redeemDTO.getPayloadDTO().getTransactionId());
            payload.setRedeemCancelled(redeemDTO.getPayloadDTO().isRedeemCancelled());

            redeem.setLpmErrorDescription(redeemDTO.getLpmErrorDescription());
            redeem.setLpmId(redeemDTO.getLpmId());
            redeem.setLpmMessage(redeemDTO.getLpmMessage());
            redeem.setLpmStatusCode(redeemDTO.getLpmStatusCode());
            redeem.setStatusCode(redeemDTO.getStatusCode());

            redeem.setPayload(payload);

            updateRedeem=redeemRepo.save(redeem);
        }
        return ResponseEntity.ok().body(updateRedeem);
    }



}
