package school.token.hackaton_groupe7.infrastructure.transaction;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import school.token.hackaton_groupe7.domain.Transaction;

import java.util.Date;
import java.util.List;

public interface ITransactionRepository extends JpaRepository<DbTransaction, Integer> {


    List<DbTransaction> findAllByDateBetween(Date from, Date to, Pageable pageable);

    @Query(value = "SELECT t FROM DbTransaction t WHERE t.user.id = :userId AND MONTH(t.date) = :month AND YEAR(t.date) = :year")
    List<DbTransaction> findByUserAndMonth(@Param("userId") int userId, @Param("month") int month, @Param("year") int year);

    @Query(value = "SELECT t FROM DbTransaction t WHERE t.user.id = :userId AND MONTH(t.date) = :month AND YEAR(t.date) = :year AND t.category.id = :categoryId")
    List<DbTransaction> findByUserAndMonthAndCategory(@Param("userId") int userId, @Param("month") int month, @Param("year") int year, @Param("categoryId") int categoryId);

    List<DbTransaction> findAllByUser_Id(int user_id, Pageable pageable);
}
