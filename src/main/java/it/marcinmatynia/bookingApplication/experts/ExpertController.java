package it.marcinmatynia.bookingApplication.experts;

import it.marcinmatynia.bookingApplication.tools.HasLogger;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/experts")
class ExpertController implements HasLogger {

    private final ExpertService expertService;

    @GetMapping
    ResponseEntity<List<Expert>> readAllExpert() {
        var experts = expertService.getAllExpert();
        getLogger().info("Exposing all experts.");
        return new ResponseEntity<>(experts, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Expert> createExpert(@RequestBody Expert toCreate, @ApiIgnore Errors errors) {
        var expert = expertService.createNewExpert(toCreate, errors);
        getLogger().info("Expert with id: " + expert.getId() + " was created");
        return new ResponseEntity<>(expert, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteExpert(@PathVariable int id) {
        expertService.deleteExpertById(id);
        getLogger().info("Expert with id: " + id + " was deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
