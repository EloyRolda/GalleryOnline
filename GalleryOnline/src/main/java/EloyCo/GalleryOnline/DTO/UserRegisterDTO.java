package EloyCo.GalleryOnline.DTO;

import EloyCo.GalleryOnline.Model.Enum.TypeRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterDTO {

    @Column(name = "name", length = 50)
    private String name;

    @Email(message = "Invalid format for email")
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;



}
