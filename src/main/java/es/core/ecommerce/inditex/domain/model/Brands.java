package es.core.ecommerce.inditex.domain.model;

import es.core.ecommerce.inditex.dto.IBuilder;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brands {

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

    public static class BrandsBuilder implements IBuilder<Brands> {

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

        public BrandsBuilder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }
        public BrandsBuilder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }
        public BrandsBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }
        public BrandsBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }
        public BrandsBuilder priceList(Long priceList) {
            this.priceList = priceList;
            return this;
        }
        public BrandsBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }
        public BrandsBuilder priority(Integer priority) {
            this.priority = priority;
            return this;
        }
        public BrandsBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }
        public BrandsBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }
        public BrandsBuilder createDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }
        public BrandsBuilder updateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }
        public BrandsBuilder stateRegister(String stateRegister) {
            this.stateRegister = stateRegister;
            return this;
        }

        public Brands build() {
            Brands model = new Brands();
            model.setBrandId(brandId);
            model.setBrandName(brandName);
            model.setStartDate(startDate);
            model.setEndDate(endDate);
            model.setPriceList(priceList);
            model.setProductId(productId);
            model.setPriority(priority);
            model.setPrice(price);
            model.setCurrency(currency);
            model.setCreateDate(createDate);
            model.setUpdateDate(updateDate);
            model.setStateRegister(stateRegister);
            return model;

        }
    }
}
