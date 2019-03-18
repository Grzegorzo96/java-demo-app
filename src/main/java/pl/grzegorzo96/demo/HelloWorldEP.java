package pl.grzegorzo96.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldEP {
    //  localhosdt:8080/hello
    //  Hello World!

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    String hello(){
        return "Hello World!";
    }
}
