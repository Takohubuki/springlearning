import com.bean.User;
import com.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        UserController uc = (UserController) ac.getBean("userController");

        User u = new User();
        u.setAge(32);
        u.setBirth(new Date());
        u.setName("dsf");
        uc.show(u);
    }
}
