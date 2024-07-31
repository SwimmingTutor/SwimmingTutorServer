package kr.sesacjava.swimtutor.users.service;

import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.dto.UsersExperienceDTO;
import kr.sesacjava.swimtutor.users.dto.UsersProfileDTO;

public interface UsersService {
    public void register(UsersDTO usersDTO, UserInfo userInfo);

    public UsersProfileDTO findProfile(UserInfo userInfo);

    public UsersExperienceDTO findExperience(UserInfo userInfo);

    public void updateExperience(UserInfo userInfo, UsersExperienceDTO experienceDTO);

    public void updateProfile(UserInfo userInfo, UsersProfileDTO profileDTO);

}
