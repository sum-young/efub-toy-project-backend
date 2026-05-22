package efub.toyproejct.twitter_toy_project.user.dto.response;

import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String nickname;
    private String handle;
    private Long following;
    private Long follower;
    private String profileImage;
    private String bio;
    private LocalDateTime joinedAt;

    public static UserDto of (User user) {
        return builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .handle(user.getHandle())
                .following(user.getFollowingCount())
                .follower(user.getFollowerCount())
                .bio(user.getBio())
                .profileImage(user.getImageUrl())
                .joinedAt(user.getCreatedAt())
                .build();
    }

}
