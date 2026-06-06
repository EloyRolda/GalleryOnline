package EloyCo.GalleryOnline.Service;

import EloyCo.GalleryOnline.DTO.GalleryCreateDTO;
import EloyCo.GalleryOnline.Exceptions.NotInDatabaseExeption;
import EloyCo.GalleryOnline.Model.Gallery;
import EloyCo.GalleryOnline.Model.Image;
import EloyCo.GalleryOnline.Model.User;
import EloyCo.GalleryOnline.Repository.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryService {

    private final GalleryRepository galleryRepository;
    private final UserService userService;

    /// Return all the gallerys related to the user
    public List<Gallery> getGalleryImagesByUser(String user_email) {
        User user = userService.obtainByEmail(user_email);
        return galleryRepository.findAllByOwnerId(user.getId());
    }

    /// Returns a Gallery by his id and the user Email
    public Gallery getGalleryById(Long galleryId, String userEmail) {
        Gallery gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new NotInDatabaseExeption("Gallery not found"));

        if (!gallery.getOwner().getEmail().equals(userEmail)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This gallery doesn't belong to you");
        }

        return gallery;
    }

    /// Creates a new gallery based in the dto received
    public Gallery createGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }


}
