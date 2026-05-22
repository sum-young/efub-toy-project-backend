package efub.toyproejct.twitter_toy_project.tweet.controller;

import efub.toyproejct.twitter_toy_project.tweet.dto.request.TweetCreateRequestDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetCreateResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetLikeDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetListResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;
    @PostMapping
    public ResponseEntity<TweetCreateResponseDto> createTweet(@RequestBody TweetCreateRequestDto request,
                                                              @RequestHeader("Auth-id") Long userId) {
        TweetCreateResponseDto response = tweetService.createTweet(userId, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetResponseDto> getTweet(@PathVariable("tweetId") Long tweetId,
                                                     @RequestHeader("auth-id") Long userId) {
        TweetResponseDto response = tweetService.getTweet(tweetId, userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<TweetListResponseDto> getTweetList(@RequestHeader("Auth-id") Long requesterId) {
        TweetListResponseDto response = tweetService.getTweetList(requesterId);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@RequestHeader("Auth-id") Long requesterId,
                                            @PathVariable("tweetId") Long tweetId) {
        tweetService.deleteTweet(requesterId, tweetId);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{tweetId}/likes")
    public ResponseEntity<TweetLikeDto> createTweetLike(@RequestHeader("Auth-id") Long requesterId,
                                                   @PathVariable("tweetId") Long tweetId) {
        TweetLikeDto response = tweetService.createTweetLike(requesterId, tweetId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{tweetId}/likes")
    public ResponseEntity<TweetLikeDto> deleteTweetLike(@RequestHeader("Auth-id") Long requesterId,
                                                        @PathVariable("tweetId") Long tweetId) {
        TweetLikeDto response = tweetService.deleteTweetLike(requesterId, tweetId);

        return ResponseEntity.ok(response);
    }


}
