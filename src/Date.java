import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;

/**
 * Created by Владислав on 18.04.2017.
 */
public interface Date {
    public static void main(String[] args) {
        SimpleDateFormat date= new SimpleDateFormat( "dd.MM.yyyy");
        Calendar calendar=Calendar.getInstance();
        String currentDate = "Текущая дата"+date.format(calendar.getTime());
        System.out.println(currentDate);
        calendar.add(Calendar.DATE,4);
        String newDate=currentDate.replace(currentDate, "Дата покупки"+date.format(calendar.getTime()));
        System.out.println(newDate);

    }

}
