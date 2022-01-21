package hwkang.study.springaop;

import hwkang.study.springaop.user.data.UserDto;
import hwkang.study.springaop.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodInfoAopTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("@Before 어노테이션 결과 확인")
    void printLogTest() {
        userService.findByUserId(1);
    }


}
