package com.volante.volante.utils;

import lombok.AllArgsConstructor;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public enum Personal {
    AGE_PERSONAL(18, "Edad a validar."),
    AGE_HAPPY_ONE(1, " eres un adulto."),
    AGE_HAPPY_TWO(2, " sigue disfrutando de la vida!"),
    HELLO(3, " Hola "),
    UNEXPECTED_ERROR(0, "Registre la fecha de nacimiento");
    private final Integer code;
    private final String message;

}
