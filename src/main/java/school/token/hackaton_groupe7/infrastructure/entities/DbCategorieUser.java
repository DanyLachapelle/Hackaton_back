package school.token.hackaton_groupe7.infrastructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import school.token.hackaton_groupe7.application.shared.cqrscore.entities.DbEntity;

@Entity
@Table(name = "CategorieUser")
@Data
@EqualsAndHashCode(callSuper = false)
public class DbCategorieUser extends DbEntity {

    @Column(nullable = false,unique = true)
    private int id;

    @Column(nullable = false)
    private int idUser;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(nullable = false)
    private double budget;

}
