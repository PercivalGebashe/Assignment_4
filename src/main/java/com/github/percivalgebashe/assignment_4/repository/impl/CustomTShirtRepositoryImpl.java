package com.github.percivalgebashe.assignment_4.repository.impl;

import com.github.percivalgebashe.assignment_4.dto.TShirtFilterDTO;
import com.github.percivalgebashe.assignment_4.entity.TShirt;
import com.github.percivalgebashe.assignment_4.repository.CustomTShirtRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomTShirtRepositoryImpl implements CustomTShirtRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TShirt> getTShirtsByFilters(TShirtFilterDTO filterDTO) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<TShirt> criteriaQuery = criteriaBuilder.createQuery(TShirt.class);

        Root<TShirt> root = criteriaQuery.from(TShirt.class);

        List<Predicate> predicates = new ArrayList<>();

        if(filterDTO.getName() != null && !filterDTO.getName().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("name"), filterDTO.getName()));
        }
        if(filterDTO.getColour() != null && !filterDTO.getColour().isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("colour"), filterDTO.getColour()));
        }
        if(filterDTO.getGender() != null && filterDTO.getGender() != 0) {
            predicates.add(criteriaBuilder.equal(root.get("gender"), filterDTO.getGender()));
        }
        if(filterDTO.getSize() != null && filterDTO.getSize() != 0) {
            predicates.add(criteriaBuilder.equal(root.get("size"), filterDTO.getSize()));
        }
        if(filterDTO.getAvailability() != null && filterDTO.getAvailability() != 0) {
            predicates.add(criteriaBuilder.equal(root.get("availability"), filterDTO.getAvailability()));
        }
        if(filterDTO.getMinPrice() != null && filterDTO.getMinPrice() != 0) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filterDTO.getMinPrice()));
        }
        if(filterDTO.getMaxPrice() != null && filterDTO.getMaxPrice() != 0) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), filterDTO.getMaxPrice()));
        }
        if(filterDTO.getMinRating() != null && filterDTO.getMinRating() > 0) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), filterDTO.getMinRating()));
        }
        if(filterDTO.getMaxRating() != null && filterDTO.getMaxRating() <= 5) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("rating"), filterDTO.getMaxRating()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<TShirt> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
