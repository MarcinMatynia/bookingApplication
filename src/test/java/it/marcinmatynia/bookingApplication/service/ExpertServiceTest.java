package it.marcinmatynia.bookingApplication.service;

import it.marcinmatynia.bookingApplication.dto.ExpertDTO;
import it.marcinmatynia.bookingApplication.model.Expert;
import it.marcinmatynia.bookingApplication.repository.ExpertRepository;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExpertServiceTest {
    @Test
    void shouldReturnAllExpertsWhenCalledMethodGetAllExpert() {
        //given
        var repository = mock(ExpertRepository.class);
        var serviceToTest = new ExpertService(repository, null);
        var mockExpertList = new ArrayList<Expert>();
        mockExpertList.add(new Expert());
        mockExpertList.add(new Expert());

        //when
        when(repository.findAll()).thenReturn(mockExpertList);
        var result = serviceToTest.getAllExpert();

        //then
        assertEquals(2, result.size());
    }

    @Test
    void shouldCreatedNewExpertWhenDataWasCorrect() {
        //given
        var expertDTO = ExpertDTO.builder()
                .name("John")
                .surname("Alpha")
                .build();
        var repository = mock(ExpertRepository.class);
        var smartValidator = mock(SmartValidator.class);
        var serviceToTest = new ExpertService(repository, smartValidator);

        //when
        when(repository.save(any(Expert.class))).thenReturn(new Expert());
        var result = serviceToTest.createNewExpert(expertDTO, mock(Errors.class));

        //then
        assertEquals(result, expertDTO);
    }
}