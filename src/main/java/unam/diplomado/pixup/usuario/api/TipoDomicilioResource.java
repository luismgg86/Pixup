package unam.diplomado.pixup.usuario.api;

import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;

import java.util.Collection;

public class TipoDomicilioResource implements TipoDomicilioApi{
    //funciona igual que PersistenceContext, obtiene la instancia que se creo y la pasa como referencia
    //siempre el contenedor regresa las referencias, en el codigo nunca hay una instanciación directa
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository; //siempre se pone la interfaz

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
}
