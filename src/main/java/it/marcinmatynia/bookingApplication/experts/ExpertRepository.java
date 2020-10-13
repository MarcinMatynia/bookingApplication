package it.marcinmatynia.bookingApplication.experts;

import java.util.List;
import java.util.Optional;

interface ExpertRepository {
    List<Expert> findAll();
    Expert save (Expert entity);
    boolean existsById(Integer id);
    Optional<Expert> findById(Integer id);
    void deleteById(Integer id);
}
