package community.community;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "value=test", properties = {"properties.value=propertyTest"}, classes = {SpringBootApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommunityApplicationTests {

	@Value("${value}")
	private String value;

	@Value("${properties.value}")
	private String propertiesValue;

	@Test
	void contextLoads() {
		Assertions.assertThat(value).isEqualTo("Test");
	}

}
