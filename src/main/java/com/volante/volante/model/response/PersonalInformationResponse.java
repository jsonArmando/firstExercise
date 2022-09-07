package com.volante.volante.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalInformationResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(name = "message", type = "String", description = "names", example = "eres un adulto")
    private String message;
}

