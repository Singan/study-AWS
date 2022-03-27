package sunghee.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunghee.domain.posts.Posts;
import sunghee.domain.posts.PostsRepository;
import sunghee.web.dto.PostsResponseDto;
import sunghee.web.dto.PostsSaveRequestDto;
import sunghee.web.dto.PostsUpdateRequestDto;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto postSaveRequestDto){
        return postsRepository.save(postSaveRequestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id="+ id));



        return new PostsResponseDto(posts);
    }
    public List<PostsResponseDto> postsList() {
        List<PostsResponseDto> postsResponseDtos = new ArrayList<>();
        for (Posts posts :postsRepository.findAll()){
            postsResponseDtos.add(new PostsResponseDto(posts));

        }



        return postsResponseDtos;
    }
    public void savePosts(){
        
    }
}
