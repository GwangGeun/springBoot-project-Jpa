package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}

	/**
	 * proxy 객체를 null 이라는 값으로 반환하기 위해 설정하는 방법
	 * : 이런 방법도 있다는 정도로 알기 위한 목적 ( 해결책 -> 패치 조인을 사용해서 사용하는 것이 바람직 )
	 */
//	@Bean
//	Hibernate5Module hibernate5Module(){
//		Hibernate5Module hibernate5Module = new Hibernate5Module();
//		hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
//		return hibernate5Module;
//	}

}
