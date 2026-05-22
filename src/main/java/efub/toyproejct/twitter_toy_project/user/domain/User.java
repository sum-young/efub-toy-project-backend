package efub.toyproejct.twitter_toy_project.user.domain;

import efub.toyproejct.twitter_toy_project.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "handle")
    private String handle;

    @Column(name = "bio")
    private String bio;

    @Column (name = "image")
    private String imageUrl;

    private Long followingCount = (long) 1;
    private Long followerCount = (long) 1;

    @Builder
    public User (String nickname, String handle, String bio, String imageUrl) {
        this.nickname = nickname;
        this.handle = handle;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public void increaseFollowing() {this.followingCount++;}
    public void decreaseFollowing() {this.followingCount--;}
    public void increaseFollower() {this.followerCount++;}
    public void decreaseFollower() {this.followerCount--;}

}
