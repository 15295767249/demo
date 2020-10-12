import cn.com.yhb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    UserService userService;

    @org.junit.Test
    public void Test() {

        userService.pushData();
    }
}
