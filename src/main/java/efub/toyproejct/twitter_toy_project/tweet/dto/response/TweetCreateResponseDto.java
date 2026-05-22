package efub.toyproejct.twitter_toy_project.tweet.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TweetCreateResponseDto {
    private Long tweetId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isLiked;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isRetweeted;


    public static TweetCreateResponseDto of (Tweet tweet) {
        return TweetCreateResponseDto.builder()
                .tweetId(tweet.getId())
                .build();
    }
}
