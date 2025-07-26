package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.*;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

import java.util.Optional;

@Stateless
public class DiscoServiceImpl implements DiscoService {
    @Inject
    private DisqueraRepository disqueraRepository;
    @Inject
    private ArtistaRepository artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DiscoRepository discoRepository;


    @Override
    public Disco registrarDisco(Disco disco) {

        Optional<Disco> discoExistente = discoRepository.findByTituloAndArtista(disco.getTitulo(),disco.getArtista().getId());
        if(discoExistente.isPresent()){
            throw new DiscoAlreadyExistsException(disco.getTitulo(),disco.getArtista().getId());
        }

        Optional<Artista> artista =  artistaRepository.findById(disco.getArtista().getId());
        if(artista.isEmpty()){
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }

        disco.setArtista(artista.get());

        Optional<Disquera> disquera =  disqueraRepository.findById(disco.getDisquera().getId());
        if(disquera.isEmpty()){
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }

        disco.setDisquera(disquera.get());

        Optional<GeneroMusical> generoMusical =  generoMusicalRepository.findById(disco.getGeneroMusical().getId());
        if(generoMusical.isEmpty()){
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }

        disco.setGeneroMusical(generoMusical.get());

        discoRepository.save(disco);

        return disco;
    }
}
