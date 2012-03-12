package org.rodrigoramalho.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoUtil {

	private ValidacaoUtil(){}

	public static void validate(String regex, String text, String textException) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);

		if (!matcher.find()){
			throw new IllegalArgumentException(textException);

		}
	}

	public static boolean isMenorQueZero(Integer... inteiros){
		for (Integer x : inteiros) {
			if (x < 0)
				return true;
		} 

		return false;
	}
}
