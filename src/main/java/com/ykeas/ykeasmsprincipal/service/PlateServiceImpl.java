package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.dto.PlateCreateDto;
import com.ykeas.ykeasmsprincipal.model.dto.PlateEditDto;
import com.ykeas.ykeasmsprincipal.model.entity.Category;
import com.ykeas.ykeasmsprincipal.model.entity.Plate;
import com.ykeas.ykeasmsprincipal.repository.CategoryRepository;
import com.ykeas.ykeasmsprincipal.repository.PlateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlateServiceImpl implements IPlateService {

    private PlateRepository plateRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<Plate> index(String name) {
        return plateRepository.findAllByEnabledIsTrueAndNameContains(name);
    }

    @Override
    public Plate save(PlateCreateDto request) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);

        Plate plate = new Plate();
        plate.setName(request.getName());
        plate.setPrice(request.getPrice());
        plate.setStock(request.getStock());
        plate.setDescription(request.getDescription());
        plate.setImageUrl(request.getImageUrl());
        plate.setCategory(category);

        return plateRepository.save(plate);
    }

    @Override
    public Plate update(Long idPlate, PlateEditDto request) {
        Plate plate = plateRepository.findById(idPlate).orElse(null);
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);

        if(plate != null){
            plate.setName(request.getName());
            plate.setPrice(request.getPrice());
            plate.setStock(request.getStock());
            plate.setDescription(request.getDescription());
            plate.setImageUrl(request.getImageUrl());
            plate.setCategory(category);
        }
        return plateRepository.save(plate);
    }

    @Override
    public void delete(Long idPlate) {
        Plate plate = plateRepository.findById(idPlate).orElse(null);
        plate.setEnabled(Boolean.FALSE);
        plateRepository.save(plate);
    }
}
