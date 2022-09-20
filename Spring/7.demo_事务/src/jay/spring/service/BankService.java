package jay.spring.service;

import jay.spring.dao.BankDao;
import jay.spring.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
            // propagation 设置传播行为
                // REQUIRED     调用其他方法后 两个方法在同一个事务中
                // REQUIRED_new 调用其他方法后 两个方法为不同事务
                // SUPPORTS     方法在事务中时 不能被其他方法调用
            // isolation 设置隔离级别（解决脏读、不可重复读、虚(幻)读的问题）
                // READ_UNCOMMITTED 读未提交
                // READ_COMMITTED   读提交
                // REPEATABLE_READ  可重复读
                // SERIALIZABLE     串行化
            // timeout      设置事务提交时间，默认-1不超时
            // readOnly     是否只读（只能查询操作），默认false
            // rollbackFor  设置出现哪些异常进行事务回滚
            // noRollbackFor设置出现哪些异常不进行事务回滚
@Transactional(timeout = 5, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ) // (2)为这个类里面所有的方法都添加事务(声明式事务管理)
public class BankService {

    /** 注入Dao */
    @Autowired
    private BankDao bankDao;

    /** 转账的方法（事务管理）
     *    (1) 编程式事务管理
     *    (2) 声明式事务管理（注解 /配置文件）
     *
     * */
    public void accountMoney() {

        // (1) 编程式事务管理
//        try {
            // 第一步：开启事务
            // 第二步 进行业务操作
            bankDao.addMoney();     // lucy多 100
            bankDao.reduceMoney();  // Tim少 100
            // 第三步： 没有发生异常，提交事务
//        }catch (Exception e){
            // 第四步： 出现异常，事务回滚
//        }

    }
}
