package hayk.harutyunyan.eureka.os.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import hayk.harutyunyan.eureka.os.api.dto.DemandRequest;
import hayk.harutyunyan.eureka.os.api.dto.DemandResponse;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public interface DemandService {
     DemandResponse saveDemand(DemandRequest request) throws JsonProcessingException;
}
