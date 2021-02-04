package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TxtTests {

    @Test
    void verifyContentInTxt(){
        File file = new File("src/test/resources/html/index.html");
        String filePath = file.getAbsolutePath();

        open(filePath);
        assertTrue(title().equals("QA.GURU examples"));

    }
}
