package utilty;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateUtil {


    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String ALPHANUMERIC = ALPHABETS + NUMBERS;

    private static final SecureRandom random = new SecureRandom();


    // ---------------- RANDOM STRING ----------------
    public static String randomString(int length) {
        return generateRandom(ALPHABETS, length);
    }

    // ---------------- RANDOM NUMBER ----------------
    public static String randomNumber(int length) {
        return generateRandom(NUMBERS, length);
    }

    // ---------------- RANDOM ALPHANUMERIC ----------------
    public static String randomAlphaNumeric(int length) {
        return generateRandom(ALPHANUMERIC, length);
    }

    // ---------------- CORE GENERATOR ----------------
    private static String generateRandom(String chars, int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return builder.toString();
    }

    // ---------------- RANDOM DOB BETWEEN RANGE ----------------
    public static LocalDate randomDobBetween(
            LocalDate startDate,
            LocalDate endDate) {

        long startEpoch = startDate.toEpochDay();
        long endEpoch = endDate.toEpochDay();

        long randomDay =
                ThreadLocalRandom.current()
                        .nextLong(startEpoch, endEpoch + 1);

        return LocalDate.ofEpochDay(randomDay);
    }

//    // ---------------- DAY ----------------
//    public static String getDay(LocalDate date) {
//        return String.valueOf(date.getDayOfMonth());
//    }
//
//    // ---------------- MONTH (TEXT) ----------------
//    public static String getMonthName(LocalDate date) {
//        return date.getMonth()
//                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);
//    }
//
//    // ---------------- MONTH (NUMBER) ----------------
//    public static String getMonthNumber(LocalDate date) {
//        return String.valueOf(date.getMonthValue());
//    }
//
//    // ---------------- YEAR ----------------
//    public static String getYear(LocalDate date) {
//        return String.valueOf(date.getYear());
//    }


}




