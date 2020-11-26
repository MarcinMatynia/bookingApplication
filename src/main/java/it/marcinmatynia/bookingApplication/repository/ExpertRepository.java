package it.marcinmatynia.bookingApplication.repository;

import it.marcinmatynia.bookingApplication.model.Expert;

import java.util.List;

public interface ExpertRepository {
    List<Expert> findAll();

    Expert save (Expert entity);

    boolean existsById(Integer id);

    void deleteById(Integer id);
}
