package tests;

import org.junit.jupiter.api.Test;
import utils.FileUtils;
import utils.ZipUtils;

import java.io.File;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipTests {

    @Test
    void verifyContentInZip(){
        String source = "src/test/resources/html/test_archive.zip";
        String destination = "src/test/resources/html/unzip";

        String expectedFileText = "Test text line";

        new ZipUtils().unzip(source, destination);
        sleep(1000);

        String actualFileText = new FileUtils().readStringFromFile(destination + "/1.txt");
        System.out.println("Actual text from file: \n" + actualFileText);

        assertTrue(actualFileText.contains(expectedFileText));
    }
}
