package efub.toyproejct.twitter_toy_project.global.exception.dto;

public record ErrorDto(
    String timestamp,
    int status,
    String errorCode,
    String message,
    String path
) {}
