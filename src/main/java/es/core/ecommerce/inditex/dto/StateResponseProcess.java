package es.core.ecommerce.inditex.dto;

import lombok.Data;

@Data
public class StateResponseProcess {

    private String code;
    private String state;
    private String message;
    private String messageTechnical;
}
