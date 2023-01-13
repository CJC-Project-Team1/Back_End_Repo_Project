package com.infy.Small_Business_Finance_App.app.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.infy.Small_Business_Finance_App.app.model.Email;
import com.infy.Small_Business_Finance_App.app.serviceI.EmailServiceI;


@Component
public class EmailServiceImpl implements EmailServiceI
{
	@Autowired
	JavaMailSender jms;



	@Override
	public void sendPartAttachmentMail(Email em, MultipartFile atchmnt) 
	{
		MimeMessage mimemsg=jms.createMimeMessage();
		try 
		{
			MimeMessageHelper mhelp=new MimeMessageHelper(mimemsg,true);
			mhelp.setTo(em.getTo());
			mhelp.setFrom(em.getFrom());
			mhelp.setSubject(em.getSubject());
			mhelp.setText(em.getText());
			mhelp.addAttachment(atchmnt.getOriginalFilename(), atchmnt);
			jms.send(mimemsg);
			
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}



}
