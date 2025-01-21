package school.token.hackaton_groupe7.infrastructure.transaction;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Transaction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public Date date;
    public double amount;
    public String object;

//    @ManyToOne
//    @JoinColumn(name = "idUser")
//    private DbUser user;

//    @ManyToOne
//    @JoinColumn(name="idCat")
//    private DbCategorie categorie;

}
