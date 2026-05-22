package efub.toyproejct.twitter_toy_project.user.service;

import efub.toyproejct.twitter_toy_project.global.exception.CustomException;
import efub.toyproejct.twitter_toy_project.global.exception.ErrorCode;
import efub.toyproejct.twitter_toy_project.user.domain.User;
import efub.toyproejct.twitter_toy_project.user.dto.request.CreateUserDto;
import efub.toyproejct.twitter_toy_project.user.dto.response.UserDto;
import efub.toyproejct.twitter_toy_project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(CreateUserDto request) {
        User user = User.builder()
                .nickname(request.getNickname())
                .bio(request.getBio())
                .handle(request.getHandle())
                .imageUrl(request.getProfileImage())
                .build();
        userRepository.save(user);

        return UserDto.of(user);
    }

    @Transactional(readOnly = true)
    public UserDto getUser(Long userId) {
        User user = findUserById(userId);

        return UserDto.of(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

}
