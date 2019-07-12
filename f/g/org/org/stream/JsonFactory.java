package f.g.org.org.stream;

import f.g.org.org.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class JsonFactory
{
  public JsonFactory() {}
  
  private ByteArrayOutputStream toByteStream(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    JsonGenerator localJsonGenerator = createJsonGenerator(localByteArrayOutputStream, Charsets.UTF_8);
    if (paramBoolean) {
      localJsonGenerator.writeFieldName();
    }
    localJsonGenerator.serialize(paramObject);
    localJsonGenerator.flush();
    return localByteArrayOutputStream;
  }
  
  private String toString(Object paramObject, boolean paramBoolean)
    throws IOException
  {
    return toByteStream(paramObject, paramBoolean).toString("UTF-8");
  }
  
  public abstract JsonGenerator createJsonGenerator(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException;
  
  public abstract JsonGenerator createJsonGenerator(Writer paramWriter)
    throws IOException;
  
  public final JsonObjectParser createJsonObjectParser()
  {
    return new JsonObjectParser(this);
  }
  
  public abstract JsonParser createJsonParser(InputStream paramInputStream)
    throws IOException;
  
  public abstract JsonParser createJsonParser(InputStream paramInputStream, Charset paramCharset)
    throws IOException;
  
  public abstract JsonParser createJsonParser(Reader paramReader)
    throws IOException;
  
  public abstract JsonParser createJsonParser(String paramString)
    throws IOException;
  
  public final Object fromInputStream(InputStream paramInputStream, Class paramClass)
    throws IOException
  {
    return createJsonParser(paramInputStream).parseAndClose(paramClass);
  }
  
  public final Object fromInputStream(InputStream paramInputStream, Charset paramCharset, Class paramClass)
    throws IOException
  {
    return createJsonParser(paramInputStream, paramCharset).parseAndClose(paramClass);
  }
  
  public final Object fromReader(Reader paramReader, Class paramClass)
    throws IOException
  {
    return createJsonParser(paramReader).parseAndClose(paramClass);
  }
  
  public final Object fromString(String paramString, Class paramClass)
    throws IOException
  {
    return createJsonParser(paramString).parse(paramClass);
  }
  
  public final byte[] toByteArray(Object paramObject)
    throws IOException
  {
    return toByteStream(paramObject, false).toByteArray();
  }
  
  public final String toPrettyString(Object paramObject)
    throws IOException
  {
    return toByteStream(paramObject, true).toString("UTF-8");
  }
  
  public final String toString(Object paramObject)
    throws IOException
  {
    return toByteStream(paramObject, false).toString("UTF-8");
  }
}
