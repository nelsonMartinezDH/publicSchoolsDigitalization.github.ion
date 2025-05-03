package com.web.colegiofdps.Entities;

public enum EstadoDocumento {
    PENDIENTE,
    APROBADO,
    RECHAZADO;

    public static EstadoDocumento fromString(String value) {
        return switch (value.toUpperCase()) {
            case "PENDIENTE" -> PENDIENTE;
            case "APROBADO" -> APROBADO;
            case "RECHAZADO" -> RECHAZADO;
            default -> throw new IllegalArgumentException("Estado de documento inválido: " + value);
        };
    }
}
