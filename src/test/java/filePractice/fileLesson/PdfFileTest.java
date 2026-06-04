package filePractice.fileLesson;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PdfFileTest {
    private ClassLoader cl = PdfFileTest.class.getClassLoader();


   // @Test
   // void pdfFileReadTest () throws Exception {
     //   try (InputStream is = new FileInputStream(
     //           (cl.getResourceAsStream("pdftest.pdf")
      //  ))
     //    {
     //                    if (is == null) {
     //        throw new IllegalStateException("Файл 'pdftest.pdf' не найден в папке resources!");
     //    }
     //       PDF pdf = new PDF(cl);
    //        System.out.println(pdf);
    //    }
  //  }

    @Test
    void zipFileParsingTest () throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("files/testArchive.zip")
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null)
            {
                System.out.println((entry.getName()));
            }
        }
    }

    @Test
    void pdfFileReadTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("pdftest.pdf")) {
            if (is == null) {
                throw new IllegalStateException("Файл 'pdftest.pdf' не найден в папке resources!");
            }
            PDF pdf = new PDF(is);
            String author = pdf.author;
            //System.out.println("Весь текст:\n" + author);
            Assertions.assertEquals("Yukon Department of Education", author);
        }
    }

}
