package sunghee.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sunghee.service.posts.PostsService;
import sunghee.web.dto.PostsSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postService;
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto postSaveRequestDto){
        return postService.save(postSaveRequestDto);
    }
}
