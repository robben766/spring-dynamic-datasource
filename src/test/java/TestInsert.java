import com.study.renz.dynamicdatasource.Application;
import com.study.renz.dynamicdatasource.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by renz on 2018/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestInsert {
    //    @MockBean
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.insert();
    }
}
