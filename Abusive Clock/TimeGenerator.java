import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeGenerator {
    GregorianCalendar time = new GregorianCalendar();
    String[] timeName = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    String[] hourName = {"HOUR", "TWENTY", "THIRTY", "FORTY", "FIFTY"};

    public TimeGenerator(){

    }

    public String getHour(){
        return timeName[time.get(Calendar.HOUR)-1];
    }

    public String getMinute(){
        int minute = time.get(Calendar.MINUTE);

        if(minute == 0)
            return hourName[minute];
        else if(minute<20)
            return timeName[minute-1];
        else if(minute%10 == 0)
            return hourName[(minute/10)-1];
        else
            return hourName[(minute/10)-1]+" "+timeName[(minute%10)-1];
    }

}
