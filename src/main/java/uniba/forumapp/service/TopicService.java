package uniba.forumapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniba.forumapp.dto.TopicDTO;
import uniba.forumapp.entity.Topic;
import uniba.forumapp.entity.TopicId;
import uniba.forumapp.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    public TopicDTO retrieveByEmailAndTitle(TopicDTO topicDTO){
        return formTopicToTopicDTOMapper(
                topicRepository.findByTopicId_EmailAndTopicId_Title(
                        topicDTO.getEmail(),topicDTO.getTitle()));
    }
    public boolean insertTopic(TopicDTO topicDTO) throws Exception {
        boolean returnValue = false;
        if(!topicDTO.getTitle().isEmpty() && !topicDTO.getContent().isEmpty()) {
            if (topicRepository.save(fromTopicDTOToTopicMapper(topicDTO)) != null) {
                returnValue = true;
            }
        } else {
            throw new Exception("I campi non sono popolati correttamente");
        }
        return returnValue;
    }

    public List<TopicDTO> retrieveByEmail(String email){
        if (email.startsWith("\"") && email.endsWith("\"")) {
            // Remove the double quotes
            email = email.substring(1, email.length() - 1);
            System.out.println("String after removing quotes: " + email);
        } else {
            System.out.println("String doesn't start and end with quotes.");
        }
        ArrayList<TopicDTO> returnTopic = new ArrayList<>();
        for(Topic t : topicRepository.findByTopicId_Email(email)){
            returnTopic.add(formTopicToTopicDTOMapper(t));
        }
        return returnTopic;
    }

    public List<TopicDTO> retrieveAll(){
        ArrayList<TopicDTO> returnTopic = new ArrayList<>();
        for(Topic t : topicRepository.findAll()){
            returnTopic.add(formTopicToTopicDTOMapper(t));
        }
        return returnTopic;
    }
    private Topic fromTopicDTOToTopicMapper(TopicDTO topicDTO) {
        return new Topic(new TopicId(topicDTO.getEmail(), topicDTO.getTitle()), topicDTO.getContent());
    }
    private TopicDTO formTopicToTopicDTOMapper(Topic topic){
        return new TopicDTO(topic.getTopicId().getEmail(),topic.getTopicId().getTitle(),topic.getContent());
    }

}
