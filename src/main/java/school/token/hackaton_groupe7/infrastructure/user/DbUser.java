package school.token.hackaton_groupe7.infrastructure.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")  // Le nom de la table en base de données
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DbUser{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // L'ID est auto-généré
    public int id;

    @Column(name = "username", nullable = false, unique = true)  // Ajout de contraintes sur le nom d'utilisateur
    public String username;

    @Column(name = "password", nullable = false)  // Mot de passe obligatoire
    public String password;

    @Column(name = "mail",nullable = false,unique = true)  // Email unique et obligatoire
    public String mail;


}
