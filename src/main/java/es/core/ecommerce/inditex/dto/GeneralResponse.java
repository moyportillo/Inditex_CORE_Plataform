package es.core.ecommerce.inditex.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GeneralResponse {
    private Long productId;
    private Long brandId;
    private String brandName;
    private Long priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private StateResponseProcess stateResponseProcess;

    public static class GeneralResponseBuilder implements IBuilder<GeneralResponse>{

        private Long productId;
        private Long brandId;
        private String brandName;
        private Long priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private BigDecimal price;
        private StateResponseProcess stateResponseProcess;

        public GeneralResponseBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }
        public GeneralResponseBuilder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }
        public GeneralResponseBuilder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }
        public GeneralResponseBuilder priceList(Long priceList) {
            this.priceList = priceList;
            return this;
        }
        public GeneralResponseBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }
        public GeneralResponseBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }
        public GeneralResponseBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public GeneralResponseBuilder stateResponseProcess(String code, String state, String message, String messageTechnical) {
            StateResponseProcess stateResponse = new StateResponseProcess();
            stateResponse.setCode(code);
            stateResponse.setState(state);
            stateResponse.setMessage(message);
            stateResponse.setMessageTechnical(messageTechnical);
            this.stateResponseProcess = stateResponse;
            return this;
        }

        @Override
        public GeneralResponse build() {
            GeneralResponse model = new GeneralResponse();
            model.setProductId(this.productId);
            model.setBrandId(this.brandId);
            model.setBrandName(this.brandName);
            model.setPriceList(this.priceList);
            model.setStartDate(this.startDate);
            model.setEndDate(this.endDate);
            model.setPrice(this.price);
            model.setStateResponseProcess(this.stateResponseProcess);

            return model;
        }
    }
}
