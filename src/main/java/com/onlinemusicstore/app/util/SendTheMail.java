package com.onlinemusicstore.app.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendTheMail {
	
	RestTemplate  restTemplate = new RestTemplate();
	
	public Email mailSending(String email) {
		System.out.println("send the mail " + email);
	 Email sendMail = restTemplate.getForObject("http://localhost:9090/sendmail/"+email,Email.class);
	return sendMail;
	}

}
