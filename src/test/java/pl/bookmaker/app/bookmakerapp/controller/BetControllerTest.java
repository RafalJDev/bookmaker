package pl.bookmaker.app.bookmakerapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.bookmaker.app.bookmakerapp.handler.BetHandler;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BetController.class)
public class BetControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    BetHandler betHandler;
    
    @Test
    public void firstTest() throws Exception {
        this.mockMvc.perform(post("/bet").content("{ \"win\":\"100\"," +
                                                      "\"placee\":\"100\", " +
                                                      "\"show\":\"100\"}")
                                         .contentType(APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("{\n" + "  \"amounts\": [\n" + "    {\n" + "      " +
                                                                   "\"bookmakerName\": \"A\",\n" + "      " +
                                                                   "\"amount\":" + " \"115\"\n" + "    },\n" + "    " + "{\n" + "      " + "\"bookmakerName\": \"B\",\n" + "      \"amount\":" + " \"110\"\n" + "    }\n" + "  ]\n" + "}")));
    }
    
}