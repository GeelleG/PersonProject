package com.qa.PersonProject.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Nobody there.")
public class PersonNotFoundException extends EntityNotFoundException {
}
