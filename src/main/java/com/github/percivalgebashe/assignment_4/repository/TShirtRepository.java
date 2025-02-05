package com.github.percivalgebashe.assignment_4.repository;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtIdDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TShirtRepository extends JpaRepository<TShirt, String> {
    @Query("SELECT shirt FROM TShirt shirt WHERE shirt.id = :id")
    Optional<TShirt> findById(@Param("id") String id);
//    List<TShirtDTO> findAll(List<TShirtIdDTO> idsDTOList);
}