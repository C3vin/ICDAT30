package INQ;

public class text2speech {
	final String[] specialNames = {
			"",
			" thousand",
			" million",
			" billion",
			" trillion",
			" quadrillion",
			" quintillion"
	};
	final String[] tensNames = {
			"",
			" ten",
			" twenty",
			" thirty",
			" forty",
			" fifty",
			" sixty",
			" seventy",
			" eighty",
			" ninety"
	};
	final String[] numNames = {
			"",
			" one",
			" two",
			" three",
			" four",
			" five",
			" six",
			" seven",
			" eight",
			" nine",
			" ten",
			" eleven",
			" twelve",
			" thirteen",
			" fourteen",
			" fifteen",
			" sixteen",
			" seventeen",
			" eighteen",
			" nineteen"
	};

	public String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20){
			current = numNames[number % 100];
			number /= 100;
		}
		else {
			current = numNames[number % 10];
			number /= 10;

			current = tensNames[number % 10] + current;
			number /= 10;
		}
		System.out.println("@: "+current);
		if (number == 0) return current;
		return numNames[number] + " hundred" + current;
	}

	public String convert(int number) {
		if (number == 0) { return "zero"; }
		String prefix = "";
		if (number < 0) {
			number = -number;
			prefix = "negative";
		}
		String result = "";
		int place = 0;
		//do 
		while(number > 0) {
			int n = number % 1000;
			if (n != 0){
				String s = convertLessThanOneThousand(n);
				result = s + specialNames[place] + result;
			}
			place++;
			number /= 1000;			//deal the rest part
		} //while (number > 0);
		return (prefix + result).trim();
	}
	public static void main(String[] args) {
		text2speech obj = new text2speech();
		System.out.println("*** " + obj.convert(12345));
		System.out.println("*** " + obj.convert(-55));
		System.out.println("*** " + obj.convert(0));
	}
}