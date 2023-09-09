package com.code.blog.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.blog.payloads.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
			String message=ex.getMessage();
			ApiResponse apiResponse=new ApiResponse(message,false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex)
		{
			Map<String,String>res=new HashMap<>();
			ex.getBindingResult().getAllErrors().forEach((error)->
			{
				String message=error.getDefaultMessage();
				//String	fildName=error.getCode();
				String	fildName=((FieldError) error).getField();
				res.put(fildName,message);
			});
			return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
		}
}