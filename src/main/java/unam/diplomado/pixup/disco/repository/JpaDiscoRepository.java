package unam.diplomado.pixup.disco.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Disco;

import java.util.List;
import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);
        return disco;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery("SELECT u FROM Disco u WHERE u.titulo = :titulo AND u.artista.id = :idArtista", Disco.class);
        query.setParameter("titulo",titulo  );
        query.setParameter("idArtista",idArtista);
        List<Disco> discos = query.getResultList();
        return !discos.isEmpty() ? Optional.of(discos.get(0)) : Optional.empty();
    }
}
