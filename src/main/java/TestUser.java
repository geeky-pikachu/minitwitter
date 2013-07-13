import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.minitwitter.config.ServiceConfig;
import com.minitwitter.domain.User;
import com.minitwitter.service.impl.UserServiceImpl;


public class TestUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ServiceConfig.class);
		
		User user = new User();
		user.setUsername("user01");
		user.setPassword1("12345");
		user.setPassword2("12345");
		user.setEmail("user01@mail.com");
		System.out.println(user.isNewUser());
		
		UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
		User afterRegister = userService.userRegister(user);
		List<String> list = userService.listAllUser("user02");
		System.out.println(list.get(0));
	}

}
