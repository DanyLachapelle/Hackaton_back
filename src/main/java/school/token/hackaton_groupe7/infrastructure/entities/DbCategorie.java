package school.token.hackaton_groupe7.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "categorie")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbCategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,unique = true)
    public int id;

    @Column(length = 60, nullable = false)
    public String name;
}
