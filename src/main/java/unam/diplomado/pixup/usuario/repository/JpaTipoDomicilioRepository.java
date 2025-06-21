package unam.diplomado.pixup.usuario.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.List;

@Singleton
public class JpaTipoDomicilioRepository implements TipoDomicilioRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Collection<TipoDomicilio> findAll() {
        return List.of();
    }

    @Override
    public TipoDomicilio findById(Integer id) {
        return null;
    }
}
