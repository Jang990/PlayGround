package com.example.KafkaAndELK.example;

import com.example.KafkaAndELK.example.nested.TeamNested;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamNestedSearchRepository extends ElasticsearchRepository<TeamNested, Long> {
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
    List<TeamNested> searchTeam(String name, String role);

    @Query("""
                {
                    "nested": {
                        "path": "members",
                        "query": {
                            "bool": {
                                "must": [
                                  {"match": {"members.name": "?0"}},
                                  {"match": {"members.role": "?1"}}
                                ]
                            }
                        }
                    }
                }
            """)
    List<TeamNested> searchNested(String name, String role);
}
