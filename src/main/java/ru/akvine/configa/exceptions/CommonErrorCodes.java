package ru.akvine.configa.exceptions;

public final class CommonErrorCodes {
    private CommonErrorCodes() {
        throw new IllegalStateException("CommonErrorCodes constructor calling is prohibited!");
    }

    public final static String GENERAL_ERROR = "general.error";
    public final static String NO_SESSION = "no.session.error";

    interface Client {
        String CLIENT_NOT_FOUND_ERROR = "client.notFound.error";
    }

    interface App {
        String APP_NOT_FOUND_ERROR = "app.notFound.error";
    }

    public interface Validation {
        interface Property {
            String PROPERTY_FILE_TYPE_BLANK_ERROR = "property.file.type.blank.error";
            String PROPERTY_FILE_TYPE_INVALID_ERROR = "property.file.type.invalid.error";
            String PROPERTY_FILE_SIZE_ERROR = "property.file.size.error";
        }
    }
}
