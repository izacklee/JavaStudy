2021.01.08
#### 1 JDK的动态代理
   动态代理：Java动态代理和CGLib动态代理
   动态代理是JDK的，不是Spring的，AOP利用动态代理的方式实现
   什么是反射、代理、静态代理、动态代理？
    反射：动态语言，在程序执行期间动态加载类及其成员ClassLoader的
    代理：是一种设计模式，在目标对象上增加的一些额外功能，保证原存在的代码不被修改
    静态代理：需要自定义接口或父类，被代理对象和代理对象都需要一起实现或继承相同的父类
    动态代理：是JDK提供的一个特性，为解决静态代理的问题，如需要自定义接口或父类，高耦合度等问题，并保留原特性下产生的，
        被代理对象必须实现一组接口。  
#### 2 Spring AOP        
   spring的事务是基于spring aop去实现的，所以不支持直接调用方法，支持方法的执行，也就是在方法里调用执行。   
   案例可看day45y_springaop
       