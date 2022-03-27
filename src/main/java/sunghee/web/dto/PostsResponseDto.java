package sunghee.web.dto;

import lombok.Getter;
import sunghee.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    public PostsResponseDto(Posts posts) {
        this.author = posts.getAuthor();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.id = posts.getId();
    }
}
