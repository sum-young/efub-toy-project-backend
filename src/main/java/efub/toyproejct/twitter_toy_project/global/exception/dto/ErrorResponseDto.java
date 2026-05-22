package efub.toyproejct.twitter_toy_project.global.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponseDto {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
