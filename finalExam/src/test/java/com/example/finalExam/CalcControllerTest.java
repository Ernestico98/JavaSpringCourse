package com.example.finalExam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class CalcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void multiplyMethodOnSetOfNumbers() throws Exception {
        var expected = 6;

        mockMvc.perform(MockMvcRequestBuilders.get("/multiply?numbers=1,2,3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expected)));
    }

    @Test
    public void multiplyOnEmptyList_givesBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/multiply?numbers=")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void multiplyOnMoreThanTenElements_givesBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/multiply?numbers=1,2,3,4,5,6,7,8,9,10,11")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void multiplyOnListWithZeroIsZero() throws Exception {
        var expected = 0;

        mockMvc.perform(MockMvcRequestBuilders.get("/multiply?numbers=1,2,3,4,5,0,6,7,8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expected)));
    }

    @Test
    public void sumListOfNumbers() throws Exception {
        var expected = 10;

        mockMvc.perform(MockMvcRequestBuilders.get("/sum?numbers=1,2,3,4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expected)));
    }

    @Test
    public void sumListOfEmptyListIsZero() throws Exception {
        var expected = 0;

        mockMvc.perform(MockMvcRequestBuilders.get("/sum?numbers=")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expected)));
    }

    @Test
    public void sumOnMoreThanTenElements_givesBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sum?numbers=1,2,3,4,5,6,7,8,9,10,11")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}