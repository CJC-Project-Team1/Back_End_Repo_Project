package com.infy.Small_Business_Finance_App.app.exception;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMsgs 
{
	private int statusCode;
	private String excptnMsg;
	private LocalDateTime date_time;
	private HttpStatus statusMsg;
	private String uri;
	

}
