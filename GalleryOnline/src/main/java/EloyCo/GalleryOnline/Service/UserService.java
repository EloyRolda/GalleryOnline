package EloyCo.GalleryOnline.Service;

import EloyCo.GalleryOnline.DTO.UserRegisterDTO;
import EloyCo.GalleryOnline.Exceptions.AlreadyInDatabaseException;
import EloyCo.GalleryOnline.Exceptions.NotInDatabaseExeption;
import EloyCo.GalleryOnline.Model.Enum.TypeRole;
import EloyCo.GalleryOnline.Model.User;
import EloyCo.GalleryOnline.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;



    /// obtains an user by an email provide
    public User obtainByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new NotInDatabaseExeption("This email isn't from an active user");
        }
        return userRepository.findByEmail(email);
    }

    /// Creates an user in the database
    public User createUser(UserRegisterDTO userRegisterDTO) {

        if (userRepository.existsByEmail(userRegisterDTO.getEmail())) {
            throw new AlreadyInDatabaseException("User already in database");
        }

        return userRepository.save(mapUserByDTO(userRegisterDTO));
    }

    /// Maps the user DTO to a normal User
    private User mapUserByDTO(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        user.setEmail(userRegisterDTO.getEmail());
        user.setName(userRegisterDTO.getName());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setTypeRole(TypeRole.USER);
        return user;
    }


}
