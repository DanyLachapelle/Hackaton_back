package school.token.hackaton_groupe7.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "date_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbDateUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false,unique = true)
    public int id;

    @Column(nullable = false)
    public int month ;

    @Column(nullable = false)
    public int year;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public DbUser user;

    @Column(nullable = false)
    public double budget;

}