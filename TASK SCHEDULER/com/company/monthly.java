package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class monthly {
    public static void scheduleTask() {
        Timer timer = new Timer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the day of the month: ");
        int dayOfMonth = scanner.nextInt();

        System.out.print("Enter the time of day to perform the task (format: HH:mm:ss): ");
        String timeStr = scanner.next();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date now = new Date();
            Date scheduledTime = new Date(now.getYear(), now.getMonth(), dayOfMonth);
            Date time = dateFormat.parse(timeStr);
            scheduledTime.setHours(time.getHours());
            scheduledTime.setMinutes(time.getMinutes());
            scheduledTime.setSeconds(time.getSeconds());

            long delay = scheduledTime.getTime() - now.getTime();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Perform the monthly task
                    System.out.println("Performing the monthly task...");
                }
            }, delay, 30 * 24 * 60 * 60 * 1000); // Run every 30 days (approximately)

        } catch (ParseException e) {
            System.out.println("Invalid time format entered.");
        }
    }
}
