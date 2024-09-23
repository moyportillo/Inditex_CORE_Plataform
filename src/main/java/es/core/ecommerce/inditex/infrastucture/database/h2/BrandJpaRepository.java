package es.core.ecommerce.inditex.infrastucture.database.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface BrandJpaRepository extends JpaRepository<BrandsEntity, UUID> {

    @Query(value = "SELECT * FROM PRICES WHERE PRODUCT_ID = :productId AND BRAND_ID = :brandId AND :dateApplication BETWEEN START_DATE AND END_DATE AND STATE_REGISTER = 'ACT' ORDER BY PRIORITY DESC", nativeQuery = true)
    List<BrandsEntity> findApplicablePrice(@Param("productId") Long productId,
                                           @Param("brandId") Long brandId,
                                           @Param("dateApplication") LocalDateTime dateApplication);
}
