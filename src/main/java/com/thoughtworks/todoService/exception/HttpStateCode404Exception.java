package com.thoughtworks.todoService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public  class HttpStateCode404Exception extends  RuntimeException {
}
