package com.uniminuto.biblioteca.apicontroller;

import com.uniminuto.biblioteca.api.AutorApi;
import com.uniminuto.biblioteca.entity.Autor;
import com.uniminuto.biblioteca.services.AutorService;
import java.util.List;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lmora
 */
@RestController
public class AutorApiController implements AutorApi {
    /**
     * AutorService.
     */
    @Autowired
    private AutorService autorService;

    @Override
    public ResponseEntity<List<Autor>> listarAutores() throws BadRequestException {
       return ResponseEntity.ok(this.autorService.obtenerListadoAutores());
    }

    @Override
    public ResponseEntity<List<Autor>> listarAutoresByNacionalidad(String nacionalidad) 
            throws BadRequestException {
       return ResponseEntity.ok(this.autorService
               .obtenerListadoAutoresPorNacionalidad(nacionalidad));
    }

    @Override
    public ResponseEntity<Autor> listarAutorPorId(Integer autorId) throws BadRequestException {
       return ResponseEntity.ok(this.autorService.obtenerAutorPorId(autorId));
    }

@Override
public ResponseEntity<Autor> crearAutor(@RequestBody Autor autor) throws BadRequestException {
    return ResponseEntity.ok(this.autorService.crearAutor(autor));
}

@Override
public ResponseEntity<Autor> actualizarAutor(Integer autorId, @RequestBody Autor autor) throws BadRequestException {
    return ResponseEntity.ok(this.autorService.actualizarAutor(autorId, autor));
}

@Override
public ResponseEntity<String> eliminarAutor(Integer autorId) throws BadRequestException {
    this.autorService.eliminarAutor(autorId);
    return ResponseEntity.ok("Autor eliminado correctamente.");
}
}

