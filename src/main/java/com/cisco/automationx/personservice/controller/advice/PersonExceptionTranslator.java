package com.cisco.automationx.personservice.controller.advice;

import com.cisco.automationx.personservice.dto.ErrorDetailsDTO;
import com.cisco.automationx.personservice.service.exception.person.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class PersonExceptionTranslator {

    private final MessageSource messageSource;

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetailsDTO translatePersonNotFoundException(PersonNotFoundException exception) {
        ErrorDetailsDTO errorDetailsDTO = new ErrorDetailsDTO();
        errorDetailsDTO.setTimestamp(new Date());
        errorDetailsDTO.setError(exception.getErrorCode());
        errorDetailsDTO.setMessage(messageSource.getMessage(exception.getErrorCode(), exception.getArguments(), Locale.getDefault()));

        return errorDetailsDTO;
    }
}
