package PatternMatching;

public class PatternMatching {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);

		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = match(s1, s2);
		if (index >= 0)
			System.out.println("matched at index " + index);
		else
			System.out.println("unmatched");
	}
	
	public static int match(String s, String pattern) {
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (k == pattern.length())
				return i - pattern.length();
			else {
				if (s.charAt(i) == pattern.charAt(k))
					k++;
				else
					k = 0;
			}
		}
		if (k == pattern.length())
			return s.length() - pattern.length();
		else
			return -1;
	}
}
