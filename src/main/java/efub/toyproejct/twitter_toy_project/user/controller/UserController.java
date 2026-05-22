package efub.toyproejct.twitter_toy_project.user.controller;

import efub.toyproejct.twitter_toy_project.user.dto.request.CreateUserDto;
import efub.toyproejct.twitter_toy_project.user.dto.response.UserDto;
import efub.toyproejct.twitter_toy_project.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto request) {
        UserDto response = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long userId) {
        UserDto response = userService.getUser(userId);

        return ResponseEntity.ok(response);
    }
}
