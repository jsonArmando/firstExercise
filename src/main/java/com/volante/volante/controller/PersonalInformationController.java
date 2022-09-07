package com.volante.volante.controller;

import com.volante.volante.entity.PersonalInformation;
import com.volante.volante.model.response.PersonalInformationResponse;
import com.volante.volante.service.PersonalInformationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@Validated
@RequestMapping("/information")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@Slf4j
public class PersonalInformationController {
    private PersonalInformationService service;

    @PostMapping(value ="/personal",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonalInformationResponse> toResponse(@RequestBody PersonalInformation personalInformation)  {
        log.debug("PersonalInformationController.toResponse call (params)");
        var response = new ResponseEntity<>(service.toResponse(personalInformation), HttpStatus.OK);
        log.debug("PersonalInformationController.toResponse response {}", response);
        return response;
    }

}
