package com.web.colegiofdps.Entities;

public enum Sexo {
    MASCULINO,
    FEMENINO;

    public static Sexo fromString(String value) {
        return switch (value.toUpperCase()) {
            case "MASCULINO" -> MASCULINO;
            case "M" -> MASCULINO;
            case "FEMENINO" -> FEMENINO;
            case "F" -> FEMENINO;
            default -> throw new IllegalArgumentException("Sexo inválido: " + value);
        };
    }
}
