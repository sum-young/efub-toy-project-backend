package efub.toyproejct.twitter_toy_project.tweet.domain;

import efub.toyproejct.twitter_toy_project.global.domain.BaseEntity;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private Long likes;

    @Column(name = "views")
    private Long views;

    @Column(name = "retweets")
    private Long retweets;

    @Builder
    public Tweet(User writer, String content) {
        this.writer = writer;
        this.content = content;
        this.likes = 0L;
        this.views = 0L;
        this.retweets = 0L;
    }

    public void increaseLikes () {this.likes ++;}
    public void decreaseLikes () {this.likes --;}
    public void increaseRetweets () {this.retweets ++;}
    public void decreaseRetweets () {this.retweets--;}
    public void increaseViews() {this.views++;}
}
