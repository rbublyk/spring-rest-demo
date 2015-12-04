package com.dataart.rbublyk;

import com.dataart.rbublyk.controller.ControllerTestSuite;
import com.dataart.rbublyk.dao.DaoTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringApplicationConfiguration(classes = DemoRestApplication.class)
@WebAppConfiguration
@RunWith(Suite.class)
@Suite.SuiteClasses({
		DaoTestSuite.class,
		ControllerTestSuite.class
})
public class DemoRestApplicationTests {
}
