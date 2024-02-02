package uniba.forumapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Topic {
    @EmbeddedId
    private TopicId topicId;

    @NotEmpty
    @NotBlank
    private String content;

    public Topic() {

    }
}
