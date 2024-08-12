package com.contact.manag.agenda.constants;

public final class Constants {

    // Constantes para mensajes de error
    public static final String ERROR_BAD_REQUEST = "Error en el formato de la peticion"; // 400
    public static final String ERROR_USE__NOT_ALLOWED = "No está permitido el uso de esta petición"; // 401
    public static final String ERROR_ACCESS_DENIED = "No está autorizado"; // 403
    public static final String ERROR_NOT_FOUND = "Elemento no encontrado"; // 404
    public static final String ERROR_ALREADY_EXIST = "El contacto ya existe"; // 409
    public static final String ERROR_MANY_REQUEST = "Se ha excedido el límite de peticiones."; // 429
    public static final String ERROR_INTERNAL_SERVER = "Error indeterminado en el servidor"; // 500

    // validaciones
    public static final String VALID_ID_EMPTY_MSG = "El id no puede estar vacío.";
    public static final String VALID_ID_MAX_CHAR_MSG = "El id no puede tener más de 9 caracteres.";
    public static final String VALID_ID_ONLY_NUM_MSG = "El id debe contener solo números.";

    // Enum de OrderBy
    public enum OrderBy {
        NOMBRE, APELLIDOS;

        // validar el valor del enum
        public static boolean isValid(String value) {
            for (OrderBy orderBy : OrderBy.values()) {
                if (orderBy.name().equalsIgnoreCase(value)) {
                    return true;
                }
            }
            return false;
        }
    }

}
