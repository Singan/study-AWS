package sunghee.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunghee.domain.posts.Posts;
import sunghee.domain.posts.PostsRepository;
import sunghee.web.dto.PostsSaveRequestDto;
import sunghee.web.dto.PostsUpdateRequestDto;

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
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
