package efub.toyproejct.twitter_toy_project.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserDto {
    private String nickname;
    private String handle;
    private String profileImage;
    private String bio;
}
