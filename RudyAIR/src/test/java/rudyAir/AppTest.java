package rudyAir;

import rudyAir.util.Context;

public class AppTest {
	public static void main(String[] args) {

		Context.getEntityManagerFactory();

		Context.destroy();
		
		System.out.println("Hello");
		
	}
}
