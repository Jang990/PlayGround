package com.tutorial.elasticsearch.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataCreator {

    public static String[] generateTitles() {
        String[] titles = new String[100];
        for (int i = 0; i < 100; i++) {
            titles[i] = generateRandomITTitle();
        }
        return titles;
    }

    private static String generateRandomITTitle() {
        String[] itTopics = {"Artificial Intelligence", "Cybersecurity Trends", "Blockchain Technology", "Cloud Computing Strategies",
                "Data Science Applications", "IoT Innovations", "Mobile App Development Trends", "Cyber Threat Intelligence",
                "Big Data Analytics", "DevOps Best Practices", "Machine Learning Algorithms", "Quantum Computing Advances",
                "Edge Computing Solutions", "5G Impact on Industries", "Augmented Reality Developments", "Cybersecurity Frameworks",
                "Digital Transformation Strategies", "IT Project Management Tips", "Robotic Process Automation", "UI/UX Design Principles",
                "Software Development Methodologies", "E-commerce Technology Trends", "Cybersecurity Education Initiatives",
                "Network Security Protocols", "Open Source Software Trends", "Tech Industry Diversity", "Smart Cities Innovations",
                "Fintech Disruptions", "Health Tech Advances"};

        Random random = new Random();
        return itTopics[random.nextInt(itTopics.length)] + " " + itTopics[random.nextInt(itTopics.length)];
    }
}
