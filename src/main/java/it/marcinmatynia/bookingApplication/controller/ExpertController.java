package it.marcinmatynia.bookingApplication.controller;

import it.marcinmatynia.bookingApplication.dto.ExpertDTO;
import it.marcinmatynia.bookingApplication.service.ExpertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/experts")
class ExpertController {

    private final ExpertService expertService;

    @GetMapping
    ResponseEntity<List<ExpertDTO>> readAllExpert() {
        var experts = expertService.getAllExpert();
        log.info("Exposing all experts.");
        return new ResponseEntity<>(experts, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ExpertDTO> createExpert(@RequestBody ExpertDTO toCreate, @ApiIgnore Errors errors) {
        var expert = expertService.createNewExpert(toCreate, errors);
        return new ResponseEntity<>(expert, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteExpert(@PathVariable int id) {
        expertService.deleteExpertById(id);
        log.info("Expert with id: " + id + " was deleted.");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

