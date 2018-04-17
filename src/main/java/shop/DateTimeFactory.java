package shop;

import java.time.LocalDateTime;

public class DateTimeFactory {

    private static LocalDateTime testNow;

    private static boolean testing;

    public static void setTest(LocalDateTime testNow) {
        DateTimeFactory.testNow = testNow;
        DateTimeFactory.testing = true;
    }

    public static void stopTest() {
        DateTimeFactory.testing = false;
    }

    public static LocalDateTime getNow() {
        if (testing) {
            return DateTimeFactory.testNow;
        }
        return LocalDateTime.now();
    }

}
