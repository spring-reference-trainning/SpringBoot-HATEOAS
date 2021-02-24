package me.kwj1270.springboot.hateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        // linkTo: 컨트롤러나, 핸들러 메소드로부터 URI 정보 읽어올 때 쓰는 메소드, 스프링 HATEOAS 프로젝트에서 제공하는 유틸리티
        // methodOn : 지정된 클래스에 가짜 메서드를 호출 한다.
        // withSelfRel : Link 인스턴스를 만들어 해당 URL이 자기 참조인 것을 나타낸다. -> "self" : { "href" : }로 만든다.
        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}
