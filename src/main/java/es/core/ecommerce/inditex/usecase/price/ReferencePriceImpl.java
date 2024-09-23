package es.core.ecommerce.inditex.usecase.price;

import es.core.ecommerce.inditex.domain.model.Brands;
import es.core.ecommerce.inditex.domain.repository.BrandRepositoryPort;
import es.core.ecommerce.inditex.dto.GeneralResponse;
import es.core.ecommerce.inditex.util.enume.StateProcessBrand;
import es.core.ecommerce.inditex.util.exception.BrandProcessException;
import es.core.ecommerce.inditex.util.exception.IntegralProcessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class ReferencePriceImpl implements ReferencePriceInter{

    private final BrandRepositoryPort brandRepositoryPort;

    @Override
    public GeneralResponse getReferencePrice(long productId, long brandId, String date) throws BrandProcessException, IntegralProcessException {
        try {
            LocalDateTime applicationDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

            Brands registerApplicationPrice = brandRepositoryPort.getPriceByBrandAndDate(productId, brandId, applicationDate);
            return new GeneralResponse.GeneralResponseBuilder()
                    .productId(registerApplicationPrice.getProductId())
                    .brandId(registerApplicationPrice.getBrandId())
                    .brandName(registerApplicationPrice.getBrandName())
                    .priceList(registerApplicationPrice.getPriceList())
                    .startDate(registerApplicationPrice.getStartDate())
                    .endDate(registerApplicationPrice.getEndDate())
                    .price(registerApplicationPrice.getPrice())
                    .stateResponseProcess("0000", ""+ StateProcessBrand.OK,"SUCCESS", "SUCCESS").build();
        } catch (BrandProcessException | IntegralProcessException e) {
            return new GeneralResponse.GeneralResponseBuilder().stateResponseProcess("9999",""+ StateProcessBrand.ERROR, ""+e.getMessage(), e.toString()).build();
        }
    }
}
