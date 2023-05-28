import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Main
{    
    public static void main(String[] args) throws java.text.ParseException {
        //creates a new instance of the Parking class 
        Parking parking = new Parking();
        
        //prompt user to input Registration Number and set the it for the parking instance.
        String input1 = JOptionPane.showInputDialog("vehicle Registration");
        //String input1 = scanner.nextLine();
        parking.setRegNo(input1);
        
        
        //prompt user to input check in date
        String input2 = JOptionPane.showInputDialog("Check-in date(dd-mm-yyyy)");
        
        //prompt user to input check in time
        String input3 = JOptionPane.showInputDialog("Check-in Time (24 hours format) (hh:mm)");
        
        //prompt user to input check out date
        String input4 = JOptionPane.showInputDialog("Check-out date (dd-mm-yyyy)");
        
        //prompt user to input check out time
        String input5 = JOptionPane.showInputDialog("Check-out Time (24 hours format) (hh:mm)");
        
        //parse the input strings into LocalDate objects 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate date1 = LocalDate.parse(input2, formatter);
        LocalDate date2 = LocalDate.parse(input4, formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse(input3, formatter1);
        LocalTime time2 = LocalTime.parse(input5, formatter1);
        
        //Create an instance of the Main class
        Main m = new Main();
        
        //prints the registration number of the parking object 
        System.out.println("Reg No:         " + parking.getRegNo());
        
        //invokes a method named Total()
        m.Total(date1, date2, time1, time2, parking);
    }
                                    
    //method to return the data of duration, date checked in and out and amount to pay
    void Total(LocalDate datee1, LocalDate datee2, LocalTime timee1, LocalTime timee2, Parking parking) throws java.text.ParseException{

        //setting the date and time values for a parking object 
        parking.setDate(datee1);
        parking.setDateL(datee2);
        parking.setTime(timee1);
        parking.setTimeL(timee2);

        //check whether it is weekday
        boolean Weekday = parking.getDate().getDayOfWeek().getValue() < 6;
        
        //make the date and time in simple date format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d HH:mm");
        long diff, diffMinutes, diffHours, diffDays;
        Date d1 = format.parse(parking.DateNtimein());
        Date d2 = format.parse(parking.DateNtimeout());
    
        //in milliseconds
        diff = d2.getTime() - d1.getTime();
        
        //in minutes, hours, days
        diffMinutes = diff / (60 * 1000) % 60;
        diffHours = diff / (60 * 60 * 1000) % 24;
        diffDays = diff / (24 * 60 * 60 * 1000);  
    
        //Define the parking rates
        double weekdayWholeDay = 20.00;
        double weekdayFirst3Hours = 3.00;
        double weekdaySubsequentHour = 1.50; 
        double weekendWholeDay = 40.00;
        double weekendFirst3Hours = 5.00;
        double weekendSubsequentHour = 2.00;
        
        //define total and duration
        double total = 0;
        String duration = "";
        
        //calculate the duration of time and store it in parking.setDuration(duration)
        if(diffDays==0 && diffHours==0){
            duration = diffMinutes + " Minutes";
        }
        else if(diffDays==0){
            duration = diffHours + " Hours " + diffMinutes + " Minutes";
        }
        else{
            duration = diffDays + " days " + diffHours + " Hours " + diffMinutes + " Minutes";
        }
        parking.setDuration(duration);
        
        //Create an instance of the Main class
        Main mn = new Main();
        
        //print check in, check out, duration, 
        System.out.println("In:             " + parking.DateNtimein());
        System.out.println("Out:            " + parking.DateNtimeout());
        System.out.println("Duration:       " + parking.getDuration());
        
        //calculate total amount to pay for weekday and weekend by calling function calculateTotal
        if(Weekday){
            mn.calculateTotal(diffDays, diffHours, diffMinutes, weekdayWholeDay, weekdayFirst3Hours, weekdaySubsequentHour, total);
        }
        else if(!Weekday){
            mn.calculateTotal(diffDays, diffHours, diffMinutes, weekendWholeDay, weekendFirst3Hours, weekendSubsequentHour, total);
        }  
    }
    
    //method to calculate the amount to pay 
    void calculateTotal(long day, long hour, long minutes, double wd, double f3h, double Shour, double total){
        double periodminute = 5;
        if(day==0 && hour==0 && minutes<15){ 
            total = 0;
        }
        else if(minutes>15 && hour<3 && day==0){
            total = f3h;
        }
        else if(hour>=3 && day==0 && minutes<periodminute){            
            if(total < wd){
                total = f3h + ((hour-3) * Shour);
            }
            else{
                total = wd;
            }
        }
        else if(hour>=3 && day<1 && minutes>periodminute){            
            if(total < wd){
                total = f3h + (((hour+1)-3) * Shour);
            }
            else{
                total = wd;
            }
        }
        else{
            System.out.println("no condition found");            
        }
        //print total amount after calculated
        System.out.println("Amount to paid: $" + total);
    }    
}
