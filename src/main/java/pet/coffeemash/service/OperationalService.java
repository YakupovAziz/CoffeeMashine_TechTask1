package pet.coffeemash.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pet.coffeemash.dto.PublicHolidayDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class OperationalService {

    private RestTemplate restTemplate;

    private final Set<LocalDate> holidays = new HashSet<>();

    public boolean isWorkingHours() {
        return isCoffeeMachineOperational();
    }

    private boolean isCoffeeMachineOperational(){
        LocalDateTime now = LocalDateTime.now();
        LocalDate currentDate = now.toLocalDate();
        LocalTime currentTime = now.toLocalTime();

        if (currentTime.isBefore(LocalTime.of(8, 0)) || currentTime.isAfter(LocalTime.of(17, 0))) {
            return false;
        }

        if(isWeekend(currentDate)){
            return false;
        }

        if (isHoliday(currentDate)){
            return false;
        }
        return true;
    }

    private boolean isWeekend(LocalDate currentDate) {
        return currentDate.getDayOfWeek().getValue() >= 6;
    }

    private boolean isHoliday(LocalDate date) {
        if(holidays.isEmpty()){
            fetchHolidays();
        }
        return holidays.contains(date);
    }

    public void fetchHolidays(){
        String URL = "https://date.nager.at/api/v3/PublicHolidays/2025/KZ";
        PublicHolidayDto[] publicHolidays = restTemplate.getForObject(URL, PublicHolidayDto[].class);
        if (publicHolidays != null) {
            for(PublicHolidayDto holiday : publicHolidays){
                holidays.add(holiday.getDate());
            }
        }
    }

}
