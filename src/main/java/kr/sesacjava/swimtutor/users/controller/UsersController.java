package kr.sesacjava.swimtutor.users.controller;


import jakarta.validation.Valid;
import kr.sesacjava.swimtutor.security.CurrentUser;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.dto.UsersExperienceDTO;
import kr.sesacjava.swimtutor.users.dto.UsersProfileDTO;
import kr.sesacjava.swimtutor.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("users")
@RequiredArgsConstructor
@Log4j2
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public void createUser(@Valid @RequestBody UsersDTO usersDTO,
                           @CurrentUser UserInfo userInfo) {

        usersService.register(usersDTO, userInfo);
    }

    @GetMapping("/profile")
    public UsersProfileDTO getUserProfile(@CurrentUser UserInfo userInfo) {
        return usersService.findProfile(userInfo);
    }

    @GetMapping("/experience")
    public UsersExperienceDTO getUserExperience(@CurrentUser UserInfo userInfo) {
        return usersService.findExperience(userInfo);
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> putUserProfile(@CurrentUser UserInfo userInfo, @RequestBody UsersProfileDTO profileDTO) {
        usersService.updateProfile(userInfo, profileDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/experience")
    public ResponseEntity<Void> putUserExperience(@CurrentUser UserInfo userInfo, @RequestBody UsersExperienceDTO experienceDTO) {
        usersService.updateExperience(userInfo, experienceDTO);
        return ResponseEntity.ok().build();
    }
}
