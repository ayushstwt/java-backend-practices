package com.ayshriv.cards.exception;

import com.ayshriv.cards.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to handle the global exceptions in the application
 * @author Ayush Shrivastava
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * This method handles the exception when the requested resource is not found
     * @param ex The ResourcesNotFoundException object
     * @param webRequest The WebRequest object
     * @return ResponseEntity with error response
     */
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourcesNotFoundException(ResourcesNotFoundException ex,
                                                                   WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorMessage(ex.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setErrorCode(HttpStatus.NOT_FOUND);
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }

    /**
     * This method handles the exception when the card already exists
     * @param ex The CardAlreadyExistException object
     * @param webRequest The WebRequest object
     * @return ResponseEntity with error response
     */
    @ExceptionHandler(CardAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCardAlreadyExistException(CardAlreadyExistException ex,
                                                                   WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorMessage(ex.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles the global exception
     * @param ex The Exception object
     * @param webRequest The WebRequest object
     * @return ResponseEntity with error response
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex,
                                                                   WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setErrorMessage(ex.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponseDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();

        objectErrors.forEach((error)->{
            String field = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(field, errorMessage);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }
}
