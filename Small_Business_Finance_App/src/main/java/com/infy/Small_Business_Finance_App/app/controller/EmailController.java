package com.infy.Small_Business_Finance_App.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.Small_Business_Finance_App.app.model.Email;
import com.infy.Small_Business_Finance_App.app.serviceI.EmailServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/emailApi")
public class EmailController 
{
	@Autowired
	EmailServiceI emailS;
	
	@Value("${spring.mail.username}")
	private String from_mail;
	

	@PostMapping(value = "/sendMail",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String sendEmail(@RequestPart(value="attachment") MultipartFile atchmnt,
			@RequestPart(value="Email") String email)
	{	
		
		try {
			//json to java file
			ObjectMapper om=new ObjectMapper();
			Email em=om.readValue(email, Email.class);
			System.out.println("to=="+em.getTo());
			
			em.setFrom(from_mail);
			emailS.sendPartAttachmentMail(em,atchmnt);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "can't send attachment mail.";
		}
		return "sent";
	}
	
	@PostMapping(value = "/email")
	public void email(@RequestBody Email mail)
	{
		System.out.println("to=="+mail.getTo());
		mail.setFrom(from_mail);
		emailS.sendEmail(mail);
	}
	
	@PostMapping(value = "/dynamicEmail")
	public void dynmEmail(@RequestBody Email mail)
	{
		System.out.println("to=="+mail.getTo());
		System.out.println("text=="+mail.getText());
		mail.setFrom(from_mail);
		emailS.sendDynamicEmail(mail);
	}
}
