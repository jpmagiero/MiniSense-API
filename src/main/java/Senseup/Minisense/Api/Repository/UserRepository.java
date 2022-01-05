package Senseup.Minisense.Api.Repository;

import Senseup.Minisense.Api.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findById(long UserId);
}
