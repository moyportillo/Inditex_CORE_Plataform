package es.core.ecommerce.inditex.usecase.price;

import es.core.ecommerce.inditex.dto.GeneralResponse;
import es.core.ecommerce.inditex.util.exception.BrandProcessException;
import es.core.ecommerce.inditex.util.exception.IntegralProcessException;


public interface ReferencePriceInter {
    GeneralResponse getReferencePrice(long productId, long brandId, String date) throws BrandProcessException, IntegralProcessException;
}
