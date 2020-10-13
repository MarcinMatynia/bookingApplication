package it.marcinmatynia.bookingApplication.experts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlExpertRepository extends ExpertRepository, JpaRepository<Expert, Integer> {
}
