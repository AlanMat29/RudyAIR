package rudyAir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import rudyAir.config.AppConfig;

@ContextConfiguration(classes = {AppConfig.class })
@ExtendWith(SpringExtension.class) //On charge Spring Context
public class CompteTest {

	@Test
	void test2() {
		
	}
	

}
