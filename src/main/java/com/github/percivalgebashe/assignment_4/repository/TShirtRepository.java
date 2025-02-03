package com.github.percivalgebashe.assignment_4.repository;

import com.github.percivalgebashe.assignment_4.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Long> {

    // Example query methods:
    List<TShirt> findByColour(@Param("colour") String colour);
    List<TShirt> findBySize(@Param("size") char size);
    List<TShirt> findByGender(@Param("gender") char gender);
    List<TShirt> findByColourAndSizeAndGender(@Param("colour") String colour,
                                              @Param("size") char size,
                                              @Param("gender") char gender);


}
