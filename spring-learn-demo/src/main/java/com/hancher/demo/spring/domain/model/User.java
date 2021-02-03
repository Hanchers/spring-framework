package com.hancher.demo.spring.domain.model;

import com.hancher.demo.spring.domain.enums.CityEnum;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 用户实体
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年05月13日 13:21
 * @version 1.0
 * @since 1.0
 */
public class User implements BeanNameAware {
	private Long id;

	private String name;

	private CityEnum city;

	private CityEnum[] workCities;

	private List<CityEnum> lifeCities;

	private Resource configFileLocation;

	private Company company;

	private Properties context;

	private String contextAsText;

	/**
	 * 当前 Bean 的名称
	 */
	private transient String beanName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityEnum getCity() {
		return city;
	}

	public void setCity(CityEnum city) {
		this.city = city;
	}

	public Resource getConfigFileLocation() {
		return configFileLocation;
	}

	public void setConfigFileLocation(Resource configFileLocation) {
		this.configFileLocation = configFileLocation;
	}

	public CityEnum[] getWorkCities() {
		return workCities;
	}

	public void setWorkCities(CityEnum[] workCities) {
		this.workCities = workCities;
	}

	public List<CityEnum> getLifeCities() {
		return lifeCities;
	}

	public void setLifeCities(List<CityEnum> lifeCities) {
		this.lifeCities = lifeCities;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static User createUser() {
		User user = new User();
		user.setId(1L);
		user.setName("寒澈");
		return user;
	}

	@PostConstruct
	public void init() {
		System.out.println("User Bean [" + beanName + "] 初始化...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("User Bean [" + beanName + "] 销毁中...");
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	public Properties getContext() {
		return context;
	}

	public void setContext(Properties context) {
		this.context = context;
	}

	public String getContextAsText() {
		return contextAsText;
	}

	public void setContextAsText(String contextAsText) {
		this.contextAsText = contextAsText;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city=" + city +
				", workCities=" + Arrays.toString(workCities) +
				", lifeCities=" + lifeCities +
				", configFileLocation=" + configFileLocation +
				", company=" + company +
				", context=" + context +
				", contextAsText='" + contextAsText + '\'' +
				", beanName='" + beanName + '\'' +
				'}';
	}
}
