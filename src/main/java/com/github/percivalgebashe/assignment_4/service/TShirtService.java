package com.github.percivalgebashe.assignment_4.service;

import com.github.percivalgebashe.assignment_4.dto.TShirtDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.dto.TShirtIdDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TShirtService{
    List<TShirtDTO> getTShirts();
    List<TShirtDTO> getTShirtsByFilters(TShirtFilterDTO filterDTO);
}