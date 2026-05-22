package efub.toyproejct.twitter_toy_project.tweet.service;

import efub.toyproejct.twitter_toy_project.global.exception.CustomException;
import efub.toyproejct.twitter_toy_project.global.exception.ErrorCode;
import efub.toyproejct.twitter_toy_project.tweet.domain.Tweet;
import efub.toyproejct.twitter_toy_project.tweet.domain.TweetLike;
import efub.toyproejct.twitter_toy_project.tweet.dto.request.TweetCreateRequestDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetCreateResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetLikeDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetListResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.dto.response.TweetResponseDto;
import efub.toyproejct.twitter_toy_project.tweet.repository.TweetLikeRepository;
import efub.toyproejct.twitter_toy_project.tweet.repository.TweetRepository;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import efub.toyproejct.twitter_toy_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final TweetLikeRepository tweetLikeRepository;
    private final UserService userService;

    //TODO: 트위터 생성
    @Transactional
    public TweetCreateResponseDto createTweet(Long userId, TweetCreateRequestDto request) {
        User writer = userService.findUserById(userId);
        Tweet newTweet = Tweet.builder()
                .writer(writer)
                .content(request.getContent())
                .build();
        tweetRepository.save(newTweet);

        return TweetCreateResponseDto.of(newTweet);

    }

    //TODO: 트위터 개별 조회
    @Transactional(readOnly = true)
    public TweetResponseDto getTweet(Long tweetId, Long userId) {
        Tweet tweet = findByTweetId(tweetId);
        User requester = userService.findUserById(userId);
        tweet.increaseViews();

        //isRetweeted는 우선 하드코딩.
        boolean isLike = tweetLikeRepository.existsByTweetAndUser(tweet, requester);
        return TweetResponseDto.of(tweet, isLike, false);
    }

    //TODO: 트윗 전체 조회
    public TweetListResponseDto getTweetList(Long requesterId) {
        User requester = userService.findUserById(requesterId);
        List<Tweet> tweetList = tweetRepository.findAllByOrderByCreatedAtDesc();

        return TweetListResponseDto.of(tweetList, requester);
    }

    //TODO: 트윗 삭제
    @Transactional
    public void deleteTweet(Long requesterId, Long tweetId) {
        User user = userService.findUserById(requesterId);
        Tweet tweet = findByTweetId(tweetId);

        authorizeUser(tweet, user);

        tweetRepository.delete(tweet);
    }

    //TODO: 트윗 좋아요 생성
    @Transactional
    public TweetLikeDto createTweetLike(Long requesterId, Long tweetId) {
        User user = userService.findUserById(requesterId);
        Tweet tweet = findByTweetId(tweetId);

        if(tweetLikeRepository.existsByTweetAndUser(tweet,user)){
            throw new CustomException(ErrorCode.ALREADY_LIKED);
        }
        TweetLike like = TweetLike.builder()
                .user(user)
                .tweet(tweet)
                .build();
        tweetLikeRepository.save(like);
        tweet.increaseLikes();

        return TweetLikeDto.of(tweet);
    }

    //TODO: 트윗 좋아요 삭제
    @Transactional
    public TweetLikeDto deleteTweetLike(Long requesterId, Long tweetId) {
        User requester = userService.findUserById(requesterId);
        Tweet tweet = findByTweetId(tweetId);

        TweetLike like = tweetLikeRepository.findByTweetAndUser(tweet, requester)
                .orElseThrow(() -> new CustomException(ErrorCode.LIKE_NOT_FOUND));
        tweetLikeRepository.delete(like);
        tweet.decreaseLikes();

        return TweetLikeDto.of(tweet);
    }

    public Tweet findByTweetId (Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.TWEET_NOT_FOUND));
    }

    public void authorizeUser(Tweet tweet, User user) {
        if (!tweet.getWriter().equals(user)) {
            throw new CustomException(ErrorCode.TWEET_WRITER_MISMATCH);
        }
    }


}
