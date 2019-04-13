package pl.grzegorzo96.demo.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import pl.grzegorzo96.demo.DemoApplicationTests;

public class HelloWorldEndPointTest extends DemoApplicationTests {
    @Test
    public void shouldReturnGreetings(){
        // given - dane wejsciowe
        final String url = "http://localhost:" + port + "/hello"; //dana
        // when - co testujemy
        // wykonac request http na localhost:8080/hello
        ResponseEntity<String> response = httpClient.getForEntity(url, String.class); // 2 argument to co ma zwracac klasa
        // then - sprawdzanie
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
        Assertions.assertThat(response.getBody()).isEqualTo("Hello heroku world!");
        // odpowiedz bedzie zawierala napis "Hello World" i kod 200 (HTTP)
    }
}
