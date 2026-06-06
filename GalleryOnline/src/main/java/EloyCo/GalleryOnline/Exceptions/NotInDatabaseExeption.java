package EloyCo.GalleryOnline.Exceptions;

public class NotInDatabaseExeption extends RuntimeException {
  public NotInDatabaseExeption(String message) {
    super(message);
  }
}
