package com.zhl;

import com.zhl.application.Test1;
import com.zhl.beanfactoryprocessor.MyBeanDefinitionRegistryPostProcessor;
import com.zhl.cyclicreference.A;
import com.zhl.cyclicreference.AppConfig;
import com.zhl.cyclicreference.B;
import com.zhl.mybatis.MyBatisConfig;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * ClassName: SpringTest
 * Package: com.baizhiedu
 * Description <p/>
 *
 * @author zhl
 * @since 2024-05-05 21:25
 * version 1.0
 */
public class SpringTest {

    /**
     * 测试 实现   BeanFactoryPostProcessor 的子接口  BeanDefinitionRegistryPostProcessor 操作 BD
     * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor
     * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
     */
    @Test
    public void beanFactoryPostProcessorTest(){
        /*
         *  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.zhl.beanfactoryprocessor.AppConfig.class); =》
         *  this() register() refresh() 一起执行的
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.zhl.beanfactoryprocessor.AppConfig.class);
        // （方法1）尝试把它分开  =>
        // ==> this()
        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // ==> register()
        ctx.register(com.zhl.beanfactoryprocessor.AppConfig.class);
        // 如果直接这样 Spring 无法感知到，因为 A 还未注册，需要 refresh
        // 尝试让A register 和 addBeanFactoryPostProcessor 平级，让 Spring感知到       ===> 执行符合预期
        ctx.register(com.zhl.beanfactoryprocessor.A.class);
        // ==> 需要保证 ctx.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor()); 运行在 refresh() 之前
        ctx.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
        // ==> refresh()
        ctx.refresh();*/
        // （二）也可以在实现 BeanDefinitionRegistryPostProcessor 接口的类中使用 @Component 注解

        // 默认bean是 singleton，现在修改 bd 的 scope=prototype
        com.zhl.beanfactoryprocessor.A a = (com.zhl.beanfactoryprocessor.A) ctx.getBean("a");
        com.zhl.beanfactoryprocessor.A a1 = (com.zhl.beanfactoryprocessor.A) ctx.getBean("a");

        System.out.println("a = " + a);
        System.out.println("a1 = " + a1);
    }

    @Test
    public void importBeanDefinitionRegistrarTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        com.zhl.mybatis.UserService userServiceImpl = (com.zhl.mybatis.UserService) applicationContext.getBean("userServiceImpl");
        userServiceImpl.register();
        String s= "sdddsd";

    }

    /**
     * 测试 Spring 注册bean的几种方式
     */
    @Test
    public void beanTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.zhl.application.AppConfig.class);
//        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext("com.zhl.application");


    }

    /**
     * 测试 创建 beanDefinition 的几种方式
     */
    @Test
    public void beanDefinitionTest(){
        /*BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Test1.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();*/
        // 或
        /*AnnotatedBeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(Test1.class);*/

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Test1.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();

        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("password", "111");

        ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
        constructorArgumentValues.addArgumentValues(null);
    }

    /**
     * 测试 AnnotationConfigApplicationContext
     */
    @Test
    public void applicationContextTest(){
        /*DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        User u = (User) beanFactory.getBean("u");*/
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(com.zhl.application.AppConfig.class);
//        Test1 test1 = (Test1) applicationContext.getBean("test1");

    }

    /**
     * 测试 循环引用的问题（普通的循环引用和复杂的循环引用）
     *      例如创建的代理之间循环引用
     */
    @Test
    public void cyclicReferenceTest(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = (A) applicationContext.getBean("a");
        B b = (B) applicationContext.getBean("b");
        a.showB();
        b.showA();
    }

    @Test
    public void aopTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        com.zhl.aop.UserService userService = (com.zhl.aop.UserService) ctx.getBean("userService");
//        userService.register();
    }

    @Test
    public void typedBeanTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User u = (User) ctx.getBean("u");
    }

    /**
     * 测试 使用注解扫描
     */
    @Test
    public void processorAnnotationTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        com.zhl.prcessannotation.Product product = (com.zhl.prcessannotation.Product) ctx.getBean("product");
        System.out.println("product = " + product);
        System.out.println("product.getAccount() = " + product.getAccount());
    }

    /**
     * 测试 父子 bean
     */
    @Test
    public void parentSonBeanDefinitionTest(){
        DefaultListableBeanFactory ctx = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader1 = new XmlBeanDefinitionReader(ctx);
        xmlBeanDefinitionReader1.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));

        User u = (User) ctx.getBean("u");
//        User p = (User) ctx.getBean("p");

    }

    /**
     * 测试 父子容器问题
     */
    @Test
    public void parentSonContainersTest(){
        DefaultListableBeanFactory parent = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(parent);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("applicationContext-parents.xml"));

        //绑定父子关系
        DefaultListableBeanFactory child = new DefaultListableBeanFactory(parent);
        XmlBeanDefinitionReader xmlBeanDefinitionReader1 = new XmlBeanDefinitionReader(child);
        xmlBeanDefinitionReader1.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));

        // 一旦使用父子容器，配置信息最后会整合   子容器没有的配置，会从父容器中找
        Product product = (Product) child.getBean("product");
        User user = (User) child.getBean("user");

        System.out.println("user = " + user);
        System.out.println("product = " + product);
    }

    @Test
    public void beanPostProcessorTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("u");
        System.out.println(user.getId());
    }

    @Test
    public void destroyBeanTest(){
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        User user = (User) beanFactory.getBean("user");
        beanFactory.destroySingletons();
    }

    @Test
    public void initBeanTest(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        User user = (User) beanFactory.getBean("u");
    }

    /**
     * 测试 scope 属性失效
     */
    @Test
    public void scopeInvalidTest() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        // 根据 <bean id="userDAO" class="com.zhl.UserDAOImpl" scope="prototype"/>    获取 Bean
        UserDAO userDAO = (UserDAO) beanFactory.getBean("userDAO");
        UserDAO userDAO1 = (UserDAO) beanFactory.getBean("userDAO");
        userDAO.save();
        userDAO1.save();

        System.out.println(userDAO);    //com.zhl.UserDAOImpl@3dd4520b
        System.out.println(userDAO1);   //com.zhl.UserDAOImpl@5ae63ade
    }

    /**
     * 测试 scope 属性失效
     */
    @Test
    public void scopeInvalidTest2(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) beanFactory.getBean("userService");
//        UserService userService1 = (UserService) beanFactory.getBean("userService");

        userService.register();
//        userService1.register();
    }

    @Test
    public void beanFactoryAwareTest() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.register();
    }

    @Test
    public void containerSetTest() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        User u = (User) beanFactory.getBean("u");
        u.getUserBeanFactoryName();
        u.getUserBeanName();
        System.out.println("当前容器 beanFactory = " + beanFactory);
    }

    @Test
    public void customXmlTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = (User) ctx.getBean("u");
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }

    @Test
    public void xmlTest() {

        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        Product product = (Product) beanFactory.getBean("product");
        System.out.println(product);

        // 使用 DefaultListableFactory 和 XmlBeanDefinitionReader  替换掉XmlBeanFactory =》 @Deprecated
                /*DefaultListableBeanFactory beanFactory1 = new DefaultListableBeanFactory();
                Resource resource = new ClassPathResource("applicationContext.xml");
                XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory1);
                xmlBeanDefinitionReader.loadBeanDefinitions(resource);

                Object product1 = beanFactory1.getBean("product");
                System.out.println(product1);*/

    }

    @Test
    public void springTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        System.out.println("product = " + product);
    }
}
