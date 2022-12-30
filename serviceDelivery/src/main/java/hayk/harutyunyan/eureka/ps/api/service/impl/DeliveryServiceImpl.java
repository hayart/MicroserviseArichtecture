package hayk.harutyunyan.eureka.ps.api.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hayk.harutyunyan.eureka.ps.api.dto.RequestDelivery;
import hayk.harutyunyan.eureka.ps.api.dto.ResponseDelivery;
import hayk.harutyunyan.eureka.ps.api.entity.Delivery;
import hayk.harutyunyan.eureka.ps.api.repository.DeliveryRepository;
import hayk.harutyunyan.eureka.ps.api.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository){
        this.deliveryRepository = deliveryRepository;
    }

    Logger logger= LoggerFactory.getLogger(DeliveryServiceImpl.class);

    @Override
    public ResponseDelivery doDelivery(RequestDelivery dto) throws JsonProcessingException {
        Delivery entity = new Delivery();
        entity.setDemandId(dto.getDemandId());
        entity.setStatus("Delivery");
        logger.info("Delivery-Service Request : {}", new ObjectMapper().writeValueAsString(dto));
        deliveryRepository.save(entity);
        return new ResponseDelivery(entity.getId(), entity.getStatus());
    }

    @Override
    public Delivery getById(int id) throws JsonProcessingException {
        Delivery delivery = deliveryRepository.findById(id).get();
        logger.info("deliveryService findById : {}",new ObjectMapper().writeValueAsString(delivery));
        return delivery;
    }
}
