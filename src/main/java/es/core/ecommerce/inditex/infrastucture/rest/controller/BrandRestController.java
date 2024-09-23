package es.core.ecommerce.inditex.infrastucture.rest.controller;

import es.core.ecommerce.inditex.dto.GeneralResponse;
import es.core.ecommerce.inditex.usecase.price.ReferencePriceInter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core/ecommerce/inditex/api")
@RequiredArgsConstructor
public class BrandRestController {

    private final ReferencePriceInter referencePriceInter;


    @Operation(summary="Get a productId, brandId and date application")
    @ApiResponse(responseCode = "200", description = "Successfully price")
    @ApiResponse(responseCode = "404", description = "product or brand not found")
    @GetMapping("/price/find")
    public ResponseEntity<GeneralResponse> getPriceByBrands(@Parameter(description = "ID del producto") @RequestParam long productId,
                                                            @Parameter(description = "ID del marca") @RequestParam long brandId,
                                                            @Parameter(description = "Fecha de Aplicacion") @RequestParam String date) throws Exception {

        try {
            GeneralResponse response = referencePriceInter.getReferencePrice(productId, brandId, date);
            return response != null ? new ResponseEntity<>(response, HttpStatus.OK) : new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }


}
