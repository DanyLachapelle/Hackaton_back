package school.token.hackaton_groupe7.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.token.hackaton_groupe7.domain.DateUser;
import school.token.hackaton_groupe7.infrastructure.entities.DbDateUser;

public interface IDateUserRepository extends JpaRepository<DbDateUser, Integer> {

    DbDateUser findByUser_IdAndMonthAndYear(int userId, int month, int year);
}
