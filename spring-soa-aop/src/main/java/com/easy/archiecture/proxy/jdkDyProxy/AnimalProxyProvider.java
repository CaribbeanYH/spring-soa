package com.easy.archiecture.proxy.jdkDyProxy;
 
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2024/7/25 14:44
 */
public class AnimalProxyProvider {
    //利用接口类型对传入的对象做接收 (多态)
    private Animal targetAnimal;
 
    //通过带参构造传入一个Animal接口实现类的对象
    public AnimalProxyProvider(Animal targetAnimal) {
        this.targetAnimal = targetAnimal;
    }
 
    //编写一个方法，用于返回代理对象 (用到反射机制)
    public Animal getAnimalProxy() {
        /**
         java.lang.reflect.Proxy类中的 newProxyInstance方法可以返回一个代理对象。
         public static Object newProxyInstance(ClassLoader loader,
             Class<?>[] interfaces,
             InvocationHandler h)
             throws IllegalArgumentException {...}
            该方法需要传入三个实参 ———
            (1) ClassLoader loader : 类加载器
            (2) Class<?>[] interfaces : 接口信息
            (3) InvocationHandler h : 调用处理器，其本身也是一个接口，内部声明了抽象方法invoke。
         */
 
        //(1)得到类加载器
        ClassLoader classLoader = targetAnimal.getClass().getClassLoader();
 
        //(2)得到被执行对象的接口信息(因为newProxyInstance方法底层是通过接口来调用的，即接口多态)
        Class<?>[] interfaces = targetAnimal.getClass().getInterfaces();
 
        //(3)得到处理器对象(通过匿名内部类实现,最终返回的是一个匿名内部类对象)
        //!!![注意，处理器对象本身也是newProxyInstance方法的一个形参]
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy the proxy instance that the method was invoked on
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *
             * @return : the results of method instance invoked
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                    将相同的业务逻辑代码，放在处理器对象的invoke方法中，
                    避免了代码下沉到每个实现类所造成的代码冗余。
                 */
                System.out.println("要吃饭的嘛~");
 
                //通过反射调用实现类中的方法
                Object results = method.invoke(targetAnimal, args);
 
                System.out.println("吃完了捏~");
 
                return results;
            }
        };
 
        Animal animalProxy = (Animal) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
 
        return animalProxy;
    }
}