package EloyCo.GalleryOnline;

import EloyCo.GalleryOnline.DTO.UserRegisterDTO;
import EloyCo.GalleryOnline.Model.Enum.TypeRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudinary.*;


@SpringBootApplication
public class GalleryOnlineApplication {


    public static void main(String[] args) throws Exception {


        SpringApplication.run(GalleryOnlineApplication.class, args);
    }
}