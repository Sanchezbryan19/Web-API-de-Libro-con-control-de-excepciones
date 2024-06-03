package libros.demo.com_tuuniversidad_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libros.demo.com_tuuniversidad_exceptions.LibroException;
import libros.demo.com_tuuniversidad_models.Libro;
import libros.demo.com_tuuniversidad_repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{


    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro getLibro(int id) {
        Libro libro = libroRepository.getLibro(id);
        if (libro == null) {
            throw new LibroException("Libro con ID " + id + " no encontrado");
        }
        return libro;
    }

    @Override
    public List<Libro> getLibros() {
        return libroRepository.getLibros();
    }

    @Override
    public void postLibro(Libro libro) {
        libroRepository.postLibro(libro);
    }
}
