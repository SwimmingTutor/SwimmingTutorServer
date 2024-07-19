package kr.sesacjava.swimtutor.users.service;

import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;
import kr.sesacjava.swimtutor.users.dto.UsersProfileDTO;

public interface UsersService {
    public void register(UsersDTO usersDTO, UserInfo userInfo);

    public UsersProfileDTO findProfile(UserInfo userInfo);


}
