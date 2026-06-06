package EloyCo.GalleryOnline.Controller;


import EloyCo.GalleryOnline.DTO.UserRegisterDTO;
import EloyCo.GalleryOnline.Model.User;
import EloyCo.GalleryOnline.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        return userService.createUser(userRegisterDTO);
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/index.html";
    }



}
