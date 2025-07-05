package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.*;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.repository.MunicipioRepository;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements ColoniaService{
    //inyeccion de dependencia
    //Los repositorios no pueden usar otros repositorios para hacer operaciones persistentes
    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private MunicipioRepository municipioRepository;

    //la capa de negocio no puede devolver valores de tipo null
    //se tienen que manejar las excepciones de negocio, como no checadas (extienden de runtime exceptions)
    //siempre van en el paquete domain
    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
         Optional<Colonia> colonia = coloniaRepository.findById(id);
         if(colonia.isPresent()){
             return colonia.get();
         }
         throw new ColoniaNotFoundException(id);
    }
    //cuando se inicia la ejecucion del metodo se inicia un contexto persistente
    @Override
    public Colonia crearColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente =
                coloniaRepository.findByCpAndNombre(colonia.getCp(),colonia.getNombre());
        if(coloniaExistente.isPresent()){
            throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
        }

       Optional<Municipio> municipioExistente =
               municipioRepository.findById(colonia.getMunicipio().getId());
        if(municipioExistente.isEmpty()){
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }
        //se tienen que asociar las referencias antes de persistir el objeto (esto en el contexto de persistencia)
        //esto se hace para todas las referencias
        colonia.setMunicipio(municipioExistente.get());

        coloniaRepository.saveOrUpdate(colonia);
        return colonia;
    }

    @Override
    public Colonia actualizarColonia(Colonia colonia) {
        Optional<Colonia> coloniaExistente = coloniaRepository.findById(colonia.getId());
        if (coloniaExistente.isEmpty()) {
            throw new ColoniaNotFoundException(colonia.getId());
        }

        Optional<Colonia> coloniaExistente2 =
                coloniaRepository.findByCpAndNombre(colonia.getCp(), colonia.getNombre());
        if (coloniaExistente2.isPresent()) {
            throw new ColoniaAlreadyExistsException(colonia.getCp(), colonia.getNombre());
        }

        Optional<Municipio> municipioExistente =
                municipioRepository.findById(colonia.getMunicipio().getId());
        if (municipioExistente.isEmpty()) {
            throw new MunicipioNotFoundException(colonia.getMunicipio().getId());
        }

        Colonia coloniaActualizar = coloniaExistente.get();
        coloniaActualizar.setMunicipio(municipioExistente.get());
        coloniaActualizar.setNombre(colonia.getNombre());
        coloniaActualizar.setCp(colonia.getCp());

        coloniaRepository.saveOrUpdate(coloniaActualizar);
        return coloniaActualizar;
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {
        coloniaRepository.findById(id)
                .ifPresent(colonia -> coloniaRepository.delete(colonia)); //programacion reactiva
    }

}
