package efub.toyproejct.twitter_toy_project.tweet.dto.response;

import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TweetLikeDto {

    private Long likeCount;

    public static TweetLikeDto of (Tweet tweet) {
        return TweetLikeDto.builder()
                .likeCount(tweet.getLikes())
                .build();
    }
}
