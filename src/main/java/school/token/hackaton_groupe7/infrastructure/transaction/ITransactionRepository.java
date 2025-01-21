package school.token.hackaton_groupe7.infrastructure.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<DbTransaction, Integer> {
}
