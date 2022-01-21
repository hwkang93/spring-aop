package hwkang.study.springaop.user.service;

import hwkang.study.springaop.user.data.UserDto;

import java.util.List;

public interface UserService {

    UserDto findByUserId(long userId);

    List<UserDto> findListByUserName(String userName);
}
