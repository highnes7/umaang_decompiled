package f.g.org.org.stream.util;

import f.fasterxml.jackson.core.JsonEncoding;
import f.fasterxml.jackson.core.JsonGenerator.Feature;
import f.g.org.org.stream.JsonGenerator;
import f.g.org.org.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public final class JsonFactory
  extends f.g.org.org.stream.JsonFactory
{
  public final f.fasterxml.jackson.core.JsonFactory factory = new f.fasterxml.jackson.core.JsonFactory(null);
  
  public JsonFactory()
  {
    factory.configure(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT, false);
  }
  
  public static f.g.org.org.stream.JsonToken convert(f.fasterxml.jackson.core.JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      return null;
    }
    switch (paramJsonToken.ordinal())
    {
    default: 
      break;
    case 6: 
      return f.g.org.org.stream.JsonToken.NOT_AVAILABLE;
    case 5: 
      return f.g.org.org.stream.JsonToken.FIELD_NAME;
    case 8: 
      return f.g.org.org.stream.JsonToken.VALUE_NUMBER_INT;
    case 9: 
      return f.g.org.org.stream.JsonToken.VALUE_NUMBER_FLOAT;
    case 7: 
      return f.g.org.org.stream.JsonToken.VALUE_STRING;
    case 12: 
      return f.g.org.org.stream.JsonToken.VALUE_NULL;
    case 10: 
      return f.g.org.org.stream.JsonToken.VALUE_TRUE;
    case 11: 
      return f.g.org.org.stream.JsonToken.VALUE_FALSE;
    case 1: 
      return f.g.org.org.stream.JsonToken.START_OBJECT;
    case 2: 
      return f.g.org.org.stream.JsonToken.END_OBJECT;
    case 3: 
      return f.g.org.org.stream.JsonToken.START_ARRAY;
    }
    return f.g.org.org.stream.JsonToken.END_ARRAY;
  }
  
  public static JsonFactory getFactory()
  {
    return NoAnimation.NO_ANIMATION_FACTORY;
  }
  
  public JsonGenerator createJsonGenerator(OutputStream paramOutputStream, Charset paramCharset)
    throws IOException
  {
    return new JsonGeneratorDelegate(this, factory.createGenerator(paramOutputStream, JsonEncoding.UTF8));
  }
  
  public JsonGenerator createJsonGenerator(Writer paramWriter)
    throws IOException
  {
    return new JsonGeneratorDelegate(this, factory.createJsonGenerator(paramWriter));
  }
  
  public JsonParser createJsonParser(InputStream paramInputStream)
    throws IOException
  {
    if (paramInputStream != null) {
      return new JsonParserDelegate(this, factory.createJsonParser(paramInputStream));
    }
    throw new NullPointerException();
  }
  
  public JsonParser createJsonParser(InputStream paramInputStream, Charset paramCharset)
    throws IOException
  {
    if (paramInputStream != null) {
      return new JsonParserDelegate(this, factory.createJsonParser(paramInputStream));
    }
    throw new NullPointerException();
  }
  
  public JsonParser createJsonParser(Reader paramReader)
    throws IOException
  {
    if (paramReader != null) {
      return new JsonParserDelegate(this, factory.createJsonParser(paramReader));
    }
    throw new NullPointerException();
  }
  
  public JsonParser createJsonParser(String paramString)
    throws IOException
  {
    if (paramString != null) {
      return new JsonParserDelegate(this, factory.createJsonParser(paramString));
    }
    throw new NullPointerException();
  }
}
