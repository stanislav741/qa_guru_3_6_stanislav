package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class XlsTests {

    @Test
    void verifyContentInXls() throws IOException {
        String actualFilePath = "src/test/resources/html/1.xlsx";
        String expectedFileText = "some text";

        File actualFile = new File(actualFilePath);
        XLS xls = new XLS(actualFile);

        assertThat(xls, XLS.containsText(expectedFileText));

    }
}
