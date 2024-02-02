package uniba.forumapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@Getter
@Setter
public class TopicId implements Serializable {
    @NotBlank
    @NotEmpty
    private String email;

    @NotBlank
    @NotEmpty
    private String title;

    public TopicId() {

    }
}
