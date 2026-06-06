package filePractice.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipHelper {
    private ClassLoader cl = ZipHelper.class.getClassLoader();

    public InputStream getFileFromZip(String zipName, String fileName) throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream(zipName)
        )) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(fileName)) {
                    return new ByteArrayInputStream(zis.readAllBytes());
                }
            }
        }
        throw new IllegalArgumentException("File '" + fileName + "' not found in " + zipName);
    }
}
