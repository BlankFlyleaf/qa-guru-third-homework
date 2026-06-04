package filePractice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeworkExampleFood {

    @JsonProperty("FRUIT")
    private String fruit;

    @JsonProperty("SOUP")
    private String soup;

    public String getFruit() {

        return fruit;
    }

    public void setFruit (String fruit) {
        this.fruit = fruit;
    }

    public String getSoup() {

        return soup;
    }

    public void setSoup (String soup) {
        this.soup = soup;
    }

}