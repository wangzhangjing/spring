import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringText {
    @Test
    //测试scope属性
    public void text1(){
        ClassPathXmlApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 =(UserDao) app.getBean("userDao");
//        UserDao userDao2 =(UserDao) app.getBean("userDao");
        System.out.println(userDao1);
//        System.out.println(userDao2);
        //app.close();
    }
}
