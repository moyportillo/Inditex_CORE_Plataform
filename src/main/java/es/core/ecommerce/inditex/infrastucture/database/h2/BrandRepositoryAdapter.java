package es.core.ecommerce.inditex.infrastucture.database.h2;

import es.core.ecommerce.inditex.domain.model.Brands;
import es.core.ecommerce.inditex.domain.repository.BrandRepositoryPort;
import es.core.ecommerce.inditex.util.exception.BrandProcessException;
import es.core.ecommerce.inditex.util.exception.IntegralProcessException;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BrandRepositoryAdapter implements BrandRepositoryPort {

    private final BrandJpaRepository brandJpaRepository;

    @Override
    public Brands getPriceByBrandAndDate(long productId, long brandId, LocalDateTime date) throws BrandProcessException, IntegralProcessException {
        try {
            List<BrandsEntity> priceSelectedByApplication = brandJpaRepository.findApplicablePrice(productId, brandId, date);
            BrandsEntity registerPriorityBrandForPrice = priceSelectedByApplication.stream().findFirst().orElse(null);
            if(registerPriorityBrandForPrice != null) {
                return new Brands.BrandsBuilder().productId(registerPriorityBrandForPrice.getProductId())
                        .brandId(registerPriorityBrandForPrice.getBrandId())
                        .brandName(registerPriorityBrandForPrice.getBrandName())
                        .startDate(registerPriorityBrandForPrice.getStartDate())
                        .endDate(registerPriorityBrandForPrice.getEndDate())
                        .priceList(registerPriorityBrandForPrice.getPriceList())
                        .productId(registerPriorityBrandForPrice.getProductId())
                        .priority(registerPriorityBrandForPrice.getPriority())
                        .price(registerPriorityBrandForPrice.getPrice())
                        .currency(registerPriorityBrandForPrice.getCurrency())
                        .createDate(registerPriorityBrandForPrice.getCreateDate())
                        .updateDate(registerPriorityBrandForPrice.getUpdateDate())
                        .stateRegister(registerPriorityBrandForPrice.getStateRegister()).build();
            }
            throw new BrandProcessException("No se encontró datos para los criterios proporcionados");
        } catch (JpaSystemException e) {
            throw new IntegralProcessException("Error en el proceso para la base de datos");
        } catch(DataAccessException e){
            throw new IntegralProcessException("Problemas en la conexion a base de datos, tiempo de espera o transaccion de datos");
        } catch (NoResultException e) {
            throw new IntegralProcessException("No se encontro resultados en los datos");
        }
    }
}
