package bankingsystem.main;

import bankingsystem.service.BankService;
import bankingsystem.model.Account;
import bankingsystem.model.Transaction;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService service = new BankService();

        while (true) {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Accounts");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Owner Name: ");
                    String owner = scanner.nextLine();
                    service.createAccount(accNum, owner);
                    System.out.println("Account created.");
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    String depAcc = scanner.nextLine();
                    System.out.print("Amount to Deposit: ");
                    double depAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (service.deposit(depAcc, depAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Deposit failed.");
                    }
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    String witAcc = scanner.nextLine();
                    System.out.print("Amount to Withdraw: ");
                    double witAmount = scanner.nextDouble();
                    scanner.nextLine();
                    if (service.withdraw(witAcc, witAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Withdrawal failed. Check balance or account.");
                    }
                    break;

                case 4:
                    for (Account a : service.getAllAccounts()) {
                        System.out.println(a);
                    }
                    break;

                case 5:
                    for (Transaction t : service.getAllTransactions()) {
                        System.out.println(t);
                    }
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
