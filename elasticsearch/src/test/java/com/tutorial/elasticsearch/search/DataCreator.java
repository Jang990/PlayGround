package com.tutorial.elasticsearch.search;

import java.util.Random;

public class DataCreator {

    private static final String[] AVAILABLE_TAGS = {"Java", "Spring", "Hibernate", "REST", "Database", "Frontend", "JavaScript",
            "HTML", "CSS", "Python", "Machine Learning", "Big Data", "Cloud Computing", "DevOps", "Security", "Agile", "Mobile",
            "Web Development", "Microservices", "Blockchain", "Docker", "Kubernetes", "React", "Angular", "Vue.js", "Node.js",
            "Git", "Testing", "CI/CD", "UI/UX"};
    private static final String[] itTopics = new String[]{"Artificial Intelligence", "Cybersecurity Trends", "Blockchain Technology", "Cloud Computing Strategies",
            "Data Science Applications", "IoT Innovations", "Mobile App Development Trends", "Cyber Threat Intelligence",
            "Big Data Analytics", "DevOps Best Practices", "Machine Learning Algorithms", "Quantum Computing Advances",
            "Edge Computing Solutions", "5G Impact on Industries", "Augmented Reality Developments", "Cybersecurity Frameworks",
            "Digital Transformation Strategies", "IT Project Management Tips", "Robotic Process Automation", "UI/UX Design Principles",
            "Software Development Methodologies", "E-commerce Technology Trends", "Cybersecurity Education Initiatives",
            "Network Security Protocols", "Open Source Software Trends", "Tech Industry Diversity", "Smart Cities Innovations",
            "Fintech Disruptions", "Health Tech Advances"};

    public static String[] generateRandomTags() {
        Random random = new Random();
        int count = random.nextInt(10) + 1;  // Random count between 1 and 10
        String[] tags = new String[count];

        for (int i = 0; i < count; i++) {
            tags[i] = getRandomTag(random);
        }

        return tags;
    }

    public static String[] generateTitles() {
        String[] titles = new String[100];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = generateRandomITTitle();
        }
        return titles;
    }

    public static String getRandomTag() {
        return getRandomTag(new Random());
    }
    public static String getRandomTag(Random random) {
        return AVAILABLE_TAGS[random.nextInt(AVAILABLE_TAGS.length)];
    }

    private static String generateRandomITTitle() {
        return getRandomTopic() + " " + getRandomTopic();
    }

    private static String getRandomTopic() {
        Random random = new Random();
        return itTopics[random.nextInt(itTopics.length)];
    }
}
