package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@SpringBootTest(classes = DemoApplication.class)
public class PDFReadTests {
   private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /*@Test
    public void PDFRead(){
        String filePath = "/Users/dpriyadarshini/DeeptiDocs/Relocation_Claim.docx";
        try(Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)){
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
