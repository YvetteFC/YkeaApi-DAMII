package com.ykeas.ykeasmsprincipal.controller;

import com.ykeas.ykeasmsprincipal.model.dto.PlateCreateDto;
import com.ykeas.ykeasmsprincipal.model.dto.PlateEditDto;
import com.ykeas.ykeasmsprincipal.model.entity.Plate;
import com.ykeas.ykeasmsprincipal.model.request.PlateCreateRequest;
import com.ykeas.ykeasmsprincipal.model.request.PlateEditRequest;
import com.ykeas.ykeasmsprincipal.service.IPlateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/platos")
public class PlateController {

    private IPlateService plateService;

    @GetMapping("/listado/{name}")
    public List<Plate> index(@PathVariable String name) {
        return plateService.index(name);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Plate> store(@Validated @RequestBody PlateCreateRequest request){
        Plate newPlate = plateService.save(PlateCreateDto.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .categoryId(request.getCategoryId())
                .build());

        return new ResponseEntity<>(newPlate, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{idPlate}")
    public ResponseEntity<Plate> update (@Validated @RequestBody PlateEditRequest request, @PathVariable Long idPlate) {
        Plate editPlate = plateService.update(idPlate, PlateEditDto.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .categoryId(request.getCategoryId())
                .build());

        return new ResponseEntity<>(editPlate, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idPlate}")
    public ResponseEntity<Void> delete (@PathVariable Long idPlate) {
        plateService.delete(idPlate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
