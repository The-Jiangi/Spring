package jay.spring.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
  1、连接点：
        类里哪些方法可以被增强，这些方法叫做连接点
  2、切入点：
        实际真正被增强的方法，叫做嵌切入点
        切入点表达式：知道对哪个类里面的哪个方法进行增强
            execution([权限修饰符][返回类型][类全路径][方法名称][参数列表])
            execution(* jay.spring.dao.UserDao.add(..))
            execution(* jay.spring.dao.UserDao.*(..))
            execution(* jay.spring.dao.*.*(..))
  3、通知（增强）
        实际增强的逻辑部分，称为通知（增强）
         * 前置通知
         * 后置通知
         * 环绕通知
         * 异常通知
         * 最终通知
  4、切面（是动作）
        把通知应用到切入点的过程，叫切面
 * */
public class JDKProxy {
    public static void main(String[] args) {
        // 创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDao userDao = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDaoImpl));
        int result = userDao.add(1,2);
        System.out.println("result："+result);
    }
}

/** 创建代理对象代码(增强的逻辑的代码) */
class UserDaoProxy implements InvocationHandler {

    /**
     * 1、创建的是谁的代理对象，就把它传过来
     * 有参构造
     * */
    private final Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    /** 增强的逻辑 */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("在方法之前执行了："+method.getName()+" 传递的参数："+ Arrays.toString(args));

        // 被增强的方法执行
        Object res = method.invoke(obj, args);

        // 方法之后
        System.out.println("在方法之后执行了："+obj);
        return res;
    }
}