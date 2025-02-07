package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

    public static Double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1.0;
    }


	public static Character lexemeToChar(String str) {
		try {
			return checkChar(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return '\0';
	}

	private static Character checkChar(String str) {
		String content = str.substring(1, str.length() - 1);
		String number = "";

		if(content.length() == 1) {
			return content.charAt(0);
		}
		else {
			if(content.equals("\\n")) {
				return '\n';
			}
			if(content.equals("\\t")) {
				return '\t';
			}

			number = content.substring(1, content.length());
			return (char) Integer.parseInt(number);
		}
	}
}
