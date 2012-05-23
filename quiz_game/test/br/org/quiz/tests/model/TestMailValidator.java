package br.org.quiz.tests.model;

import junit.framework.Assert;

import org.junit.Test;

import br.org.quiz.model.util.MailValidator;

public class TestMailValidator {

	@Test
	public void textValidMail() {
		
		String[] mailList = new String[]{"ma@hotmail.com",
									     "matheus.binotto@xoming.com",
									     "matheus_bin@gmail.com.br"};
		
		for(String mail : mailList) {
			
			System.out.println("Testando " + mail);
			Assert.assertTrue( MailValidator.validMail(mail) );
		}
	}
	
	@Test
	public void testInvalidMails() {
		
		String[] mailList = new String[]{"matheusbinottohotmail.com",
									     "matheus.binotto@xoming",
									     "@gmail.com.br"};

		for(String mail : mailList) {
		
			System.out.println("Testando " + mail);
			Assert.assertFalse( MailValidator.validMail(mail) );
		}
	}
}
