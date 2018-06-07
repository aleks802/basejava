package com.urise.webapp;

import java.util.Scanner;

public class MyUtilScanner {

    final static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static long getLong() {
        return Long.parseLong(scanner.nextLine());
    }

}
