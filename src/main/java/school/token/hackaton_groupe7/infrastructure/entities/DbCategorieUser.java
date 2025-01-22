package school.token.hackaton_groupe7.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;


@Entity
@Table(name = "categorie_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbCategorieUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,unique = true)
    public int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public DbUser user;

    @Column(length = 60, nullable = false)
    public String name;

    @Column(nullable = false)
    public double budget;

}