package EloyCo.GalleryOnline.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {


    @ExceptionHandler(NotInDatabaseExeption.class)
    public ResponseEntity<?> manageNotInDatabaseExeption(NotInDatabaseExeption e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(AlreadyInDatabaseException.class)
    public ResponseEntity<?> manageAlreadyInDatabaseException(NotInDatabaseExeption e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
