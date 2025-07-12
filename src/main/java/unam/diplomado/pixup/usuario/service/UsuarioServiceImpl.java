package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.DomicilioRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;


    @Override
    @Transactional(value=Transactional.TxType.REQUIRED) //El contenedor intercepta lo que pasa aquí, toma una conexion y empieza una transaccion
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) { //hacer todas las validaciones para guardar la informacion
        //validacion de usuario duplicado
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()){
            throw new UsuarioAlreadyExistsException(usuario.getEmail());
        }

        //validacion de existencia de colonia
        Optional<Colonia> colonia = coloniaRepository.findById(domicilio.getColonia().getId());
        if (colonia.isEmpty()){
            throw  new ColoniaNotFoundException(domicilio.getColonia().getId());
        }

        domicilio.setColonia(colonia.get());

        //validacion de tipo domicilio
        Optional < TipoDomicilio> tipoDomicilio = tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if (tipoDomicilio.isEmpty()){
            throw  new ColoniaNotFoundException(domicilio.getTipoDomicilio().getId());
        }

        domicilio.setTipoDomicilio(tipoDomicilio.get());

        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        return usuario;
    }
}
