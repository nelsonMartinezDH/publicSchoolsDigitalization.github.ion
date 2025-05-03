package com.web.colegiofdps.Entities;

public enum EstadoMatricula {
    PENDIENTE,
    APROBADA,
    RECHAZADA;

    public static EstadoMatricula fromString(String value) {
        return switch (value.toUpperCase()) {
            case "PENDIENTE" -> PENDIENTE;
            case "APROBADA" -> APROBADA;
            case "RECHAZADA" -> RECHAZADA;
            default -> throw new IllegalArgumentException("Estado de matricula invalido: " + value);
        };
    }
}
