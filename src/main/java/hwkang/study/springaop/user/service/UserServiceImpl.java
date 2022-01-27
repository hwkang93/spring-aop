package hwkang.study.springaop.user.service;

import hwkang.study.springaop.annotation.ExecutionTime;
import hwkang.study.springaop.user.data.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    final List<UserDto> userList = Arrays.asList(
            new UserDto(1, "khw"),
            new UserDto(2, "chr"),
            new UserDto(3, "kjh")
    );

    @Override
    @ExecutionTime
    public UserDto findByUserId(long userId) {
        return userList.stream()
                .filter(userDto -> userDto.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException());
    }
}
