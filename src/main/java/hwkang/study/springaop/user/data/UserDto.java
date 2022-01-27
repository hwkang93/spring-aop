package hwkang.study.springaop.user.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    //사용자 ID
    private long userId;

    //사용자 명
    private String userName;
}
