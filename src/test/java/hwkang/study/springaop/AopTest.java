package hwkang.study.springaop;

import hwkang.study.springaop.user.data.UserDto;
import hwkang.study.springaop.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class AopTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("사용자 아이디가 1인 사용자의 이름은 khw 이다")
    void findUser() {
        final long userId = 1L;

        UserDto userDto = userService.findByUserId(userId);

        assertThat(userDto.getUserName()).isEqualTo("khw");
    }

    @Test
    @DisplayName("@Before 어노테이션 결과 확인")
    void printLogTest() {

        userService.findByUserId(1);
    }

    @Test
    @DisplayName("사용자가 없는 경우 NullPointerException 발생")
    void throwNullPointerException() {

        assertThrows(NullPointerException.class, () -> userService.findByUserId(4));
    }
}
