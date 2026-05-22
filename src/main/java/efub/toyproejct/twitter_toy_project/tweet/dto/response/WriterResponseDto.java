package efub.toyproejct.twitter_toy_project.tweet.dto.response;

import efub.toyproejct.twitter_toy_project.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WriterResponseDto {
    private Long userId;
    private String nickname;
    private String handle;
    private String profileImage;

    public static WriterResponseDto of (User user) {
        return builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .handle(user.getHandle())
                .profileImage(user.getImageUrl())
                .build();
    }
}
