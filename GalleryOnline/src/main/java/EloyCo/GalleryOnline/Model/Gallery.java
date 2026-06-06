package EloyCo.GalleryOnline.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "gallery")

public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "galery_name")
    private String gallery_name;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User owner;
}
