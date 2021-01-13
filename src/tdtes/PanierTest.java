package tdtes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class PanierTest {
	private static Panier p1, p2, p3, pVide, pPlein, pBoycott, pBoycottFinal;
	@BeforeClass public static void setUpBeforeClass() throws Exception {
		Orange o1 = new Orange(10, "France");
		Orange o2 = new Orange(10, "France");
		Orange o3 = new Orange(12, "France");
		Orange o4 = new Orange(15, "Italie");
		
		
		ArrayList<Orange> list1 = new ArrayList<Orange> ();
		list1.add(o1);
		p1 = new Panier(list1, 5);
		
		ArrayList<Orange> list2 = new ArrayList<Orange> ();
		list2.add(o2);
		p2 = new Panier(list2, 5);
		
		ArrayList<Orange> list3 = new ArrayList<Orange> ();
		list3.add(o3);
		p3 = new Panier(list3, 5);
		
		pVide = new Panier(new ArrayList<Orange>(), 5);
		pPlein = new Panier(list1, 1);
		
		ArrayList<Orange> listBoycott = new ArrayList<Orange> ();
		listBoycott.add(o4);
		listBoycott.add(o1);
		listBoycott.add(o4);
		listBoycott.add(o2);
		pBoycott = new Panier(listBoycott, 5);
		
		ArrayList<Orange> listBoycottFinal = new ArrayList<Orange> ();
		listBoycottFinal.add(o1);
		listBoycottFinal.add(o2);
		pBoycottFinal = new Panier(listBoycottFinal, 5);
	}

	@Test public void test() {
		assertEquals(p1.getClass(), Panier.class);
		assertFalse(p1.estVide());
		assertFalse(p1.estPlein());
		assertTrue(pVide.estVide());
		assertTrue(pPlein.estPlein());
	}
	
	@Test public void testEquals() {
		assertEquals(p1, p2);
		assertNotEquals(p1, p3);
	}
	
	@Test public void testToSting() {
		String str = String.format("Panier (5):%n");
		str += String.format("\t%s%n", new Orange(10, "France").toString());
		assertEquals(str, p1.toString());
	}
	
	@Test public void testAjouterRetirer() {
		assertTrue(10 == p1.getPrix());
		p1.ajoute(new Orange(15, "Algerie"));
		assertTrue(10+15 == p1.getPrix());
		p1.retire();
		assertTrue(10 == p1.getPrix());
	}
	
	@Test public void testBoycott() {
		pBoycott.boycotteOrigine("Italie");
		assertEquals(pBoycott, pBoycottFinal);
	}

}
