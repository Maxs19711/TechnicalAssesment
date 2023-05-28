import java.time.LocalDate;
import java.time.LocalTime;

public class Parking {
    String RegNo, duration;
    LocalDate Date, DateL;
    LocalTime Time, TimeL;

    public Parking() {

    }

    //setters
    public void setRegNo(String Regn) {
        this.RegNo = Regn;
    }

    public void setDate(LocalDate Datee) {
        this.Date = Datee;
    }

    public void setTime(LocalTime TTime) {
        this.Time = TTime;
    }

    public void setDateL(LocalDate DateeL) { this.DateL = DateeL; }

    public void setTimeL(LocalTime TTimeL) { this.TimeL = TTimeL; }
    
    public void setDuration(String duration) {this.duration = duration;}
    
    //getters
    public String getRegNo() {
        return RegNo;
    }

    public LocalDate getDate() {
        return Date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public LocalDate getDateL() { 
        return DateL; 
    }

    public LocalTime getTimeL() {
        return TimeL;
    }
    
    public String DateNtimein(){
        return getDate() + " " + getTime();
    }
    
    public String getDuration(){
        return duration;
    }
    
    public String DateNtimeout(){
        return getDateL() + " " + getTimeL();
    }
    

}