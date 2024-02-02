package uniba.forumapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uniba.forumapp.entity.Topic;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String> {

    List<Topic> findByTopicId_Email(String email);

    Topic findByTopicId_EmailAndTopicId_Title(String email, String title);

}
