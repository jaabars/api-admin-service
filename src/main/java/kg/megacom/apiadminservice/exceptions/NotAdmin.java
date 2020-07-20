package kg.megacom.apiadminservice.exceptions;

public class NotAdmin extends RuntimeException {
    public NotAdmin(String message) {
        super(message);
    }
}
