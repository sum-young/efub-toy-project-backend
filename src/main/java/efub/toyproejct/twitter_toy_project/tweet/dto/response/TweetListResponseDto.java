package efub.toyproejct.twitter_toy_project.tweet.dto.response;

import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class TweetListResponseDto {
    private List<TweetResponseDto> tweetList;
    private Long userId;
    private Long tweetCount;

    public static TweetListResponseDto of (List<Tweet> tweets, User requester) {
        return builder()
                .tweetList(tweets.stream().map(tweet -> TweetResponseDto.of(tweet, false, false)).toList())
                .userId(requester.getId())
                .tweetCount((long) tweets.size())
                .build();
    }
}
