package com.tutorial.elasticsearch.search;

import com.tutorial.elasticsearch.search.model.Article;
import com.tutorial.elasticsearch.search.model.Author;
import com.tutorial.elasticsearch.search.repository.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchTest {
    @Autowired ArticleRepository articleRepository;

    String[] title = null;
    String[] firstNames = {"John", "Alice", "Bob", "Eva", "Charlie", "Olivia", "Daniel", "Sophia", "Michael", "Emma",
            "Alex", "Lily", "David", "Grace", "Tom", "Sophie", "Chris", "Mia", "Ryan", "Zoe",
            "Andrew", "Chloe", "Jason", "Ava", "Luke", "Emily", "Brian", "Nora", "Kyle", "Luna"};

    @BeforeEach
    void beforeEach() {
        title = DataCreator.generateTitles();
        List<Article> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            list.add(new Article("" + i, title[i], generateRandomAuthorList()));
        }

        articleRepository.saveAll(list);
    }

    private List<Author> generateRandomAuthorList() {
        Random random = new Random();
        int len = random.nextInt(5) + 1;
        List<Author> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Author(firstNames[random.nextInt(firstNames.length)]));
        }
        return list;
    }

    @AfterEach
    void afterEach() {
        articleRepository.deleteAll();
    }

    @Test
    void test1() {
        PageRequest pageable = PageRequest.of(0, 10);
        List<Article> byAuthorsName = articleRepository
                .findByAuthorsNameUsingCustomQuery(firstNames[0], pageable).getContent();
        
        for (Article article : byAuthorsName) {
            System.out.println(article);
        }
    }

}