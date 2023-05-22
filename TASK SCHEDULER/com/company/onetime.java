package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class onetime {
    public static void scheduleTask() {
        Timer timer = new Timer();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the start date (format: dd-MM-yyyy HH:mm:ss): ");
        String startDateStr = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date startDate = dateFormat.parse(startDateStr);
            long delay = startDate.getTime() - System.currentTimeMillis();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // Perform the onetime task
                    System.out.println("Performing the onetime task...");
                }
            }, delay);
        } catch (ParseException e) {
            System.out.println("Invalid date format entered.");
        }
    }
}



