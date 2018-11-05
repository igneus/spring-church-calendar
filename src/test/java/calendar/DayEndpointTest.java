package calendar;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DayEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnExpectedDayData() throws Exception {
        assertThat(this.restTemplate.getForObject(this.endpointPath(),
                String.class)).isEqualTo("{\"date\":\"2018-10-18\"}");
    }

    protected String endpointPath() {
        return "http://localhost:" + port + "/api/v1/calendars/general-en/2018/10/18";
    }
}