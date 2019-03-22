import com.service.Account;
import com.service.AccountService;
import com.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")

public class Test_demo {
    @Autowired
    AccountServiceImpl ai;
    @Test
    public void Test01(){
        Account a = new Account();
        a.setName("zdh");
        a.setMoney((long) 4554545);

        ai.save(a);
        List<Account> all = ai.findAll();
        for (Account account : all) {
            System.out.println(account);

        }
    }
    @Test
    public void Test02(){
        Account a = new Account();
        a.setMoney((long) 20000);
        a.setName("dfafds");
        List<Account> all = ai.findAll();
        for (Account account: all
             ) {
            System.out.println(account);
        }
    }


    @Resource(name = "account")
    AccountServiceImpl accountService;
    @Test
    public void Test03(){

        try {
            accountService.transfer("zdh","a", (long) 40000);
        } catch (Exception e) {
            System.out.println("error!rollback");
            e.printStackTrace();
        }
    }

}
