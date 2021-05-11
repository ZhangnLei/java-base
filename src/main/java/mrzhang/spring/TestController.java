package mrzhang.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zhangnianlei
 * @description
 * @date 2021/4/20
 */
public class TestController {

	ApplicationContext appCt2 = new FileSystemXmlApplicationContext("src/main/resources/app.spring.xml");

//	appCt2.getBean("beanId");
}
