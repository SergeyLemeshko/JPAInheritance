package com.lemeshko.jpa;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lemeshko.jpa.service.ProjectService;

@ContextConfiguration(locations = { "classpath:/META-INF/spring/app-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPersistenceTests {

	@Autowired
	private ProjectService projectService;

	@Test
	@Transactional
	public void testSaveProject() throws Exception {
		LargeProject project = new LargeProject();
		project.setBudget(new BigDecimal(100600));
		project.setName("TestProject");
		projectService.save(project);
		assertNotNull(project.getId());
	}
	//
	// @Test
	// @Transactional
	// public void testSaveAndGet() throws Exception {
	// Order order = new Order();
	// order.getItems().add(new Item());
	// entityManager.persist(order);
	// entityManager.flush();
	// // Otherwise the query returns the existing order (and we didn't set the
	// // parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager.find(Order.class, order.getId());
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }
	//
	// @Test
	// @Transactional
	// public void testSaveAndFind() throws Exception {
	// Order order = new Order();
	// Item item = new Item();
	// item.setProduct("foo");
	// order.getItems().add(item);
	// entityManager.persist(order);
	// entityManager.flush();
	// // Otherwise the query returns the existing order (and we didn't set the
	// // parent in the item)...
	// entityManager.clear();
	// Order other = (Order) entityManager
	// .createQuery(
	// "select o from Order o join o.items i where i.product=:product")
	// .setParameter("product", "foo").getSingleResult();
	// assertEquals(1, other.getItems().size());
	// assertEquals(other, other.getItems().iterator().next().getOrder());
	// }

}
