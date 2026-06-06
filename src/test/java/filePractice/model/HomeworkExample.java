package filePractice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeworkExample {
    @JsonProperty("name")
    private String name;

    @JsonProperty("AGE")
    private Integer age;

    @JsonProperty("favoriteFood")
    private HomeworkExampleFood favoriteFood;

    @JsonProperty("friends")
    private List<HomeworkExampleFriends> friends;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {

        return age;
    }

    public void setAge (Integer age) {
        this.age = age;
    }

    public HomeworkExampleFood getFood() {

        return favoriteFood;
    }

    public void setFood(HomeworkExampleFood favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public  List<HomeworkExampleFriends> getFriends () {
        return friends;
    }

    public void setFriends(List<HomeworkExampleFriends> friends) {
        this.friends = friends;
    }

}
