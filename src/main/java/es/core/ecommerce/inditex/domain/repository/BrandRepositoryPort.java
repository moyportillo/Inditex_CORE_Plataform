package es.core.ecommerce.inditex.domain.repository;

import es.core.ecommerce.inditex.domain.model.Brands;
import es.core.ecommerce.inditex.util.exception.BrandProcessException;
import es.core.ecommerce.inditex.util.exception.IntegralProcessException;

import java.time.LocalDateTime;

public interface BrandRepositoryPort {

    Brands getPriceByBrandAndDate(long productId, long brandId, LocalDateTime date) throws BrandProcessException, IntegralProcessException;

}
