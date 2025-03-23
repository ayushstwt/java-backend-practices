package com.ayshriv.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException(String resourceName,String fieldName,String fieldValue) {
        super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
    }
}
