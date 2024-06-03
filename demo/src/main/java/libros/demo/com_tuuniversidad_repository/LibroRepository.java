package libros.demo.com_tuuniversidad_repository;

import java.util.List;

import libros.demo.com_tuuniversidad_models.Libro;

public interface LibroRepository {
    Libro getLibro (int id);
    List<Libro> getLibros();
    void postLibro(Libro libro);
}
