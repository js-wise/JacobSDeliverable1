import java.util.Scanner;
public class passwordCheck {

	public static void mustContain() {
		//print password requirements
		
		System.out.print("Enter a password,");
		System.out.print("\nThe password must contain:\n");
		System.out.println("	- At least one lowercase letter");
		System.out.println("	- At least one uppercase letter");
		System.out.println("	- 7 - 12 characters");
		System.out.println("	- An exclamation point: !");
	}
	
	public static boolean caseCheck(String s) {
		//check if at least one capitol and one lower case character exists in password
		boolean Lower = false;
		boolean Upper = false;
		boolean Result = false;
		
		for (int i=0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			if (Character.isUpperCase(ch))
				Upper = true;
			if (Character.isLowerCase(ch))
				Lower = true;
			if (Upper == true && Lower == true)
				Result = true;
		}
		
		return Result;
	}
	
	public static boolean passCheck(String pw) {
		//checks if password is valid
		boolean val = false;
		
		if (pw.length() < 7 || pw.length() > 12) {
			System.out.println("Error: password must be 7 - 12 characters");
		
		} else if (pw.contains("!") == false) {
			System.out.println("Error: password must contain an exclaimation point: !");
		
		} else if (caseCheck(pw) == false) {
			System.out.println("Error: password must contain at least:");
			System.out.println("	-one uppercase character");
			System.out.println(" 	-one lowercase character");
		
		} else {
			System.out.println("Password valid and\r\n" + "accepted");
			val = true;
		}	
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		boolean valid = false;
		
		mustContain();
		
		while (valid != true) {
			//loop to ask for password again if not valid
			System.out.println("Password: ");
			String password = scn.nextLine();//get password input
			valid = passCheck(password);
		}
		
		System.out.println("\nEntry complete.");
		if (scn != null)
			scn.close();
	}
}
