package me.kwj1270.springboot.hateoas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class GreetingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void hateoas_테스트() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"))
                .andExpect(jsonPath("$._links.self.href")
                        .value("http://localhost/greeting?name=World"));
    }
}