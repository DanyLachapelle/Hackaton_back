package school.token.hackaton_groupe7.infrastructure.transaction;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ITransactionRepository extends JpaRepository<DbTransaction, Integer> {


    List<DbTransaction> findAllByCategory_Id(Pageable pageable, int idCat);

    List<DbTransaction> findAllByDateBetween(Date from, Date to, Pageable pageable);
}
