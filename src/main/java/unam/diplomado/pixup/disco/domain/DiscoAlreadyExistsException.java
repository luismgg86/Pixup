package unam.diplomado.pixup.disco.domain;

public class DiscoAlreadyExistsException extends RuntimeException {
    public DiscoAlreadyExistsException(String titulo,Integer idArtista) {
        super("El disco con título " + titulo + " y artista: " + idArtista + " ya existe");
    }
}
