package hwkang.study.springaop;

import hwkang.study.springaop.user.data.UserDto;
import hwkang.study.springaop.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodInfoAopTest {

    @Autowired
    UserService userService;

    @Test
    void printLogTest() {
        UserDto userDto = userService.findByUserId(1);
    }
}
