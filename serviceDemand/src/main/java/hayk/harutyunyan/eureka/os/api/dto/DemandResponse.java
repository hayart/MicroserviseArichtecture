package hayk.harutyunyan.eureka.os.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandResponse {
    private Integer demandId;
    private Integer deliveryId;
}
