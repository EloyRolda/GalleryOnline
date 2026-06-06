package EloyCo.GalleryOnline.Controller;


import EloyCo.GalleryOnline.DTO.GalleryCreateDTO;
import EloyCo.GalleryOnline.Model.Gallery;
import EloyCo.GalleryOnline.Model.Image;
import EloyCo.GalleryOnline.Service.CloudinaryService;
import EloyCo.GalleryOnline.Service.GalleryService;
import EloyCo.GalleryOnline.Service.ImageService;
import EloyCo.GalleryOnline.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gallery")
public class GalleryController {

    private final GalleryService galleryService;
    private final CloudinaryService cloudinaryService;
    private final ImageService imageService;
    private final UserService userService;


    @GetMapping("/mygallery")
    public List<Gallery> mygallery(@AuthenticationPrincipal UserDetails userDetails) {
        return galleryService.getGalleryImagesByUser(userDetails.getUsername());
    }

    @PostMapping("/upload")
    public ResponseEntity<Image> upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("alt") String alt,
            @RequestParam("galleryId") Long galleryId,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        Gallery gallery = galleryService.getGalleryById(galleryId, userDetails.getUsername());
        Map result = cloudinaryService.upload(file);
        Image image = new Image(null, alt, (String) result.get("secure_url"), (String) result.get("public_id"), gallery);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.createImage(image));
    }

    @PostMapping("/create")
    public ResponseEntity<Gallery> createGallery(@RequestBody GalleryCreateDTO galleryCreateDTO, @AuthenticationPrincipal UserDetails userDetails) {
        Gallery gallery = new Gallery(null, galleryCreateDTO.getGallery_name(), userService.obtainByEmail(userDetails.getUsername()));
        return ResponseEntity.status(HttpStatus.CREATED).body(galleryService.createGallery(gallery));
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<List<Image>> galleryImages(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        galleryService.getGalleryById(id, userDetails.getUsername());
        return ResponseEntity.ok().body(imageService.obtainByGallery(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) throws IOException {
        imageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }

}
