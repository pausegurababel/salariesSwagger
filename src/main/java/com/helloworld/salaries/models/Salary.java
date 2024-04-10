package com.helloworld.salaries.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class Salary {
    @Schema(description = "id del salario")
    private int id;
    @Schema(description = "codigo del empleado")
    private String codempleado;
    @Schema(description = "Coste de la hora")
    private double costehora;
    @Schema(description = "Nombre del empleado")
    private String nombreempleado;
    @Schema(description = "Salario mensual")
    private Double salary;
    @Schema(description = "Mes")
    private int salarymonth;
    @Schema(description = "Año")
    private int salaryyear;

}
