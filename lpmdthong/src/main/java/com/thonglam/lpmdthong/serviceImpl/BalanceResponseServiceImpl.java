package com.thonglam.lpmdthong.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.thonglam.lpmdthong.dao.BalancePayload;
import com.thonglam.lpmdthong.dao.BalanceResponse;
import com.thonglam.lpmdthong.dao.BalanceValues;
import com.thonglam.lpmdthong.dto.BalancePayloadDTO;
import com.thonglam.lpmdthong.dto.BalanceResponseDTO;
import com.thonglam.lpmdthong.dto.BalanceValuesDTO;
import com.thonglam.lpmdthong.repository.BalanceResponseRepo;
import com.thonglam.lpmdthong.service.BalanceResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("balanceResponseService")
@Transactional
public class BalanceResponseServiceImpl implements BalanceResponseService {
    private final Logger LOGGER = LoggerFactory.getLogger(BalanceResponseServiceImpl.class);

    @Autowired
    private BalanceResponseRepo balanceResponseRepo;


    @Override
    public ResponseEntity<BalanceResponse> postBalance(BalanceResponseDTO balanceResponseDTO) {

        ObjectMapper mapper = new ObjectMapper();

        try{
            LOGGER.info("balanceRequestDto" + mapper.writeValueAsString(balanceResponseDTO));
        }catch (Exception e){
            LOGGER.error("Ex" ,e);
        }

        BalanceResponse balanceResponse=new BalanceResponse();
        BalancePayload balancepayload = new BalancePayload();


        balancepayload.setToken(balanceResponseDTO.getBalancepayloadDTO().getToken());
        balancepayload.setLpmId(balanceResponseDTO.getBalancepayloadDTO().getLpmId());
        balancepayload.setTransactionId(balanceResponseDTO.getBalancepayloadDTO().getTransactionId());

        List<BalanceValues>  listofbalancevalues = new ArrayList<BalanceValues>();

        try{
           List<BalanceValuesDTO> balanceValuesDTOS = balanceResponseDTO.getBalancepayloadDTO().getBalanceValueDTO();

           for(BalanceValuesDTO balanceValuesDTO : balanceValuesDTOS){
               String value = mapper.writeValueAsString(balanceValuesDTO);
               BalanceValues balanceValues = mapper.readValue(value,BalanceValues.class);
               listofbalancevalues.add(balanceValues);
           }
           balancepayload.setBalanceValues(listofbalancevalues);
        }catch (Exception e){
            LOGGER.error("Ex" ,e);
        }

        balanceResponse.setBalancePayload(balancepayload);

        balanceResponse.setLpmErrorDescription(balanceResponseDTO.getLpmErrorDescription());
        balanceResponse.setLpmMessage(balanceResponseDTO.getLpmMessage());
        balanceResponse.setLpmId(balanceResponseDTO.getLpmId());
         balanceResponse.setLpmStatusCode(balanceResponseDTO.getLpmStatusCode());
         balanceResponse.setMessage(balanceResponseDTO.getMessage());
         balanceResponse.setStatusCode(balanceResponseDTO.getStatusCode());


        BalanceResponse blr = balanceResponseRepo.save(balanceResponse);
        return ResponseEntity.ok().body(blr);

    }






