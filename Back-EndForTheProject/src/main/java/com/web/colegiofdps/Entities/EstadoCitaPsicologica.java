package com.web.colegiofdps.Entities;

public enum EstadoCitaPsicologica {
    REALIZADA,
    RECHAZADA,
    CANCELADA,
    PENDIENTE;

    public static EstadoCitaPsicologica fromString(String value) {
        return switch (value.toUpperCase()) {
            case "PENDIENTE" -> PENDIENTE;
            case "REALIZADA" -> REALIZADA;
            case "RECHAZADA" -> RECHAZADA;
            case "CANCELADA" -> CANCELADA;
            default -> throw new IllegalArgumentException("Estado de cita psicologica inválida: " + value);
        };
    }

}
