package shikha.Global.journalApp.ApiResp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Weather {
    private Current current;

    @Setter
    @Getter
    public class Current{
        @JsonProperty("temperature")
        private int temperature;
    }


}
