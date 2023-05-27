import java.util.Scanner;


public class Lab4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input string");
        String input = scan.nextLine();

        StringBuffer stack = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.append('(');
            } else if (input.charAt(i) == ')' && stack.length()> 0 && stack.charAt(stack.length() - 1) == ')') {
                stack.append(')');
            } else if (input.charAt(i) == ')' && stack.length() > 0 &&  stack.charAt(stack.length() - 1) == '(') {
                stack.deleteCharAt(stack.length() - 1);
            } else if (input.charAt(i) == ')') {
                stack.append(')');
            }
        }

        if (stack.length() > 0) {
            System.out.println("Incorrect");
        } else {
            System.out.println("Correct");
        }
    }
}
