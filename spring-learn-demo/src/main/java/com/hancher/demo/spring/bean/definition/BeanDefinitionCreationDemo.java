package com.hancher.demo.spring.bean.definition;

import com.hancher.demo.spring.domain.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年05月13日 10:57
 * @version 1.0
 * @since 1.0
 */
public class BeanDefinitionCreationDemo {
	public static void main(String[] args) {

		// 1.通过 BeanDefinitionBuilder 构建
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		// 通过属性设置
		beanDefinitionBuilder
				.addPropertyValue("id", 1)
				.addPropertyValue("name", "寒澈");
		// 获取 BeanDefinition 实例
		BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		// BeanDefinition 并非 Bean 终态，可以自定义修改

		// 2. 通过 AbstractBeanDefinition 以及派生类
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		// 设置 Bean 类型
		genericBeanDefinition.setBeanClass(User.class);
		// 通过 MutablePropertyValues 批量操作属性
		MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "小马哥");
		propertyValues
				.add("id", 1)
				.add("name", "小马哥");
		// 通过 set MutablePropertyValues 批量操作属性
		genericBeanDefinition.setPropertyValues(propertyValues);
		System.out.println("成功");
	}
}
