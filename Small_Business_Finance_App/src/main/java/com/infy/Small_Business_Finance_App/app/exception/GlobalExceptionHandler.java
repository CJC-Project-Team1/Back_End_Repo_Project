package com.infy.Small_Business_Finance_App.app.exception;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
	
	@ExceptionHandler(ExceptionById.class)
	public ResponseEntity<ExceptionMsgs> noEnqWithId(ExceptionById e,HttpServletRequest req)
	{
		ExceptionMsgs emsg=new ExceptionMsgs(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR,
				req.getRequestURI());
		
		return new ResponseEntity<ExceptionMsgs>(emsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AlreadyUsedPanNumberException.class)
	public ResponseEntity<ExceptionMsgs> panCardAlreadyExists(AlreadyUsedPanNumberException e,HttpServletRequest req)
	{
		ExceptionMsgs emsg=new ExceptionMsgs(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR,
				req.getRequestURI());
		return new ResponseEntity<ExceptionMsgs>(emsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ExceptionByName.class)
	public ResponseEntity<ExceptionMsgs> noEnqWithName(ExceptionByName e,HttpServletRequest req)
	{
		ExceptionMsgs emsg=new ExceptionMsgs(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR,
				req.getRequestURI());
		
		return new ResponseEntity<ExceptionMsgs>(emsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ExceptionByContactNo.class)
	public ResponseEntity<ExceptionMsgs> noEnqWithContactNo(ExceptionByContactNo e,HttpServletRequest req)
	{
		ExceptionMsgs emsg=new ExceptionMsgs(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				e.getMessage(),
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR,
				req.getRequestURI());
		
		return new ResponseEntity<ExceptionMsgs>(emsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
