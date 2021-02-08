package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class PdfTests {

    @Test
    void verifyContentInPdf() throws IOException {
        String actualFilePath = "src/test/resources/html/1.pdf";
        String expectedFileText = "Workspace of files_job on мастер";

        File actualFile = new File(actualFilePath);
        PDF pdf = new PDF(actualFile);

        assertThat(pdf, PDF.containsText(expectedFileText));

    }
}
