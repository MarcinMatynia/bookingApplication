package it.marcinmatynia.bookingApplication.controller;

import it.marcinmatynia.bookingApplication.dto.ExpertDTO;
import it.marcinmatynia.bookingApplication.model.Expert;
import it.marcinmatynia.bookingApplication.repository.ExpertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("e2e")
class ExpertControllerE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    ExpertRepository expertRepository;

    @Test
    void shouldReturnAllExpertWhenHttpGetWasCalled() {
        //given
        expertRepository.save(new Expert("foo", "foo"));
        expertRepository.save(new Expert("bar", "bar"));

        //when
        var experts = testRestTemplate.getForObject("http://localhost:" + port + "/experts", ExpertDTO[].class);

        //then
        assertThat(experts).hasSize(2);
    }

    @Test
    void shouldCreateExpertWhenHttpPostWasCalled() {
        //given
        var expertDTO = ExpertDTO.builder()
                .name("foo")
                .surname("bar")
                .build();

        //when
        var experts = testRestTemplate.postForEntity("http://localhost:" + port + "/experts", expertDTO, ExpertDTO.class);

        //then
        assertEquals(HttpStatus.CREATED, experts.getStatusCode());
        Arrays.stream(testRestTemplate.getForObject("http://localhost:" + port + "/experts", ExpertDTO[].class))
                .findFirst()
                .ifPresent(expertFromDB -> assertEquals("foo", expertFromDB.getName()));
    }

    @Test
    void shouldDeleteExpertWhenHttpDeleteWithCorrectIdWasCalled() {
        //given
        expertRepository.save(new Expert("foo", "foo"));

        //when
        testRestTemplate.delete("http://localhost:" + port + "/experts/1");

        //then
        assertThat(testRestTemplate.getForObject("http://localhost:" + port + "/experts", ExpertDTO[].class)).isEmpty();

    }

}