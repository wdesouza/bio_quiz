package br.org.quiz.database.util;

public class SQLUtils {

	public static String formatMatchAnyLowerCase(String expression) {
		if(expression == null) return "%%";
		return "%" + expression.toLowerCase() + "%";
	}

}
