package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the period (onetime/daily/weekly/monthly): ");
        String period = scanner.nextLine();

        switch (period) {
            case "onetime":
                onetime.scheduleTask();
                break;
            case "daily":
                Daily.scheduleTask();
                break;
            case "weekly":
                weekly.scheduleTask();
                break;
            case "monthly":
                monthly.scheduleTask();
                break;
            default:
                System.out.println("Invalid period entered.");
                break;
        }
    }
}

