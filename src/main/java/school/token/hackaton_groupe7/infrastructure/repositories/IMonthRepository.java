package school.token.hackaton_groupe7.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbMonth;

public interface IMonthRepository extends JpaRepository<DbMonth, Integer> {
}
