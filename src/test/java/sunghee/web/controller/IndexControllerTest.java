package sunghee.web.controller;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import sunghee.domain.posts.Posts;
import sunghee.domain.posts.PostsRepository;
import sunghee.web.dto.PostsSaveRequestDto;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    @Autowired
    PostsRepository postsRepository;
    @Test
    public void indexTest() throws Exception {
        String body = this.restTemplate.getForObject("/",String.class);
        
        assertThat(body).contains("스프링 부트로 시작하는 웹서비스");
    }

    @Test
    public void savePosts() {
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "석성희";
        String body = this.restTemplate.getForObject("/posts/save",String.class);

        System.out.println(body.toString());

    }
    @Test
    public void postsUpdate() {
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "석성희";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        String body = this.restTemplate.getForObject("/posts/update/1",String.class);
        System.out.println(body);
    }

}