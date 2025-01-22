package school.token.hackaton_groupe7.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "categorieUser")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DbCategorieUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,unique = true)
    public int id;

    @Column(nullable = false)
    public int idUser;

    @Column(length = 60, nullable = false)
    public String name;

    @Column(nullable = false)
    public double budget;

}