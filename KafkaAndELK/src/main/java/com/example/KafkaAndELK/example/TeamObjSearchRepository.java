package com.example.KafkaAndELK.example;

import com.example.KafkaAndELK.example.obj.TeamObj;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamObjSearchRepository extends ElasticsearchRepository<TeamObj, Long> {
    @Query("""
                {
                    "bool": {
                        "must": [
                          {"match": {"members.name": "?0"}},
                          {"match": {"members.role": "?1"}}
                        ]
                    }
                }
            """)
    List<TeamObj> searchTeam(String name, String role);
}
