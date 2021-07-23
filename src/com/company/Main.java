package com.company;

import java.util.Scanner;

public class Main {

    private static String menu;

    private static String getMenu(String[] args) {
        StringBuilder builder = new StringBuilder("Available moves:\n");
        if (menu != null) {
            return menu;
        } else {
            for (int i = 1; i <= args.length; i++) {
                builder.append(i).append(" - ").append(args[i - 1]).append('\n');
            }
        }
        builder.append(0).append(" - ").append("exit");
        menu = builder.toString();
        return menu;
    }

    private static boolean checkRange(int computerIndex, int humanIndex, int length) {
        for (int i = humanIndex + 1; i <= humanIndex + length/2; i++) {
            if (i % length == computerIndex) {
                return true;
            }
        }
        return false;
    }

    private static String result(int humanIndex, int computerIndex, int length) {
        return computerIndex == humanIndex ? "Draw!" : checkRange(computerIndex, humanIndex, length) ? "You lose!" : "You win!";
    }


    public static void work(String[] args) {
        String key;
        int choice;
        int index;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            key = KeyAndMoveCodeGenerator.generateKey();
            System.out.println("HMAC: " + KeyAndMoveCodeGenerator.getMoveCode(key, args[(index = (int) (Math.random() * (args.length - 1)))]));
            System.out.println(getMenu(args));
            System.out.print("Enter your move: ");
            choice = scanner.nextInt();
            if (choice <= args.length && choice > 0) System.out.println("Your move: " + args[choice - 1]);
            else if (choice == 0) return;
            else continue;
            System.out.println("Computer move: " + args[index]);
            System.out.println(result(choice - 1, index, args.length));
            System.out.println("HMAC key: " + key + "\n");
        }
    }

    public static void main(String[] args) {
        if (Validator.checkArgsCorrectness(args)) {
            work(args);
        }
    }
}
