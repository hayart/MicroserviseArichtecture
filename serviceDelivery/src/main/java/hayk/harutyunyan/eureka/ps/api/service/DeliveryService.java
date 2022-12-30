package hayk.harutyunyan.eureka.ps.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hayk.harutyunyan.eureka.ps.api.dto.RequestDelivery;
import hayk.harutyunyan.eureka.ps.api.dto.ResponseDelivery;
import hayk.harutyunyan.eureka.ps.api.entity.Delivery;


public interface DeliveryService {

    ResponseDelivery doDelivery(RequestDelivery dto) throws JsonProcessingException;

    Delivery getById(int id) throws JsonProcessingException;
}
