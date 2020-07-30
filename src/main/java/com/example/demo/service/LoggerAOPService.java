package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoggerAOPService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
        public void add(int a, int b) {
            logger.info ("The amount is {} ",a + b);
        }
}
