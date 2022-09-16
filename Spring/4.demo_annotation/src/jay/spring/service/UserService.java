package jay.spring.service;

import jay.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

// (value = "userService") 可以不写
// 默认类名，首字母小写
@Component(value = "userService")  // = <bean id="userService" class=".."/>
public class UserService {

    @Autowired  // 根据类型进行注入
    @Qualifier(value = "userDaoImpl1")  //根据名称注入，要和@Autowired一起使用
    private UserDao userDao1;

//    @Resource   // 根据类型进行注入
    @Resource(name = "userDaoImpl1")    // 根据名称进行注入
    private UserDao userDao2;

    @Value(value = "asdc")  // 注入普通类型属性
    private String name;

    public void add() {
        System.out.println("Service add.." + name);
        userDao1.add();
        userDao2.add();
    }

}
