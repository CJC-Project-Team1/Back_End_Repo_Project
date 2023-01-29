package com.infy.Small_Business_Finance_App.app.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
			mhelp.setText("\nDear "+em.getBorrowerName()+"\nLoan Application No= "+em.getApplicationNo()+","
					+ "\n\n Congratulations!!"
					+"\n We are pleased to approve your loan application."+","
					+"\n The loan amount is="+em.getLoanAmount()+"rs,"
					+"\n The term is ="+em.getTenure()+"years,and the annual interest rate is ="+em.getIntRate()+"%."
					+"\n Here is the generated Sanctioned letter ,"
					+"\n Please see the Attachment for details. "
					+ "\n Please visit branch for any Query or contact Branch Manager ."
					+ "\n Thank You !"
					+ "\n\n Regards,"
					+ "\n MSME Loans");
			mhelp.addAttachment(atchmnt.getOriginalFilename(), atchmnt);
			jms.send(mimemsg);
			
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}

	
	@Override
	public void sendDynamicEmail(Email mail)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());
		message.setSubject(mail.getSubject());
		message.setText(mail.getText());
		jms.send(message);
	}

	@Override
	public void sendEmail(Email mail) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());
		message.setSubject(mail.getSubject());
		message.setText("\nDear "+mail.getBorrowerName()+"\nLoan Application No= "+mail.getApplicationNo()+","
				+"\n We are sorry to inform you that your loan request has been rejected."
				+"\n As your cibil score doesn't fall under requirements."
				+ "\n Please visit branch for any Query or contact Branch Manager ."
				+ "\n Thank You !"
				+ "\n\n Regards,"
				+ "\n MSME Loans");
		jms.send(message);
	}

}
