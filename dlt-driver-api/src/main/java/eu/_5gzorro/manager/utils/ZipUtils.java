package eu._5gzorro.manager.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

  private ZipUtils() {}

  public static <T> InputStream zipObject(T object, ObjectMapper mapper) throws IOException {
    InputStream is = new ByteArrayInputStream(mapper.writeValueAsBytes(object));
    ByteArrayOutputStream byteZipOutStream = new ByteArrayOutputStream();
    ZipOutputStream zipOut = new ZipOutputStream(byteZipOutStream);
    ZipEntry zipEntry = new ZipEntry("object");
    zipOut.putNextEntry(zipEntry);
    byte[] bytes = new byte[1024];

    int length;
    while ((length = is.read(bytes)) >= 0) {
      zipOut.write(bytes, 0, length);
    }
    zipOut.close();

    InputStream zipInputStream = new ByteArrayInputStream(byteZipOutStream.toByteArray());
    byteZipOutStream.close();
    is.close();
    return zipInputStream;
  }

  public static <T> T unzipObject(InputStream is, ObjectMapper mapper) throws IOException {
    ZipInputStream zis = new ZipInputStream(is);
    zis.getNextEntry(); // get first entry

    // create a buffer to improve copy performance later.
    byte[] buffer = new byte[2048];

    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      int len = 0;
      while ((len = zis.read(buffer)) > 0) {
        output.write(buffer, 0, len);
      }

      return mapper.readValue(output.toByteArray(), new TypeReference<T>() {});
    }
  }
}
