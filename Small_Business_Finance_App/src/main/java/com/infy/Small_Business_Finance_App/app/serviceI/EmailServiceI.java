package com.infy.Small_Business_Finance_App.app.serviceI;

import org.springframework.web.multipart.MultipartFile;

import com.infy.Small_Business_Finance_App.app.model.Email;

public interface EmailServiceI {

	public void sendPartAttachmentMail(Email em, MultipartFile atchmnt);

	public void sendEmail(Email mail);
	
	public void sendDynamicEmail(Email mail);

}
