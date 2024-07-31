package kr.sesacjava.swimtutor.users.service;


import kr.sesacjava.swimtutor.common.exception.DuplicateKeyException;
import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.dto.UsersExperienceDTO;
import kr.sesacjava.swimtutor.users.dto.UsersProfileDTO;
import kr.sesacjava.swimtutor.users.entity.Users;
import kr.sesacjava.swimtutor.users.entity.UsersId;
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

    @Override
    public UsersProfileDTO findProfile(UserInfo userInfo) {
        UsersId usersId = new UsersId(userInfo.getEmail(), userInfo.getPlatform());
        Users users = usersRepository.findById(usersId).orElseThrow();

        return UsersProfileDTO.builder()
                .name(users.getName())
                .gender(users.getGender())
                .birth(users.getBirth())
                .height(users.getHeight())
                .weight(users.getWeight())
                .build();
    }

    @Override
    public UsersExperienceDTO findExperience(UserInfo userInfo) {
        UsersId usersId = new UsersId(userInfo.getEmail(), userInfo.getPlatform());
        Users users = usersRepository.findById(usersId).orElseThrow();

        return UsersExperienceDTO.builder()
                .preference(users.getPreference())
                .goal(users.getGoal())
                .build();
    }

    @Override
    public void updateProfile(UserInfo userInfo, UsersProfileDTO profileDTO) {
        UsersId usersId = new UsersId(userInfo.getEmail(), userInfo.getPlatform());
        Users user = usersRepository.findById(usersId).orElseThrow();

        user.changeProfile(profileDTO);
        
        usersRepository.save(user);
    }

    @Override
    public void updateExperience(UserInfo userInfo, UsersExperienceDTO experienceDTO) {
        UsersId usersId = new UsersId(userInfo.getEmail(), userInfo.getPlatform());
        Users user = usersRepository.findById(usersId).orElseThrow();

        user.changeExperience(experienceDTO);

        usersRepository.save(user);
    }
}
