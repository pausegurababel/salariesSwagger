package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Obtiene los salarios de un empleado por año",
            description = "Devuelve una lista de salarios correspondientes a un empleado y año específico, basado en el código del empleado.")
    @ApiResponse(responseCode = "200", description = "Salarios encontrados exitosamente",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "400", description = "Parámetros incorrectos",
            content = @Content(mediaType = "application/json"))
    public ResponseEntity<?> getSalaryByEmployeeAndYear(@PathVariable String employeeCode, @PathVariable int year) {
        List<Double> salaries = null;
        try {
            salaries = this.employeeService.getSalaryByEmployyeCode(employeeCode, year);
            return ResponseEntity.ok(salaries);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Crea salarios para un empleado y año específico en caso de que no exita la lista previamente",
            description = "Registra una lista de salarios para un empleado dado su código y el año especificado. Devuelve la lista de salarios creados.")
    @ApiResponse(responseCode = "200", description = "Salarios creados exitosamente",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class)))
    @ApiResponse(responseCode = "400", description = "Parámetros incorrectos",
            content = @Content(mediaType = "application/json"))
    public ResponseEntity<?> createSalariesByEmployeeCode(@PathVariable String employeeCode, @PathVariable int year) {
        List<Double> salaries = null;
        try {
            salaries = this.employeeService.createSalariesByEmployeeCode(employeeCode, year);
            return ResponseEntity.ok(salaries);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}