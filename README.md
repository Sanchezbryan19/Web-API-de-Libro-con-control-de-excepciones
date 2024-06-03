# Deber

En esta tarea, se ajustaron los controladores y servicios para manejar excepciones de manera más precisa y enviar códigos de estado HTTP apropiados. 

# Modificaciones

En el controlador LibroController, se modificó el método getLibro para capturar la excepción LibroException y devolver un ResponseEntity con un mensaje de error personalizado y el estado HTTP NOT_FOUND si el libro no se encuentra.

Y en el método postLibro, se modificó el tipo de retorno a ResponseEntity<Void> para poder enviar el estado HTTP CREATED en lugar del valor predeterminado, que es OK.

![controlador](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/3cbffeda-9dcb-4a57-8568-7d831a30ed63)

Se agregó una nueva clase ExceptionManager con el anotador @ControllerAdvice y un método handleLibroException que maneja las excepciones de tipo LibroException. Este método devuelve un ResponseEntity con el estado HTTP NOT_FOUND y el mensaje de la excepción.

![ExceptionManager ](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/eeb5e0fb-394e-4f89-9b87-5f2c2cbc0656)

![LibroException](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/78550839-329e-40b7-9df6-3836a949f9cc)

En el servicio LibroServiceImpl, se modificó el método getLibro para lanzar una excepción LibroException si el libro no se encuentra en el repositorio.

![LibroServiceImpl](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/dca48393-afc8-458f-81c9-86e4b02dca64)

Estas modificaciones aseguran que las respuestas a las solicitudes se ajusten adecuadamente a los estándares HTTP y proporcionen información significativa al cliente sobre el estado de la solicitud.

# Comprobación 
# Obtener un libro inexistente
Se realizar una solicitud GET a /libros/{id} con un ID de libro que no existe. Y si el libro no se encuentra da un mensaje de error personalizado con el estado HTTP NOT_FOUND (404)

![libro inexistente](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/a819eba4-9956-49f4-9a7d-f7bb92ef45ec)

# Agregar un nuevo libro
Se realizar una solicitud POST a /libros/agregarlibros con el nuevo libro y devuelva el estado HTTP CREATED (201).

![nuevo libro](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/8483dc86-e7e2-4621-9735-4d5ee9ac3d2a)

Y para confirmar que se allá creado hacemos un GET consultando la id que creamos:

![confirmar- nuevo libro](https://github.com/Sanchezbryan19/Web-API-de-Libro-con-control-de-excepciones/assets/148237561/f8d11f4c-f2ec-4d89-9151-af2620f41938)
