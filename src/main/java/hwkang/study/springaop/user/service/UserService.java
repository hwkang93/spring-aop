package hwkang.study.springaop.user.service;

import hwkang.study.springaop.user.data.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * 사용자 아이디를 입력받아 결과 사용자 객체를 리턴한다.
     *
     * @param userId
     * @return UserDto
     */
    UserDto findByUserId(long userId);

}
