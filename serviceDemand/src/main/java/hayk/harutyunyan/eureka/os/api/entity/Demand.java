package hayk.harutyunyan.eureka.os.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMAND_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demand {
    @Id
    private int id;
    private int deliveryId;
    private int foodId;
}
