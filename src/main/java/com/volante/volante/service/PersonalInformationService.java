package com.volante.volante.service;

import com.volante.volante.entity.PersonalInformation;
import com.volante.volante.exception.ResourceNotFoundException;
import com.volante.volante.model.response.PersonalInformationResponse;

import com.volante.volante.utils.Personal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonalInformationService {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PersonalInformationResponse toResponse(PersonalInformation personalInformation){
        log.debug("PersonalInformationService.toResponse for birthDate {}", personalInformation);

        if(personalInformation.getBirthDate().isBlank()){
            throw new ResourceNotFoundException(Personal.UNEXPECTED_ERROR.getMessage());
        }

        LocalDate date = LocalDate.parse(personalInformation.getBirthDate(), formatter);
        Period age = Period.between(date, LocalDate.now());

        String message = age.getYears()> Personal.AGE_PERSONAL.getCode()?
                Personal.AGE_HAPPY_ONE.getMessage():Personal.AGE_HAPPY_TWO.getMessage();

        return new PersonalInformationResponse(Personal.HELLO.getMessage() +personalInformation.getNames()+message);
    }
}
