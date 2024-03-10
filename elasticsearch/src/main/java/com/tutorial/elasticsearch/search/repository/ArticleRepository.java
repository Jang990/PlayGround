package com.tutorial.elasticsearch.search.repository;

import com.tutorial.elasticsearch.search.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    Page<Article> findByAuthorsName(String name, Pageable pageable);

    /*{
        "bool": {
            "must": [
              {"match": {"authors.name": "?0"}}
            ]
        }
    }*/
    // Article(title=..., authors=[..., Author(name=John), ...], tags=[...]) 이런 조건은 모두 부합
    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

    /*{
        "bool": {
            "must": {
                "match_all": {}
            },
            "filter": {
                "term": {"tags": "?0" }
            }
        }
    }*/
    // match_all - 모든 문서 대상. & 그 중에 tags에 정확히 일치
    @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
    Page<Article> findByFilteredTagQuery(String tag, Pageable pageable);

    /*{
        "bool": {
            "must": {
                "match": {"authors.name": "?0"}
            },
            "filter": {
                "term": {"tags": "?1" }
            }
        }
    }*/
    @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
    Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable);
}
