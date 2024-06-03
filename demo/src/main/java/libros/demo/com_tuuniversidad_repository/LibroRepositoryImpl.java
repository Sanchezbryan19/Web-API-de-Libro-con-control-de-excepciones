package libros.demo.com_tuuniversidad_repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import libros.demo.com_tuuniversidad_models.Libro;

@Repository
public class LibroRepositoryImpl implements LibroRepository{
    private List<Libro> libros = new ArrayList<>();

    public LibroRepositoryImpl() {
        libros.add(new Libro(1L, "La sombra del viento", "Carlos Ruiz Zafón", "Planeta", 2001));
        libros.add(new Libro(2L, "El nombre de la rosa", "Umberto Eco", "Lumen", 1980));
        libros.add(new Libro(3L, "Las brujas de Eastwick", "John Updike", "Alfaguara", 1984));
        libros.add(new Libro(4L, "El alma de la toga", "Ángel Ossorio y Gallardo", "Espasa Calpe", 1905));
    }

    public Libro getLibro (int id){
        for(Libro libro: libros){
            if(id == libro.getId())
                return libro;
        }

        return null;
        
    }

    public List<Libro> getLibros() {
        return libros;
    }


    public void postLibro(Libro libro) {
        libros.add(libro);
    }

}
