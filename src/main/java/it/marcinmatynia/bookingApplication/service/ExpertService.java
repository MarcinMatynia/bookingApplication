package it.marcinmatynia.bookingApplication.service;

import it.marcinmatynia.bookingApplication.dto.ExpertDTO;
import it.marcinmatynia.bookingApplication.exception.InvalidFieldsException;
import it.marcinmatynia.bookingApplication.exception.InvalidIdException;
import it.marcinmatynia.bookingApplication.model.Expert;
import it.marcinmatynia.bookingApplication.repository.ExpertRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class ExpertService {

    private final ExpertRepository expertRepository;
    private final SmartValidator smartValidator;

    public List<ExpertDTO> getAllExpert() {
        var experts = expertRepository.findAll();
        var expertsDTO = new ArrayList<ExpertDTO>();

        experts.forEach(expert -> expertsDTO.add(mapExpertToExpertDto(expert)));

        return expertsDTO;
    }

    public ExpertDTO createNewExpert(ExpertDTO toCreate, Errors errors) {
        smartValidator.validate(toCreate, errors);
        if (errors.hasErrors()) {
            throw new InvalidFieldsException(errors.getFieldErrors());
        }

        var expert = expertRepository.save(mapExpertDtoToExpert(toCreate));
        log.info("Expert with id: " + expert.getId() + " was created");

        return toCreate;
    }

    public void deleteExpertById(int id) {
        if (!expertRepository.existsById(id)) {
            throw new InvalidIdException(id);
        }
        expertRepository.deleteById(id);
    }

    private Expert mapExpertDtoToExpert(final ExpertDTO toCreate) {
        return new Expert(toCreate.getName(), toCreate.getSurname());
    }

    private ExpertDTO mapExpertToExpertDto(final Expert expert) {
        return ExpertDTO.builder()
                .name(expert.getName())
                .surname(expert.getSurname())
                .build();
    }
}
