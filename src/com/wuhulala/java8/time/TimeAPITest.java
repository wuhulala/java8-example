package com.wuhulala.java8.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public class TimeAPITest {
    @Test
    public void testClock(){
        Clock	clock	=	Clock.systemDefaultZone();
        long	millis	=	clock.millis();
        Instant instant	=	clock.instant();
        Date legacyDate	=	Date.from(instant);			//	legacy	java.util.Date
        System.out.println(legacyDate);
    }
}
