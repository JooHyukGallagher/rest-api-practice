package me.weekbelt.restapipractice.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;

@Component
public class EventValidator {
    public void validate(EventDto eventDto, BindingResult bindingResult) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            bindingResult.rejectValue("basePrice", "wrongValue", "BasePrice is wrong");
            bindingResult.rejectValue("maxPrice", "wrongValue", "MaxPrice is wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
        endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
        endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            bindingResult.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong");
        }

        // TODO BeingEventDateTime
        // TODO CloseEnrollmentDateTime
    }
}
