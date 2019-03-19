package pl.grzegorzo96.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	TestRestTemplate httpClient;

	@LocalServerPort
	int port;

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
