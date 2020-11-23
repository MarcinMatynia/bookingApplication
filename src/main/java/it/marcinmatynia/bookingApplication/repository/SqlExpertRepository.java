package it.marcinmatynia.bookingApplication.repository;

import it.marcinmatynia.bookingApplication.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlExpertRepository extends ExpertRepository, JpaRepository<Expert, Integer> {
}
