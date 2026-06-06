package EloyCo.GalleryOnline.Service;

import EloyCo.GalleryOnline.Model.Image;
import EloyCo.GalleryOnline.Repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    ///Obtains all the images from a gallery
    public List<Image> obtainByGallery(Long id_gallery) {
        return imageRepository.findByGalleryId(id_gallery);
    }

    ///Saves the image in the database
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }
}
