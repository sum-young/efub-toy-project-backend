package efub.toyproejct.twitter_toy_project.tweet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TweetCreateRequestDto {
    private String content;
}
