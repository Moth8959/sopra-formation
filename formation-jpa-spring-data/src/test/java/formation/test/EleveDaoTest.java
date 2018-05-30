package formation.test;

import org.junit.Assert;
import org.junit.Test;


public class EleveDaoTest {
	
	@Test
	public void TestOne() {
		System.out.println("One");
		Assert.assertEquals(10, 8+2);
	}
	
	@Test
	public void TestTWo() {
		System.out.println("Two");
		Assert.fail();
	}
	
	@Test
	public void Testthree() {
		System.out.println("three");
		throw new RuntimeException("Erreur du test 3");
	}
}
