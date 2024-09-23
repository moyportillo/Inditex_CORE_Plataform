package es.core.ecommerce.inditex.infrastucture.database.h2;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "PRICES")
public class BrandsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Long brandId;
    private String brandName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String stateRegister;
}
