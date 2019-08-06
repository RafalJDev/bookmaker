package pl.bookmaker.app.bookmakerapp.controller;

import com.jayway.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bookmaker.app.bookmakerapp.BookmakerAppApplication;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookmakerAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BetControllerIT {
    
    @LocalServerPort
    int port;
    
    @Test
    public void firstTest() throws Exception {
        Response response = given().port(port)
                                   .body("{ \"WIN\":\"100\"," + "\"PLACE\":\"100\", " + "\"SHOW\":\"100\"}")
                                   .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                                   .post("bet")
                                   .thenReturn();
        
        response.prettyPrint();
        
        assertEquals(200, response.statusCode());
        
        //@formatter:off
        String expectedBody = "{\n" +
"    \"amounts\": [\n" +
"        {\n" +
"            \"bookmakerName\": \"first\",\n" +
"            \"finalResult\": 74500.0\n" +
"        },\n" +
"        {\n" +
"            \"bookmakerName\": \"second\",\n" +
"            \"finalResult\": 68950.0\n" +
"        },\n" +
"        {\n" +
"            \"bookmakerName\": \"third\",\n" +
"            \"finalResult\": 0.0\n" +
"        }\n" +
"    ]\n" +
"}";
        
        assertEquals(expectedBody.trim(), response.getBody().asString().trim());
    }
    
}