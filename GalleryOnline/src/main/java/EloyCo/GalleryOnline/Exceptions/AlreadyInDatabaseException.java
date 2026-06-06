package EloyCo.GalleryOnline.Exceptions;

public class AlreadyInDatabaseException extends RuntimeException {
  public AlreadyInDatabaseException(String message) {
    super(message);
  }
}
