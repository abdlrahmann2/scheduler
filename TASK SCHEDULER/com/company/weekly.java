package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class weekly {
    public static void scheduleTask() {
        Timer timer = new Timer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the day of the week (Monday/Tuesday/Wednesday/...): ");
        String dayOfWeekStr = scanner.nextLine();

        System.out.print("Enter the time of day to perform the task (format: HH:mm:ss): ");
        String timeStr = scanner.nextLine();

        try {
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
            Date now = new Date();
            String currentDayOfWeek = dayFormat.format(now);

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date time = timeFormat.parse(timeStr);

            int currentDayOfWeekNum = dayFormat.parse(currentDayOfWeek).getDay();
            int targetDayOfWeekNum = dayFormat.parse(dayOfWeekStr).getDay();

            int daysToAdd = targetDayOfWeekNum - currentDayOfWeekNum;
            if (daysToAdd < 0)
                daysToAdd += 7;

            Date scheduledTime = new Date(now.getTime() + daysToAdd * 24 * 60 * 60 * 1000);
            scheduledTime.setHours(time.getHours());
            scheduledTime.setMinutes(time.getMinutes());
            scheduledTime.setSeconds(time.getSeconds());

            long delay = scheduledTime.getTime() - now.getTime();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Perform the weekly task
                    System.out.println("Performing the weekly task...");
                }
            }, delay, 7 * 24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            System.out.println("Invalid time format entered.");
        }
    }
}

