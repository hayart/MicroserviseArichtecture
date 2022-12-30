package hayk.harutyunyan.eureka.os.api.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hayk.harutyunyan.eureka.os.api.dto.DemandRequest;
import hayk.harutyunyan.eureka.os.api.dto.DemandResponse;
import hayk.harutyunyan.eureka.os.api.entity.Demand;
import hayk.harutyunyan.eureka.os.api.repository.DemandRepository;
import hayk.harutyunyan.eureka.os.api.service.DemandService;
import hayk.harutyunyan.eureka.ps.api.dto.RequestDelivery;
import hayk.harutyunyan.eureka.ps.api.dto.ResponseDelivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RefreshScope
public class DemandServiceImpl implements DemandService {

    Logger logger= LoggerFactory.getLogger(DemandServiceImpl.class);
    @Autowired
    private DemandRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;

    //@Value("${delivery-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    public DemandResponse saveDemand(DemandRequest request) throws JsonProcessingException {
        Demand entity = new Demand();
        entity.setFoodId(request.getFoodId());
        repository.save(entity);
        int demandId = entity.getId();

        RequestDelivery requestDelivery = new RequestDelivery();
        requestDelivery.setDemandId(demandId);
        //rest call
        logger.info("Demand-Service Request : " + new ObjectMapper().writeValueAsString(request));
        ResponseDelivery demandResponse = template.postForObject(ENDPOINT_URL, requestDelivery, ResponseDelivery.class);
        int deliveryId = demandResponse.getDeliveryId();

        Optional<Demand> byId = repository.findById(demandId);
        Demand updateEntity = byId.get();
        updateEntity.setDeliveryId(deliveryId);
        repository.save(updateEntity);

        return new DemandResponse(demandId, deliveryId);
    }
}
