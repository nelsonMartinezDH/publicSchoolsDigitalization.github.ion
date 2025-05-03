package com.web.colegiofdps.Entities;

public enum EstadoNotificacion {
    LEIDA,
    NO_LEIDA;

    public static EstadoNotificacion fromString(String value) {
        return switch (value.toUpperCase()) {
            case "LEIDA" -> LEIDA;
            case "NO LEIDA" -> NO_LEIDA;
            default -> throw new IllegalArgumentException("Estado de notificacion invalido: " + value);
        };
    }
}