    @Override
    public ResponseEntity<BalanceResponse> updateBalanceResponse(Long id, BalanceResponseDTO balanceResponseDTO) {

        ObjectMapper mapper = new ObjectMapper();

        try{
            LOGGER.info("balanceRequestDto" + mapper.writeValueAsString(balanceResponseDTO));
        }catch (Exception e){
            LOGGER.error("Ex" ,e);
        }

       Optional<BalanceResponse> balanceResponse = Optional.ofNullable(balanceResponseRepo.getOne(id));

        BalanceResponse update= null;

       if(balanceResponse.isPresent()){

           BalanceResponse balanceResponse1=balanceResponse.get();

           BalancePayload balancepayload = new BalancePayload();


           balancepayload.setToken(balanceResponseDTO.getBalancepayloadDTO().getToken());
           balancepayload.setLpmId(balanceResponseDTO.getLpmId());
           balancepayload.setTransactionId(balanceResponseDTO.getBalancepayloadDTO().getTransactionId());

           List<BalanceValues>  listofbalancevalues = new ArrayList<BalanceValues>();

           try{
               List<BalanceValuesDTO> balanceValuesDTOS = balanceResponseDTO.getBalancepayloadDTO().getBalanceValueDTO();

               for(BalanceValuesDTO balanceValuesDTO : balanceValuesDTOS){
                   String value = mapper.writeValueAsString(balanceValuesDTO);
                   BalanceValues balanceValues = mapper.readValue(value,BalanceValues.class);
                   listofbalancevalues.add(balanceValues);
               }
               balancepayload.setBalanceValues(listofbalancevalues);
           }catch (Exception e){
               LOGGER.error("Ex" ,e);
           }

           balanceResponse1.setBalancePayload(balancepayload);

           balanceResponse1.setLpmErrorDescription(balanceResponseDTO.getLpmErrorDescription());
           balanceResponse1.setLpmMessage(balanceResponseDTO.getLpmMessage());
           balanceResponse1.setLpmId(balanceResponseDTO.getLpmId());
           balanceResponse1.setLpmStatusCode(balanceResponseDTO.getLpmStatusCode());
           balanceResponse1.setMessage(balanceResponseDTO.getMessage());
           balanceResponse1.setStatusCode(balanceResponseDTO.getStatusCode());

           update = balanceResponseRepo.save(balanceResponse1);

       }

        return ResponseEntity.ok().body(update);
    }



    @Override
    public List<BalanceResponseDTO> listAllBalanceResponse() {
        ObjectMapper mapper = new ObjectMapper();

        List<BalanceResponse> balanceResponses=balanceResponseRepo.findAll();

        List<BalanceResponseDTO> balanceResponseDTOS=new ArrayList<>();
        List<BalanceValuesDTO> listofbalancevalues = null;

        BalanceResponseDTO balanceResponseDTO=new BalanceResponseDTO();
        BalancePayloadDTO balancePayloadDTO = new BalancePayloadDTO();

       for(BalanceResponse balanceResponse: balanceResponses) {

           balanceResponseDTO.setLpmId(balanceResponse.getLpmId());
           balanceResponseDTO.setLpmMessage(balanceResponse.getLpmMessage());

            listofbalancevalues = new ArrayList<BalanceValuesDTO>();

           try {
               List<BalanceValues> balanceValues = balanceResponse.getBalancePayload().getBalanceValues();

               for (BalanceValues balanceValue : balanceValues) {
                   String value = mapper.writeValueAsString(balanceValue);
                   BalanceValuesDTO balanceVal = mapper.readValue(value, BalanceValuesDTO.class);
                   listofbalancevalues.add(balanceVal);
               }

               balancePayloadDTO.setBalanceValueDTO(listofbalancevalues);
           } catch (Exception e) {
               LOGGER.error("Ex", e);
           }


           balancePayloadDTO.setLpmId(balanceResponse.getBalancePayload().getLpmId());
           balancePayloadDTO.setToken(balanceResponse.getBalancePayload().getToken());
           balancePayloadDTO.setTransactionId(balanceResponse.getBalancePayload().getTransactionId());


           balanceResponseDTO.setBalancepayloadDTO(balancePayloadDTO);



           balanceResponseDTO.setLpmErrorDescription(balanceResponse.getLpmErrorDescription());
           balanceResponseDTO.setLpmId(balanceResponse.getLpmId());
           balanceResponseDTO.setLpmStatusCode(balanceResponse.getLpmStatusCode());
           balanceResponseDTO.setMessage(balanceResponse.getMessage());
           balanceResponseDTO.setStatusCode(balanceResponse.getStatusCode());

           balanceResponseDTOS.add(balanceResponseDTO);

       }

       return balanceResponseDTOS;
    }


}
