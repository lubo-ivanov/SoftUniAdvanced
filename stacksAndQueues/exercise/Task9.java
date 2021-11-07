package javaAdvanced.stacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> expression = new ArrayDeque<>();
        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        Arrays.stream(input.split(" ")).forEach(expression::offer);
        while (!expression.isEmpty()) {
            String symbol = expression.poll();
            if (isOperator(symbol)){
                while (operatorStack.peek() != null && hasHigherOrSamePriority(symbol, operatorStack.peek())) {
                    output.offer(operatorStack.pop());
                }
                operatorStack.push(symbol);
            } else if (symbol.equals("(")) {
                operatorStack.push(symbol);
            } else if (symbol.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.offer(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                output.offer(symbol);
            }
        }
        while (!operatorStack.isEmpty()) {
            output.offer(operatorStack.pop());
        }
        output.forEach(e -> System.out.print(e + " "));
    }

    private static boolean hasHigherOrSamePriority(String symbol, String topOperator) {
        return (topOperator.equals("*") || topOperator.equals("/") || symbol.equals("+") || symbol.equals("-")) && !topOperator.equals("(");
    }
    private  static boolean isOperator (String symbol) {
        return symbol.equals("/") || symbol.equals("+") || symbol.equals("-") || symbol.equals("*");
    }
}
