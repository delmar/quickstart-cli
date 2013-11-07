package ca.delmar.spring.simple;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.OutputCapture;

import static org.junit.Assert.assertTrue;

public class SimpleApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private String profiles;

    @Before
    public void init() {
        this.profiles = System.getProperty("spring.profiles.active");
    }

    @After
    public void after() {
        if (this.profiles != null) {
            System.setProperty("spring.profiles.active", this.profiles);
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultSettings() throws Exception {
        SimpleApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Hello Delmar"));
    }

    @Test
    public void testCommandLineOverrides() throws Exception {
        SimpleApplication.main(new String[]{"--name=Java"});
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Hello Java"));
    }
}
