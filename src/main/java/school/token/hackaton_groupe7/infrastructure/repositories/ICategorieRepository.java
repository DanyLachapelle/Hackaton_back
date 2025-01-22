package school.token.hackaton_groupe7.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorie;

public interface ICategorieRepository extends JpaRepository<DbCategorie, Integer> {
}
