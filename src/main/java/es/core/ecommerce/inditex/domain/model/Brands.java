package es.core.ecommerce.inditex.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="PRICES")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String brandId;
    private String startDate;
    private String endDate;
    private String priceList;
    private String productId;
    private String priority;
    private BigDecimal price;
    private String currency;
}
