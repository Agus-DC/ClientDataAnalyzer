package com.challenge.client.repository;

import com.challenge.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT AVG(age) FROM Client", nativeQuery = true)
    Double getAverage();

    @Query(value = "SELECT STDDEV(age) FROM Client", nativeQuery = true)
    Double getStandardDeviation();

}
