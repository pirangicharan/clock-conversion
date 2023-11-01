package com.ramcharan.Alien_Clock.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import static com.ramcharan.Alien_Clock.constants.ConversionConstants.*;

@Service
public class AlienClockService {

    private final Date date = new Date();
    private final int totalEarthSeconds = (int) (date.getTime() / 1000);
    // Alien epoch time 02:02:88
    private final int epochAlienSeconds = (ALIEN_EPOCH_HOURS * ALIEN_MINUTES_PER_HOUR * ALIEN_SECONDS_PER_MINUTE)
            + (ALIEN_EPOCH_MINUTES * ALIEN_SECONDS_PER_MINUTE)
            + ALIEN_EPOCH_SECONDS;

    private int calculateTotalAlienSeconds(){
        int actualAlienSeconds = (int) (totalEarthSeconds * EARTH_TO_ALIEN_CONVERSION_RATIO);

        return epochAlienSeconds + actualAlienSeconds;
    }
    public String alienTime(){
        int totalAlienSeconds = calculateTotalAlienSeconds();
        int totalAlienSecondsToday = totalAlienSeconds % ALIEN_SECONDS_IN_A_DAY;
        int totalAlienMinutesToday = totalAlienSecondsToday / ALIEN_SECONDS_PER_MINUTE;
        int totalAlienHoursToday = totalAlienMinutesToday / ALIEN_MINUTES_PER_HOUR;
        int remainingAlienMinutes = totalAlienMinutesToday % ALIEN_MINUTES_PER_HOUR;
        int remainingAlienSeconds = totalAlienSecondsToday % ALIEN_SECONDS_PER_MINUTE;

        String hours = String.format("%02d", totalAlienHoursToday);
        String minutes = String.format("%02d", remainingAlienMinutes);
        String seconds = String.format("%02d", remainingAlienSeconds);

        return hours + ": " + minutes + ": " + seconds;
    }
    @Async
    public CompletableFuture<String> calculateAlienTimeAsync(){
        String alienTime = alienTime();
        return CompletableFuture.completedFuture(alienTime);
    }
    public String alienDate(){
        int totalAlienSeconds = calculateTotalAlienSeconds();
        int totalAlienDays = totalAlienSeconds / ALIEN_SECONDS_IN_A_DAY;
        //System.out.println("totalAlienDays: " + totalAlienDays);
        int totalAlienYears = totalAlienDays / ALIEN_DAYS_IN_A_YEAR;

        //Alien epoch date 2804-18-31
        int correctedAlienYear = ALIEN_EPOCH_YEAR + totalAlienYears;

        int remainingDays = totalAlienDays % ALIEN_DAYS_IN_A_YEAR;
        int currentAlienMonth = ALIEN_EPOCH_MONTH;
        int currentAlienDay = ALIEN_EPOCH_DAY;
        boolean timeReached = false;

        for (int i=0; i < ALIEN_MONTHS_IN_A_YEAR; i++){
            //start with 17th index i.e., 18th month
            int daysInCurrentAlienMonth = DAYS_IN_ALIEN_MONTHS[currentAlienMonth-1];
            int daysToFill = daysInCurrentAlienMonth - currentAlienDay + 1;

            if (remainingDays >= daysToFill){
                remainingDays -= daysToFill;
                currentAlienDay = 1;
            }
            else {
                if (!timeReached){
                    currentAlienMonth++;

                    if (currentAlienMonth > ALIEN_MONTHS_IN_A_YEAR){
                        currentAlienMonth = 1;
                    }
                }else {
                    break;
                }
            }
            if (currentAlienMonth == 18
                    && (currentAlienDay == 31
                    || totalAlienSeconds >= epochAlienSeconds)){
                timeReached = true;
            }
        }
        String year = String.format("%04d", correctedAlienYear);
        String month = String.format("%02d", currentAlienMonth);
        String day = String.format("%02d", remainingDays);


        return year + "-" + month + "-" + day;
    }
    @Async
    public CompletableFuture<String> calculateAlienDateAsync(){
        String alienDate = alienDate();
        return CompletableFuture.completedFuture(alienDate);
    }

    public String earthDate(){
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dataFormat.format(date);
    }

    @Async
    public CompletableFuture<String> calculateEarthDateAsync(){
        String earthDate = earthDate();
        return CompletableFuture.completedFuture(earthDate);
    }
    public String earthTime(){
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh: mm: ss");
        return timeFormat.format(date);
    }
    @Async
    public CompletableFuture<String> calculateEarthTimeAsync(){
        String earthTime = earthTime();
        return CompletableFuture.completedFuture(earthTime);
    }
}
