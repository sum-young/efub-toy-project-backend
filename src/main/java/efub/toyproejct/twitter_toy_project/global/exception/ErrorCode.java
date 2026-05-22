package efub.toyproejct.twitter_toy_project.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "존재하지 않는 사용자입니다."),
    TWEET_NOT_FOUND(404, "존재하지 않는 트윗입니다."),
    TWEET_WRITER_MISMATCH(403, "자신이 작성한 트윗만 삭제할 수 있습니다."),
    ALREADY_LIKED(400, "좋아요를 이미 눌렀습니다."),
    LIKE_NOT_FOUND(404, "좋아요를 누르지 않았습니다.");

    private final int status;
    private final String message;
}
