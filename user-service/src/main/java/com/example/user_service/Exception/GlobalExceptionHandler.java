package com.example.user_service.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
	        ApiError error = new ApiError(
	                HttpStatus.NOT_FOUND.value(),
	                ex.getMessage(),
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiError> handleGeneral(Exception ex) {
	        ApiError error = new ApiError(
	                HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                ex.getMessage(),
	                LocalDateTime.now()
	        );
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}





