package com.web.colegiofdps.Entities;

public enum TipoTelefono {
    WorkPhone,
    PersonalPhone;

    public static TipoTelefono fromString(String value) {
        return switch (value.toUpperCase()) {
            case "Telefono de trabajo" -> WorkPhone;
            case "Telefono Personal" -> PersonalPhone;
            default -> throw new IllegalArgumentException("Tipo de Telefono inválido: " + value);
        };
    }
}
