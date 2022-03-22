package sunghee.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sunghee.domain.posts.PostsRepository;
import sunghee.web.dto.PostsSaveRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto postSaveRequestDto){
        return postsRepository.save(postSaveRequestDto.toEntity()).getId();
    }
}
