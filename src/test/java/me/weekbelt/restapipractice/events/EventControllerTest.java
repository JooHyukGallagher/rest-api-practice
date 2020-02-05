package me.weekbelt.restapipractice.events;

import me.weekbelt.restapipractice.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EventControllerTest extends BaseControllerTest {
    @Autowired
    EventController eventController;

    @Override
    protected Object controller() {
        return eventController;
    }

    @Test
    public void createEvent() throws Exception {
        //given

        //when
        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaTypes.HAL_JSON))
                .andExpect(status().isCreated())
        ;
        //then
    }
}
