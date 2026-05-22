package efub.toyproejct.twitter_toy_project.tweet.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TweetResponseDto {
    private Long tweetId;
    private WriterResponseDto writer;
    private String content;
    private Long likes;
    private Long views;
    private Long retweets;
    private Boolean isLiked;
    private Boolean isRetweeted;
    private LocalDateTime createdAt;

    public static TweetResponseDto of (Tweet tweet, boolean isLiked, boolean isRetweeted) {
        return builder()
                .tweetId(tweet.getId())
                .writer(WriterResponseDto.of(tweet.getWriter()))
                .content(tweet.getContent())
                .likes(tweet.getLikes())
                .views(tweet.getViews())
                .retweets(tweet.getRetweets())
                .isLiked(isLiked)
                .isRetweeted(isRetweeted)
                .createdAt(tweet.getCreatedAt())
                .build();
    }
}
