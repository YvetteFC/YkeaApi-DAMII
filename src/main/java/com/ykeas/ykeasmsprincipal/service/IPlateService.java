package com.ykeas.ykeasmsprincipal.service;

import com.ykeas.ykeasmsprincipal.model.dto.PlateCreateDto;
import com.ykeas.ykeasmsprincipal.model.dto.PlateEditDto;
import com.ykeas.ykeasmsprincipal.model.entity.Plate;

import java.util.List;

public interface IPlateService {
    public List<Plate> index(String name);
    public Plate save(PlateCreateDto request);
    public Plate update(Long idPlate, PlateEditDto request);
    public void delete(Long idPlate);
}
