package com.example.KafkaAndELK.product.v3.tag;

import com.example.KafkaAndELK.product.v3.entity.TagV3;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v3")
@RequiredArgsConstructor
public class TagController {
    private final TagRepository tagRepository;

    @GetMapping("/tag")
    public ResponseEntity<List<TagV3>> find() {
        return ResponseEntity.ok(tagRepository.findAll());
    }

    @PostMapping("/tag")
    public ResponseEntity<TagV3> save(@RequestBody Map<String, String> map) {
        TagV3 tag = new TagV3(map.get("tagName"));
        return new ResponseEntity<>(tagRepository.save(tag), HttpStatus.CREATED);
    }
}
