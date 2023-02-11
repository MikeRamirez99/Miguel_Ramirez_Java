package com.company.summative1.controllers;
import com.company.summative1.models.quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(quoteController.class)

public class quoteControllerTest {
@Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();
    private List<quote> quoteList;

@Test
    public void CheckForOKStatus() throws Exception {
    String outputJson = mapper.writeValueAsString(quoteList);
    mockMvc.perform(get("/quote"))
            .andDo(print())
            .andExpect(status().isOk());
}

}