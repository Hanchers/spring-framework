package com.hancher.demo.spring.bean.definition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * spring bean 循环依赖
 *
 * <p/>
 * @author Hancher
 * @date Created in 2021年02月01日 15:35
 * @version 1.0
 * @since 1.0
 */
public class BeanCircularReferenceDemo {
	public static void main(String[] args) {
		// spring 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanCircularReferenceDemo.class);
		//是否开启循环引用 default true. 关闭后会抛异常
//		applicationContext.setAllowCircularReferences(false);
		// 启动容器
		applicationContext.refresh();

		A a = applicationContext.getBean(A.class);
		B b = applicationContext.getBean(B.class);
		a.hello();
		b.hello();

		// 关闭容器
		applicationContext.close();

		System.out.println("over...");
	}


	@Bean
	public A a() {
		return new A();
	}

	@Bean
	public B b() {
		return new B();
	}
	@Bean
	public C c() {
		return new C();
	}


	@Component
	public class A {
		private String name = "a";
		@Autowired
		private B b;
		@Autowired
		private C c;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public B getB() {
			return b;
		}

		public void setB(B b) {
			this.b = b;
		}

		public void hello() {
			System.out.println("my name is "+ name + ", and dependency b is "+ Optional.ofNullable(b).map(B::getName).orElse(null)+
					", and no dependency is " + Optional.ofNullable(c).map(C::getName).orElse(null));
		}
	}

	@Component
	public class B {
		private String name = "b";
		@Autowired
		private A a;
		@Autowired
		private C c;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void hello() {
			System.out.println("my name is "+ name + ", and dependency a is "+
					Optional.ofNullable(a).map(A::getName).orElse(null) +
					", and no dependency is " + Optional.ofNullable(c).map(C::getName).orElse(null)
			);
		}
	}

	@Component
	public class C {
		private String name = "c";

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
