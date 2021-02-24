package me.kwj1270.springboot.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class Greeting extends RepresentationModel<Greeting> {

    private final String content;

    // @JsonCreator :
    // json을 인스턴스로 만드는 과정에서 Jackson은 생성자와 Setter를 기준으로 바인딩한다.
    // 하지만, Setter를 사용하게 된다면, 해당 인스턴스는 가변객체인 상태로 사용되어야 한다.
    // 이를 막기위해 Jackson이 인스턴스를 만드는 동안만 생성자와 Setter를 사용하게끔 만들어준다.

    // @JsonProperty :
    // Jackson이 생성자 인수를 넣어야하는 필드를 표시한다. 즉, 특정 Json 값을 해당 파라미터로 받는다.

    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
