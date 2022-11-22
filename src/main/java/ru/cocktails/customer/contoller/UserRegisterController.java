package ru.cocktails.customer.contoller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cocktails.customer.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserRegisterController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestParam("nickname") String nickname) {
        return ResponseEntity.ok().body(userService.createUserIfNotExist(nickname));
    }


}
