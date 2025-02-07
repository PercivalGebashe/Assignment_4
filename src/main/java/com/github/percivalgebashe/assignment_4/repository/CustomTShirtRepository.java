package com.github.percivalgebashe.assignment_4.repository;

import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomTShirtRepository {

    List<TShirt> getTShirtsByFilters(TShirtFilterDTO filterDTO);
}
