package utilty;

import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {

    public void getCurrentDate(WebDriver driver, String format) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        String todayDate = today.format(formatter);
        System.out.println(todayDate);
    }

    public void getCurrentTime(WebDriver driver, String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = now.format(formatter);
        System.out.println(currentDateTime);
    }

    public static String getTodayDate(WebDriver driver, String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

}
