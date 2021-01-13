package tdtes;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class OrangeTest {
	private static Orange o1, o2, o3, o4;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		o1 = new Orange(15, "France");
		o2 = new Orange(15, "France");
		o3 = new Orange(20, "France");
		o4 = new Orange(15, "Espagne");
	}

	@Test public void test() {
		assert(o1.getClass().equals(Orange.class));
		assertEquals(o1, o2);
		assertNotEquals(o1, o3);
		assertNotEquals(o1, o4);
	}
	
	@Test public void testGetters() {
		assertEquals("France", o1.getOrigine());
		assertTrue(15 == o1.getPrix());
	}
	
	@Test public void testToString() {
		assertEquals("Orange: France / 15.00", o1.toString());
	}
}
