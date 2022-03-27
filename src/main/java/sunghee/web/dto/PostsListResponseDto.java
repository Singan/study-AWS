package sunghee.web.dto;

import sunghee.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    public PostsListResponseDto(Posts posts) {
        this.author = posts.getAuthor();
        this.title = posts.getTitle();
        this.modifiedDate = posts.getModifiedDateTime();
        this.id = posts.getId();
    }
}
