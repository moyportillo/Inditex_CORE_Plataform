package es.core.ecommerce.inditex.infrastucture.rest.controller;

import es.core.ecommerce.inditex.dto.GeneralResponse;
import es.core.ecommerce.inditex.usecase.price.ReferencePriceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/core/ecommerce/inditex/api")
@RequiredArgsConstructor
public class BrandRestController {

    private final ReferencePriceInter referencePriceInter;

    @GetMapping("/price/find")
    public ResponseEntity<GeneralResponse> getPriceByBrands(@RequestParam long productId, @RequestParam long brandId, @RequestParam String date){

        try {
            GeneralResponse response = referencePriceInter.getReferencePrice(productId, brandId, date);
            return response != null ? new ResponseEntity<>(response, HttpStatus.OK) : new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
