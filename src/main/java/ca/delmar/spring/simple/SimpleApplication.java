package ca.delmar.spring.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ca.delmar.spring.simple.service.HelloWorldService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SimpleApplication implements CommandLineRunner {

        // Simple example shows how a command line spring application can execute an
        // injected bean service. Also demonstrates how you can use @Value to inject
        // command line args ('--name=whatever') or application properties

        @Autowired
        private HelloWorldService helloWorldService;

        @Override
        public void run(String... args) {
            System.out.println(this.helloWorldService.getHelloMessage());
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(SimpleApplication.class, args);
        }
}
