package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final AvgSalaryService avgSalaryService;

    public CompanyController(AvgSalaryService avgSalaryService) {
        this.avgSalaryService = avgSalaryService;
    }

    @GetMapping("/salary/{year}/avg")
    @Operation(
            summary = "Media anual de salarios por año",
            description = "Obtiene el promedio de salarios para un año específico proporcionado por el usuario.",
            tags = {"Salario"})
    @ApiResponse(
            responseCode = "200",
            description = "Promedio de salario calculado con éxito",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Double.class)))
    @ApiResponse(
            responseCode = "500",
            description = "Parámetros incorrectos",
            content = @Content(mediaType = "application/json"))
    @Parameter(
            name = "year",
            required = true,
            description = "Año para calcular el promedio de salario",
            example = "2021")
    public ResponseEntity<?> getAvgSalary(@PathVariable int year) {
        Double avgSalary = null;
        try {
            avgSalary = this.avgSalaryService.getAvgSalary(year);
            return ResponseEntity.ok(avgSalary);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
