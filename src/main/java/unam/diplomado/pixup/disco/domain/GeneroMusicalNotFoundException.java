package unam.diplomado.pixup.disco.domain;

public class GeneroMusicalNotFoundException extends RuntimeException {
    public GeneroMusicalNotFoundException(Integer id) {
        super("No se encontró género musical con id: "+id);
    }
}
