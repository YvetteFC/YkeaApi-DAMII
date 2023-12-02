package com.ykeas.ykeasmsprincipal.repository;

import com.ykeas.ykeasmsprincipal.model.entity.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlateRepository extends JpaRepository<Plate, Long> {
    public List<Plate> findAllByEnabledIsTrueAndNameContains(String name);
}
