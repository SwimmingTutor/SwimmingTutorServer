package kr.sesacjava.swimtutor.users.service;


import kr.sesacjava.swimtutor.common.exception.DuplicateKeyException;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.entity.Users;
import kr.sesacjava.swimtutor.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public void register(UsersDTO usersDTO, UserInfo userInfo) {
        boolean exists = usersRepository.existsByName(usersDTO.getName());

        if (exists) {
            throw new DuplicateKeyException("이름 중복");
        }

        Users users = Users.builder()
                .name(usersDTO.getName())
                .gender(usersDTO.getGender())
                .birth(usersDTO.getBirth())
                .preference(usersDTO.getPreference())
                .goal(usersDTO.getGoal())
                .weight(usersDTO.getWeight())
                .height(usersDTO.getHeight())
                .oauthLoginId(userInfo.getEmail())
                .oauthLoginPlatform(userInfo.getPlatform())
                .build();

        usersRepository.save(users);
    }


}
