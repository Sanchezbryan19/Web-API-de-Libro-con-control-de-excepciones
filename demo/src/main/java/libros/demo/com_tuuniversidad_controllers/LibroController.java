package libros.demo.com_tuuniversidad_controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import libros.demo.com_tuuniversidad_exceptions.LibroException;
import libros.demo.com_tuuniversidad_models.Libro;
import libros.demo.com_tuuniversidad_service.LibroService;

@RestController
public class LibroController {

    @Autowired
    private LibroService libroService;

    @RequestMapping("/libros")
    public List<Libro> getLibros() {
        return libroService.getLibros();
    }

    @GetMapping("libros/{id}")
    public ResponseEntity<?> getLibro(@PathVariable int id) {
        try {
            Libro libro = libroService.getLibro(id);
            return ResponseEntity.ok(libro);
        } catch (LibroException e) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje: ", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("libros/crearlibros")
    public ResponseEntity<Void> postLibro(@RequestBody Libro libro) {
        libroService.postLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
