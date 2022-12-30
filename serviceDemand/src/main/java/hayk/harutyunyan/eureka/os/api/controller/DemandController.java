package hayk.harutyunyan.eureka.os.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hayk.harutyunyan.eureka.os.api.dto.DemandRequest;
import hayk.harutyunyan.eureka.os.api.dto.DemandResponse;
import hayk.harutyunyan.eureka.os.api.service.DemandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demand")
public class DemandController {

    private final DemandService demandService;

    public DemandController(DemandService demandService){
        this.demandService = demandService;
    }

    @PostMapping("/food")
    public DemandResponse foodRequest(@RequestBody DemandRequest request) throws JsonProcessingException {
        return demandService.saveDemand(request);
    }
}
