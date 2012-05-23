package br.org.quiz.model.util;

public class MailValidator {

	private static final String VALID_MAIL_REGEX = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";

	public static boolean validMail(String mail) {
		return mail.toUpperCase().matches(VALID_MAIL_REGEX);
	}
}
