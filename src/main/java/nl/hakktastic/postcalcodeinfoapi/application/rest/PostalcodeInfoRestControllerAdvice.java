package nl.hakktastic.postcalcodeinfoapi.application.rest;

import jakarta.servlet.http.HttpServletRequest;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.InvalidValueObjectException;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.PostalCodeInformationAlreadyExistsException;
import nl.hakktastic.postcalcodeinfoapi.shared.domain.PostalCodeInformationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
class PostalcodeInfoRestControllerAdvice {

    @ExceptionHandler(PostalCodeInformationNotFoundException.class)
    ProblemDetail handlePostalCodeInformationNotFound(PostalCodeInformationNotFoundException postalCodeInformationNotFoundException, HttpServletRequest httpServletRequest) {

        final var problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Postal Code Information Not Found");
        problem.setDetail(postalCodeInformationNotFoundException.getMessage());
        problem.setInstance(URI.create(httpServletRequest.getRequestURI()));

        return problem;
    }

    @ExceptionHandler(InvalidValueObjectException.class)
    ProblemDetail handleInvalidValueObject(InvalidValueObjectException invalidValueObjectException, HttpServletRequest httpServletRequest) {

        final var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Invalid Value Object");
        problem.setDetail(invalidValueObjectException.getMessage());
        problem.setInstance(URI.create(httpServletRequest.getRequestURI()));

        return problem;
    }

    @ExceptionHandler(PostalCodeInformationAlreadyExistsException.class)
    ProblemDetail handlePostalCodeInformationAlreadyExists(PostalCodeInformationAlreadyExistsException postalCodeInformationAlreadyExistsException, HttpServletRequest httpServletRequest) {

        final var problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Postal Code Information Already Exists");
        problem.setDetail(postalCodeInformationAlreadyExistsException.getMessage());
        problem.setInstance(URI.create(httpServletRequest.getRequestURI()));

        return problem;
    }

}