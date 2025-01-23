package school.token.hackaton_groupe7.infrastructure.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

import java.util.List;

public interface ICategorieUserRepository extends JpaRepository<DbCategorieUser, Integer> {
    List<DbCategorieUser> findAllByUser_Id(int userId, Pageable pageable);
    List<DbCategorieUser> findAllByUser_Id(int userId);

    List<DbCategorieUser> findAllByUser_IdAndYearAndMonth(int userId, Pageable pageable, int year, int month);

    List<DbCategorieUser> findAllByUser_IdAndYearAndMonth(int idUser, int year, int month);
}
