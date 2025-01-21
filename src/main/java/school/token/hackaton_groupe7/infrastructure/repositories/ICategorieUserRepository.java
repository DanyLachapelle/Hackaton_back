package school.token.hackaton_groupe7.infrastructure.repositories;

import school.token.hackaton_groupe7.application.shared.cqrscore.interfaces.IEntityRepository;
import school.token.hackaton_groupe7.infrastructure.entities.DbCategorieUser;

public interface ICategorieUserRepository extends IEntityRepository<DbCategorieUser> {
    boolean existsById(int id);
}
