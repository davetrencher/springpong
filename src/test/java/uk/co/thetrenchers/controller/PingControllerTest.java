package uk.co.thetrenchers.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.co.thetrenchers.config.ApplicationProperties;
import uk.co.thetrenchers.model.Ping;
import uk.co.thetrenchers.spring.SpringProfile;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
@ActiveProfiles(profiles = SpringProfile.TEST)
public class PingControllerTest {

    private static final String RESPONSE_MESSAGE = String.format("response\":\"%s\"}","This is a pong");
    public static final String REST_ENDPOINT_PING = "/ping";

    @Autowired
    ApplicationProperties applicationProperties;

    private MockMvc mockMvc;

    @InjectMocks
    @Resource
    PingController pingController;

    @MockBean
    Ping ping;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(pingController);
        when(ping.getResponse()).thenReturn(applicationProperties.getPingProperties().getPingMessage());
        mockMvc = MockMvcBuilders.standaloneSetup(pingController).build();
    }

    @Test
    public void pingReturnsPong() throws Exception {

        mockMvc.perform(get(REST_ENDPOINT_PING,String.class))
                .andDo(print())
                .andExpect(status().isOk());

    }
}