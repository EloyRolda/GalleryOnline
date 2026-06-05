package EloyCo.GalleryOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Map;

@SpringBootApplication
public class GalleryOnlineApplication {

    public static void main(String[] args) throws Exception {

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

        SpringApplication.run(GalleryOnlineApplication.class, args);
    }
}