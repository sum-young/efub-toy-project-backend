package efub.toyproejct.twitter_toy_project.user.repository;

import efub.toyproejct.twitter_toy_project.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
