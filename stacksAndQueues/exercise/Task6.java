package javaAdvanced.stacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
//            if (input.length() %2 == 1) {
//                isBalanced = false;
//                break;
//            }
            switch (input.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(input.charAt(i));
                    break;
                default:
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char lastBracket = stack.pop();
                    if (lastBracket == '{' && input.charAt(i) == '}') {
                        break;
                    } else if (lastBracket == '[' && input.charAt(i) == ']') {
                        break;
                    } else if (lastBracket == '(' && input.charAt(i) == ')') {
                        break;
                    } else {
                        isBalanced = false;
                        break;
                    }

            }

        }
        if (isBalanced) {
            System.out.println("YES");

        } else {
            System.out.println("NO");
        }


    }
}
