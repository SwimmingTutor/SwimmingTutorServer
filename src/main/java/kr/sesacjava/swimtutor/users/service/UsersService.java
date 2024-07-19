package kr.sesacjava.swimtutor.users.service;

import kr.sesacjava.swimtutor.security.dto.UserInfo;
import kr.sesacjava.swimtutor.users.dto.UsersDTO;

public interface UsersService {
    public void register(UsersDTO usersDTO, UserInfo userInfo);


}
