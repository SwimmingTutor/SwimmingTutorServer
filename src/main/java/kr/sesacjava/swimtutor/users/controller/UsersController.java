package kr.sesacjava.swimtutor.users.controller;


import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("users")
@RequiredArgsConstructor
@Log4j2
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public void createUser(@RequestBody UsersDTO usersDTO, @CurrentUser UserInfo userInfo) {
        usersService.register(usersDTO, userInfo);
    }


}
