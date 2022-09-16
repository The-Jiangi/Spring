package jay.spring.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 增强的类 */
@Component
@Aspect     // 生成代理对象
@Order(1)   // 设置增强类的优先级，数字高的先执行
public class UserProxy {

    /** 相同切入点抽取 */
    @Pointcut(value = "execution(* jay.spring.aopanno.User.add(..))")
    public void pointdemo() {
        
    }

    /** 前置通知 */
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before ...");
    }

    /** 有没有异常都通知 */
    @After(value = "pointdemo()")
    public void after(){
        System.out.println("after ...");
    }

    /** 有异常就不通知 */
    @AfterReturning(value = "pointdemo()")
    public void afterReturning(){
        System.out.println("AfterReturning ...");
    }

    /** 异常通知 */
    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing(){
        System.out.println("AfterThrowing ...");
    }

    /** 环绕通知 */
    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前 ...");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后 ...");
    }
}
