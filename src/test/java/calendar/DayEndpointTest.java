package calendar;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DayEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnExpectedDayData() throws Exception {
        this.successTest(this.endpointPath(), "{\"date\":\"2018-10-18\"}");
    }

    @Test
    public void shouldReturnExpectedDayData2() throws Exception {
        this.successTest(this.endpointPath(2000, 7, 5), "{\"date\":\"2000-07-05\"}");
    }

    @Test
    public void monthOverflow() throws Exception {
        // this is not behaviour we love, but Java behaves this way and there's no important requirement to change this
        this.successTest(this.endpointPath(2000, 7, 33), "{\"date\":\"2000-08-02\"}");
    }

    protected void successTest(String path, String resultBody) throws Exception {
        this.mockMvc.perform(get(path)).andExpect(status().isOk())
                .andExpect(content().string(resultBody));
    }

    protected String endpointPath() {
        return this.endpointPath(2018, 10, 18);
    }

    protected String endpointPath(int year, int month, int day) {
        return "/api/v1/calendars/general-en/" +
                String.format("%d/%d/%d", year, month, day);
    }
}