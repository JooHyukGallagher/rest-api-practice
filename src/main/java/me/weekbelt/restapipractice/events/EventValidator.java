package me.weekbelt.restapipractice.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            // 글로벌 에러
            errors.reject("wrongPrices", "Values of Prices are wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
                endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())){
            // 필드 에러
            errors.rejectValue("endEventDateTime", "wrongValue", "EventDateTime is Wrong");
        }

        // TODO : BeginEventDateTime
        // TODO : CloseEnrollementDateTime
    }
}
