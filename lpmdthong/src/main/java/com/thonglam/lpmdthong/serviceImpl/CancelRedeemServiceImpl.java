package com.thonglam.lpmdthong.serviceImpl;


import com.thonglam.lpmdthong.dao.CancelRedeem;
import com.thonglam.lpmdthong.dao.CancelRedeemPayload;
import com.thonglam.lpmdthong.dto.CancelRedeemDTO;
import com.thonglam.lpmdthong.repository.CancelRedeemRep;
import com.thonglam.lpmdthong.service.CancelRedeemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("cancelRedeemService")
public class CancelRedeemServiceImpl implements CancelRedeemService {

    @Autowired
    private CancelRedeemRep cancelRedeemRep;



    @Override
    public ResponseEntity<CancelRedeem> postCancelRedeem(CancelRedeemDTO cancelRedeemDTO) {

        CancelRedeem crdm = new CancelRedeem();
        CancelRedeemPayload cancelredeempayload =new CancelRedeemPayload();

        cancelredeempayload.setTransactionId(cancelRedeemDTO.getPayloadDTO().getTransactionId());
        cancelredeempayload.setRedeemCancelled(cancelRedeemDTO.getPayloadDTO().isRedeemCancelled());
        cancelredeempayload.setRedeemCancelled(cancelRedeemDTO.getPayloadDTO().isRedeemCancelled());
        cancelredeempayload.setLpmId(cancelRedeemDTO.getPayloadDTO().getLpmId());


        crdm.setLpmId(cancelRedeemDTO.getLpmId());
        crdm.setLpmMessage(cancelRedeemDTO.getLpmMessage());
        crdm.setMessage(cancelRedeemDTO.getMessage());
        crdm.setLpmErrorDescription(cancelRedeemDTO.getLpmErrorDescription());

        crdm.setPayload(cancelredeempayload);

        crdm.setLpmStatusCode(cancelRedeemDTO.getLpmStatusCode());
        crdm.setMessage(cancelRedeemDTO.getMessage());
        crdm.setStatusCode(cancelRedeemDTO.getStatusCode());

        CancelRedeem depocancalrdm =cancelRedeemRep.save(crdm);

        return ResponseEntity.ok().body(depocancalrdm);
    }




    @Override
    public ResponseEntity<CancelRedeem> updateCancelRedeem(Long id, CancelRedeemDTO cancelRedeemDTO) {

        Optional<CancelRedeem> cancelRedeem =Optional.ofNullable(cancelRedeemRep.getOne(id));

        CancelRedeem update=null;
        if(cancelRedeem.isPresent()){
            CancelRedeem crdm=cancelRedeem.get();

            CancelRedeemPayload cancelredeempayload =new CancelRedeemPayload();

            cancelredeempayload.setTransactionId(cancelRedeemDTO.getPayloadDTO().getTransactionId());
            cancelredeempayload.setRedeemCancelled(cancelRedeemDTO.getPayloadDTO().isRedeemCancelled());
            cancelredeempayload.setRedeemCancelled(cancelRedeemDTO.getPayloadDTO().isRedeemCancelled());
            cancelredeempayload.setLpmId(cancelRedeemDTO.getPayloadDTO().getLpmId());


            crdm.setLpmId(cancelRedeemDTO.getLpmId());
            crdm.setLpmMessage(cancelRedeemDTO.getLpmMessage());
            crdm.setMessage(cancelRedeemDTO.getMessage());
            crdm.setLpmErrorDescription(cancelRedeemDTO.getLpmErrorDescription());

            crdm.setPayload(cancelredeempayload);

            crdm.setLpmStatusCode(cancelRedeemDTO.getLpmStatusCode());
            crdm.setMessage(cancelRedeemDTO.getMessage());
            crdm.setStatusCode(cancelRedeemDTO.getStatusCode());

             update =cancelRedeemRep.save(crdm);

        }

        return ResponseEntity.ok().body(update);
    }

}
