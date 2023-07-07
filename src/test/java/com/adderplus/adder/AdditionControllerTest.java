package com.adderplus.adder;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

@WebMvcTest(AdditionController.class)
public class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AdditionController additionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNumbers() throws Exception {
        int num1 = 2;
        int num2 = 3;
        int expectedResult = 5;

        mockMvc.perform(MockMvcRequestBuilders.get("/add")
                        .param("num1", String.valueOf(num1))
                        .param("num2", String.valueOf(num2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedResult)));
    }
}
  