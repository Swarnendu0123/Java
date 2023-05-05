import java.time.*;

public class API {
    public static void main(String[] args) {
        
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        
        System.out.println("Today's date is " + day + "/" + month + "/" + year);
        
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        System.out.println("Now time is " + hour + ":" + minute + ":" + second);

    }
}
