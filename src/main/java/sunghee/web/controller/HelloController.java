package sunghee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sunghee.domain.posts.PostsRepository;
import sunghee.web.dto.HelloResponseDto;

@RestController
public class HelloController {
    @Autowired
    PostsRepository postsRepository;
    @GetMapping("/hello")
    public String hello(){ return "hello"; }


    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name , @RequestParam("amount")int amount) {
        return new HelloResponseDto(name,amount);
    }
}
