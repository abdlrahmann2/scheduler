package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Daily {
    public static void scheduleTask() {
        Timer timer = new Timer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time of day to perform the task (format: HH:mm:ss): ");
        String timeStr = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date time = dateFormat.parse(timeStr);
            Date now = new Date();
            Date scheduledTime = new Date(now.getYear(), now.getMonth(), now.getDate(), time.getHours(), time.getMinutes(), time.getSeconds());
            long delay = scheduledTime.getTime() - now.getTime();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Perform the daily task
                    System.out.println("Performing the daily task...");
                }
            }, delay, 24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            System.out.println("Invalid time format entered.");
        }
    }
}

