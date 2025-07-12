package unam.diplomado.pixup.usuario.domain;

public class UsuarioAlreadyExistsException extends RuntimeException {

    public UsuarioAlreadyExistsException(String email) {
        super("Ya existe el usuario con email: " + email);
    }

}


