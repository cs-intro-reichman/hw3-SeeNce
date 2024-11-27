/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2= preProcess(str2);
		String tempStr1 = "";
		String tempStr2 = "";
		for(int i='a';i<='z';i++)
		{
			for(int j1=0; j1<str1.length(); j1++)
			{
				if(str1.charAt(j1) == i)
					tempStr1+=i;
			}
			for(int j2=0; j2<str2.length(); j2++)
			{
				if(str2.charAt(j2) == i)
					tempStr2+=i;
			}
		}
		return tempStr1.equals(tempStr2);
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr="";
		for(int i=0;i<str.length();i++)
		{
			if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) == ' '))
				newStr+=str.charAt(i);
		}   
		return newStr.toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		str = preProcess(str);
		String newStr = ""; 
		String seq = ""; 
	
		for (int i=0; i<str.length(); i++) {	
			int rand = 0;
			boolean flag = false;
	
			while (!flag) {
				rand = (int) (Math.random() * str.length()); 
				boolean secFlag = true;
	
				for (int j=0; j<seq.length(); j++) {
					if (seq.charAt(j) - '0' == rand) { 
						secFlag = false;
						break;
					}
				}
	
				if (secFlag) {
					seq += (char) ('0' + rand); 
					flag = true;
				}
			}
		}
	
		for (int i=0; i<seq.length(); i++) {
			int currentPos = seq.charAt(i) - '0'; 
			newStr += str.charAt(currentPos);    
		}
	
		return newStr;
	}
}
	