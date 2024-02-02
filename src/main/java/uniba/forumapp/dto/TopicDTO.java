package uniba.forumapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TopicDTO {

    private String email;

    private String title;

    private String content;


}
