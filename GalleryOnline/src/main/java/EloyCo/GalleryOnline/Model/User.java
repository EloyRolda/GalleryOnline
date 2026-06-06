package EloyCo.GalleryOnline.Model;

import EloyCo.GalleryOnline.Model.Enum.TypeRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Email;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Email(message = "Invalid format for email")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private TypeRole typeRole;

}
