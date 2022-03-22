package sunghee.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sunghee.service.posts.PostsService;
import sunghee.web.dto.PostsSaveRequestDto;
import sunghee.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    @ResponseBody
    public Long save(@RequestBody PostsSaveRequestDto postSaveRequestDto){
        return postsService.save(postSaveRequestDto); // DB에 넣었을 때 해당 PK 반환
    }
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) { //생성자 빌더 실행
        return postsService.update(id, requestDto); //서비스 update 실행 > PostsRespository(JPA).findById 해서 찾고 UPDATE
    }
}
