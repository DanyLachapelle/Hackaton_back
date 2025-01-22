package school.token.hackaton_groupe7.infrastructure.transaction;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;
import school.token.hackaton_groupe7.infrastructure.user.DbUser;

import java.util.Date;

@Entity
@Table(name="transaction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DbTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public DbUser user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    public DbCategorieUser category;

    @Column(nullable = false)
    public Date date;

    @Column(nullable = false)
    public double amount;

    @Column(nullable = false)
    public String object;

    public int getCategory_id() {
        return category.id;
    }
}
