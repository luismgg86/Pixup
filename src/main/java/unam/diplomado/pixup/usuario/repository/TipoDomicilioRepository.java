package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;

public interface TipoDomicilioRepository {
    Collection<TipoDomicilio> findAll();
    TipoDomicilio findById(Integer id);
}
