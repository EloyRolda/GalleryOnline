package EloyCo.GalleryOnline.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;
    public String upload(MultipartFile file) {
        try {

            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "imagenes", "resource_type", "auto","transformation"
                    ,new Transformation().width(600).height(600).crop("pad").quality("auto"), "format", "webp")
            );
            return (String) result.get("secure_url");


        } catch (IOException e) {
            throw new RuntimeException("Error al subir imagen a Cloudinary", e);
        }
    }
/*
        Dotenv dotenv = Dotenv.load();
        Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

        Map result = cloudinary.uploader().upload(
                "https://cloudinary-devs.github.io/cld-docs-assets/assets/images/coffee_cup.jpg", ObjectUtils.asMap(
                        "use_filename", true,
                        "unique_filename", false,
                        "overwrite", true,

                        "transformation", new Transformation().width(100).height(100).crop("pad").background("white").quality("auto"),
                        "format", "webp"));

        System.out.println(result);
*/
}
