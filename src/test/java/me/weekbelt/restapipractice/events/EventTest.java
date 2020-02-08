package me.weekbelt.restapipractice.events;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    public void builder() throws Exception {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        assertThat(event).isNotNull();
    }

    @DisplayName("basePrice와 maxPrice에 따른 스터디 무료 여부")
    @ParameterizedTest(name = "{index} {displayName}")
    @CsvSource({
            "0, 0, true",
            "100, 0, false",
            "0, 100, false"
    })
    public void testFree(Integer basePrice, Integer maxPrice, Boolean isFree){
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    @DisplayName("스터디 오프라인 or 온라인 여부")
    @ParameterizedTest(name = "{index} {displayName}")
    @CsvSource({
            "강남역 네이버 D2 스타트업 팩토리, true",
            " , false",
            ", false"
    })
    public void testOffline(String location, boolean isOffline) {
        //given
        Event event = Event.builder()
                .location(location)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isEqualTo(isOffline);
    }
}