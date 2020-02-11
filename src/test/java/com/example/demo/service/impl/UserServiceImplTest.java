package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.model.UserResource;
import com.example.demo.service.UserService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUser() throws Exception {
        UserResource ur1 = new UserResource();
        ur1.setName("Saurav");
        UserResource ur2 = new UserResource();
        ur1.setName("Saurav");
        UserResource ur3 = new UserResource();
        ur1.setName("Shiva");
        when(userService.findAll()).thenReturn(Arrays.asList(ur1, ur2, ur3));
        mockMvc.perform(MockMvcRequestBuilders.get("/user/finUserByDepatment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Shiva")))
                .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
    }
}