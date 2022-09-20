package jay.spring;


import jay.spring.config.TxConfig;
import jay.spring.entity.Bank;
import jay.spring.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void testJdbcTemplate(){    // 配置文件开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        // 2、获取配置创建的对象
        BankService bankService = context.getBean("bankService", BankService.class);
        // 开始转账
        Bank bank = new Bank();
        bankService.accountMoney();
//        System.out.println((172+126+133+ 8+14));
//        System.out.println((238+228+310+ 3+ 6)/60);
//        user.add();
    }

    @Test
    public void testAcount(){    // 全注解开发
        // 1、加载Spring配置文件
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        // 2、获取配置创建的对象
        BankService bankService = context.getBean("bankService", BankService.class);
        // 开始转账
        bankService.accountMoney();
    }

}
