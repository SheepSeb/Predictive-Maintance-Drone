package sebnae.predictivemaintence;


import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class TimeConverterTest {
    @Test
    public void testTimeConverter() {
        String time = "2024-07-24T14:32:51.297261916+02:00";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(time);
        System.out.println(zonedDateTime);

    }
}
