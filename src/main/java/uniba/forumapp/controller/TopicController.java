package uniba.forumapp.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniba.forumapp.dto.TopicDTO;
import uniba.forumapp.service.TopicService;

import java.util.List;

@RestController
@RequestMapping
public class TopicController {

    @Autowired
    private TopicService topicService;

    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @PostMapping("/secured/insertTopic")
    public ResponseEntity<String> insertTopic(@RequestBody TopicDTO topicDTO) {
        ResponseEntity<String> responseEntity = null;
        try {
            if (topicService.insertTopic(topicDTO)) {
                responseEntity = ResponseEntity.ok("The topic is correctly saved");
            }
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());

        }
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @PostMapping("/secured/getTopic")
    public List<TopicDTO> getTopic(@RequestBody String email) {
        return topicService.retrieveByEmail(email);
    }

    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @PostMapping("/secured/getTopicByTitle")
    public TopicDTO getTopicContent(@RequestBody TopicDTO topicDTO) {
        return topicService.retrieveByEmailAndTitle(topicDTO);
    }

    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @GetMapping("/secured/getAllTopic")
    public List<TopicDTO> getAllTopic() {
        return topicService.retrieveAll();
    }


}