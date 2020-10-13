package it.marcinmatynia.bookingApplication.experts;

import it.marcinmatynia.bookingApplication.exception.InvalidFieldsException;
import it.marcinmatynia.bookingApplication.exception.InvalidIdException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import java.util.List;

@AllArgsConstructor
@Service
class ExpertService {

    private final ExpertRepository expertRepository;
    private final SmartValidator smartValidator;

    List<Expert> getAllExpert() {
        return expertRepository.findAll();
    }

    Expert createNewExpert(Expert toCreate, Errors errors) {
        smartValidator.validate(toCreate, errors);
        if(errors.hasErrors()){
            throw new InvalidFieldsException(errors.getFieldErrors());
        }
        return expertRepository.save(toCreate);
    }

    void deleteExpertById(int id) {
        if(!expertRepository.existsById(id)){
            throw new InvalidIdException(id);
        }
        expertRepository.deleteById(id);
    }
}
