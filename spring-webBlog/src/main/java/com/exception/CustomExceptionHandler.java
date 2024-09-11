package com.exception;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<Object> handleHeaderException(Exception ex,WebRequest wr){
		List<String> details=new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse er=new ErrorResponse(details,"OOPS...serverside error!");
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
		
	}

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handleServerrException(Exception ex, WebRequest wr) {
//		List<String> details = new ArrayList<String>();
//		details.add(ex.getLocalizedMessage());
//		ErrorResponse er = new ErrorResponse(details, "OOPS...serverside error!");
//		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
//
//	}
	
}
