package com.alan.test.testspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test02 {
    @LocalServerPort
    private int port;
    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testTest() throws MalformedURLException {
        base = new URL("http://localhost:" + port + "/test");
        ResponseEntity<String> response = testRestTemplate.getForEntity(base.toString(),String.class);
        System.out.println(response.getBody());
    }
}
