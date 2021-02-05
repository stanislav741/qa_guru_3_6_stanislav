package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import utils.FileUtils;

import java.io.File;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TxtTests {

    @Test
    void verifyContentInTxt(){
//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = PROXY;
//        Configuration.reportsFolder = "";

        String expectedFileText = "Test text line";

//        String filePath = file.getAbsolutePath();
//        open(filePath);
//        assertTrue(title().equals("QA.GURU examples"));
//        $("#txt").download();

        File file = new File("src/test/resources/html/1.txt");
        String actualFileText = new FileUtils().readStringFromFile(file.getPath());
        System.out.println("Actual text from file: \n" + actualFileText);

        assertTrue(actualFileText.contains(expectedFileText));
    }
}
