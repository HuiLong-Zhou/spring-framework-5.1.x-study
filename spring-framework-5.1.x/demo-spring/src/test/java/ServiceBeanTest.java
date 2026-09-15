
import org.junit.jupiter.api.Test;
import org.springframework.ServiceTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: ServiceBeanTest
 * Package: com.zhl
 * Description <p/>
 *
 * @author zhl
 * @Create 2024-05-06 21:05
 * version 1.0
 */
public class ServiceBeanTest {
	@Test
	public void SpringSourceTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ServiceTestBean serviceBean = ctx.getBean(ServiceTestBean.class);
		System.out.println(serviceBean);
	}
}
