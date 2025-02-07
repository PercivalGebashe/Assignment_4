package com.github.percivalgebashe.assignment_4.repository;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TShirtRepository extends JpaRepository<TShirt, String>, CustomTShirtRepository {

    @Query("SELECT shirt FROM TShirt shirt WHERE shirt.id = :id")
    Optional<TShirt> findById(@Param("id") String id);
}