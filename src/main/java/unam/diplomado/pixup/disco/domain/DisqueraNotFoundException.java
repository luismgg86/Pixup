package unam.diplomado.pixup.disco.domain;

public class DisqueraNotFoundException extends RuntimeException {
    public DisqueraNotFoundException(Integer id) {
        super("No se encontró disquera con id: "+id);
    }
}
