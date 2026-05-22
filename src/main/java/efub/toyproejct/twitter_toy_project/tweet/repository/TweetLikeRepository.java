package efub.toyproejct.twitter_toy_project.tweet.repository;

import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import efub.toyproejct.twitter_toy_project.tweet.domain.TweetLike;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetLikeDto;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TweetLikeRepository extends JpaRepository<TweetLike, Long> {
    boolean existsByTweetAndUser(Tweet tweet, User user);
    Optional<TweetLike> findByTweetAndUser(Tweet tweet, User user);
}
