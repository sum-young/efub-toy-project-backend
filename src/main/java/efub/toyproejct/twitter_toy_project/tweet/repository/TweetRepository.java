package efub.toyproejct.twitter_toy_project.tweet.repository;

import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByOrderByCreatedAtDesc();
}
