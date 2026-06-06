package filePractice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeworkExampleFriends {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendName() {
        return name;
    }

    public void setFriendName(String name) {
        this.name = name;
    }

}
