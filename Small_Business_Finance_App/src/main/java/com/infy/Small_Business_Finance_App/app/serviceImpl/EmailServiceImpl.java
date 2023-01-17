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
			mhelp.setText("\nDear "+em.getBorrowerName()+"\nLoan Application No= "+em.getApplicationNo()+","
					+ "\n\n Congratulations!!"
					+"\n We are pleased to approve your home equity loan application."+","
					+"\n The loan amount is="+em.getLoanAmount()+","
					+"\n The term is ="+em.getTenure()+",and the annual interest rate is ="+em.getIntRate()+"."
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

}
