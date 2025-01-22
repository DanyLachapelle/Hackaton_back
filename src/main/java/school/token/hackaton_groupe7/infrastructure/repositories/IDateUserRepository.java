package school.token.hackaton_groupe7.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;

public interface IDateUserRepository extends JpaRepository<DbDateUser, Integer> {
}
