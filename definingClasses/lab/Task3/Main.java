package javaAdvanced.definingClasses.lab.Task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            if (command[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");
            } else if (command[0].equals("Deposit")) {
                if (bankAccounts.containsKey(Integer.parseInt(command[1]))) {
                    bankAccounts.get(Integer.parseInt(command[1])).deposit(Double.parseDouble(command[2]));
                    System.out.println("Deposited " + command[2] + " to ID" + Integer.parseInt(command[1]));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(command[1]));
            } else if (command[0].equals("GetInterest")) {
                if (bankAccounts.containsKey(Integer.parseInt(command[1]))) {
                    System.out.println(bankAccounts.get(Integer.parseInt(command[1])).getInterest(Integer.parseInt(command[2])));
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scanner.nextLine();
        }


    }
}

