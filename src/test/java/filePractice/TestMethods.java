package filePractice;

import com.codeborne.xlstest.XLS;
import com.codeborne.pdftest.PDF;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import filePractice.model.HomeworkExample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class TestMethods extends TestBase {
    private ClassLoader cl = TestMethods.class.getClassLoader();

    @Test
    void pdfFromZipTest() throws Exception {
        try (InputStream is = zipHelper.getFileFromZip(
                "files/testArchive.zip", "pdftest.pdf"
        )) {

            assertThat(new PDF(is).author)
                    .isEqualTo("Yukon Department of Education");
        }
    }

    @Test
    void xmlFromZipTest() throws Exception{
        try (InputStream is = zipHelper.getFileFromZip(
                "files/testArchive.zip",
                "file_example_XLSX_10.xlsx"
        )) {
            XLS xls = new XLS(is);

            //Header checks
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 1)).contains("First Name");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 2)).contains("Last Name");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 3)).contains("Gender");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 4)).contains("Country");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 5)).contains("Age");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 6)).contains("Date");
            assertThat(xlsHelper.getCellValue(xls, 0, 0, 7)).contains("Id");
        }
    }

    @Test
    void csvFromZipTest() throws Exception {
        try (InputStream is = zipHelper.getFileFromZip(
                "files/testArchive.zip",
                "file_example_CSV_5000.csv"
        ); CSVReader csvReader = new CSVReader(new InputStreamReader(is)
        )) {
            List<String[]> data = csvReader.readAll();

            Assertions.assertEquals(5001, data.size());
            Assertions.assertArrayEquals(
                    new String[] {"4999","Jeromy","Danz","Male","United States","39","15/10/2017","3265"},
                    data.get(4999)
            );
            Assertions.assertArrayEquals(
                    new String[] {"4793","Angel","Sanor","Male","France","24","15/10/2017","3259"},
                    data.get(4793)
            );
        }
    }

    @Test
    void jaksonFromFileTest() throws Exception{
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("files/homeworkExample.json")
        )) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actual = mapper.readTree(reader);

            Assertions.assertEquals("Logan Keller", actual.get("name").asText());
            Assertions.assertEquals(32, actual.get("AGE").asInt());

            JsonNode inner = actual.get("favoriteFood");

            Assertions.assertEquals("apple", inner.get("FRUIT").asText());
            Assertions.assertEquals("borsch", inner.get("SOUP").asText());

            JsonNode friends = actual.get("friends");

            Assertions.assertEquals(3, friends.size());
            Assertions.assertEquals("Colon Salazar", friends.get(0).get("name").asText());
            Assertions.assertEquals(1,               friends.get(1).get("id").asInt());
            Assertions.assertEquals("Carol Martin",  friends.get(2).get("name").asText());
        }
    }

    @Test
    void jaksonFromModelTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("files/homeworkExample.json")
        )) {
            ObjectMapper mapper = new ObjectMapper();
            HomeworkExample actual = mapper.readValue(reader, HomeworkExample.class);

            Assertions.assertEquals("Logan Keller", actual.getName());
            Assertions.assertEquals(32, actual.getAge());
            Assertions.assertEquals("apple", actual.getFood().getFruit());
            Assertions.assertEquals("borsch", actual.getFood().getSoup());
            Assertions.assertEquals("Colon Salazar", actual.getFriends().get(0).getFriendName());
            Assertions.assertEquals(1,               actual.getFriends().get(1).getId());
            Assertions.assertEquals("Carol Martin",  actual.getFriends().get(2).getFriendName());

        }
    }
}
