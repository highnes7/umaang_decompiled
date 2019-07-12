package f.g.org.org.apache.util;

import f.g.b.a.g.h;
import f.g.org.org.stream.JsonGenerator;
import f.g.org.org.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

@h
public class JsonFactory
  extends f.g.org.org.stream.JsonFactory
{
  public JsonFactory() {}
  
  public JsonGenerator createJsonGenerator(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    return new MockJsonGenerator(this);
  }
  
  public JsonGenerator createJsonGenerator(Writer paramWriter)
    throws IOException
  {
    return new MockJsonGenerator(this);
  }
  
  public JsonParser createJsonParser(InputStream paramInputStream)
    throws IOException
  {
    return new MockJsonParser(this);
  }
  
  public JsonParser createJsonParser(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    return new MockJsonParser(this);
  }
  
  public JsonParser createJsonParser(Reader paramReader)
    throws IOException
  {
    return new MockJsonParser(this);
  }
  
  public JsonParser createJsonParser(String paramString)
    throws IOException
  {
    return new MockJsonParser(this);
  }
}
