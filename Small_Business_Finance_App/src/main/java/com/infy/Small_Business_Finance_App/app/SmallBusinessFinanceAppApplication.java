package com.infy.Small_Business_Finance_App.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.Small_Business_Finance_App.app.model.Enquiry;

@SpringBootApplication
public class SmallBusinessFinanceAppApplication {

	public static void main(String[] args) {
		System.out.println("Small Business Finance Application is running..");
		SpringApplication.run(SmallBusinessFinanceAppApplication.class, args);
		
		Enquiry e=new Enquiry();
		
	}

}
