package hayk.harutyunyan.eureka.ps.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hayk.harutyunyan.eureka.ps.api.dto.RequestDelivery;
import hayk.harutyunyan.eureka.ps.api.dto.ResponseDelivery;
import hayk.harutyunyan.eureka.ps.api.entity.Delivery;
import hayk.harutyunyan.eureka.ps.api.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @PostMapping("/doDelivery")
    public ResponseDelivery doDelivery(@RequestBody RequestDelivery dto) throws JsonProcessingException {
        return deliveryService.doDelivery(dto);
    }

    @GetMapping("/{id}")
    public Delivery findDeliveryById(@PathVariable int deliveryId) throws JsonProcessingException {
        return deliveryService.getById(deliveryId);
    }


}
