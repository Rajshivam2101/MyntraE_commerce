package utilty;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DateRangeUtil {

    public static LocalDate randomDobBetween(
            LocalDate startDate,
            LocalDate endDate) {

        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();

        long randomDay = ThreadLocalRandom.current()
                .nextLong(start, end + 1);

        return LocalDate.ofEpochDay(randomDay);
    }

}