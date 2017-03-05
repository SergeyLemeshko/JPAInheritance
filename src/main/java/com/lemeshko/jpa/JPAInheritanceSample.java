package com.lemeshko.jpa;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lemeshko.jpa.service.ProjectService;

public class JPAInheritanceSample {

	public static void main(String[] args) {
		try (GenericXmlApplicationContext context = new GenericXmlApplicationContext()) {
			context.load("classpath:META-INF/spring/app-context.xml");
			context.refresh();

			ProjectService service = context.getBean("jpaProjectService", ProjectService.class);
			List<Project> projects = service.findAll();
			System.out.println(projects);

			// LargeProject proj = new LargeProject();
			// proj.setName("New LargeProject");
			// proj.setBudget(new BigDecimal(100700));
			// service.save(proj);

			// SmallProject smallProj = new SmallProject();
			// smallProj.setName("VerySmallProject");
			// service.save(smallProj);
		}
	}
}
