package f.g.org.org.stream;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.ObjectParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JsonObjectParser
  implements ObjectParser
{
  public final JsonFactory jsonFactory;
  public final Set<String> wrapperKeys;
  
  public JsonObjectParser(JsonFactory paramJsonFactory)
  {
    this(new Builder(paramJsonFactory));
  }
  
  public JsonObjectParser(Builder paramBuilder)
  {
    jsonFactory = jsonFactory;
    wrapperKeys = new HashSet(wrapperKeys);
  }
  
  private void initializeParser(JsonParser paramJsonParser)
    throws IOException
  {
    if (wrapperKeys.isEmpty()) {
      return;
    }
    try
    {
      Object localObject = paramJsonParser.skipToKey(wrapperKeys);
      if (localObject != null)
      {
        localObject = paramJsonParser.getCurrentToken();
        JsonToken localJsonToken = JsonToken.END_OBJECT;
        if (localObject != localJsonToken)
        {
          bool = true;
          break label49;
        }
      }
      boolean bool = false;
      label49:
      Preconditions.checkArgument(bool, "wrapper key(s) not found: %s", new Object[] { wrapperKeys });
      return;
    }
    catch (Throwable localThrowable)
    {
      paramJsonParser.close();
      throw localThrowable;
    }
  }
  
  public final JsonFactory getJsonFactory()
  {
    return jsonFactory;
  }
  
  public Set getWrapperKeys()
  {
    return Collections.unmodifiableSet(wrapperKeys);
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Class paramClass)
    throws IOException
  {
    return parseAndClose(paramInputStream, paramCharset, paramClass);
  }
  
  public Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Type paramType)
    throws IOException
  {
    paramInputStream = jsonFactory.createJsonParser(paramInputStream, paramCharset);
    initializeParser(paramInputStream);
    return paramInputStream.parse(paramType, true);
  }
  
  public Object parseAndClose(Reader paramReader, Class paramClass)
    throws IOException
  {
    return parseAndClose(paramReader, paramClass);
  }
  
  public Object parseAndClose(Reader paramReader, Type paramType)
    throws IOException
  {
    paramReader = jsonFactory.createJsonParser(paramReader);
    initializeParser(paramReader);
    return paramReader.parse(paramType, true);
  }
  
  public class Builder
  {
    public Collection<String> wrapperKeys = new HashSet();
    
    public Builder()
    {
      if (JsonObjectParser.this != null) {
        return;
      }
      throw new NullPointerException();
    }
    
    public JsonObjectParser build()
    {
      return new JsonObjectParser(this);
    }
    
    public final JsonFactory getJsonFactory()
    {
      return JsonObjectParser.this;
    }
    
    public final Collection getWrapperKeys()
    {
      return wrapperKeys;
    }
    
    public Builder setWrapperKeys(Collection paramCollection)
    {
      wrapperKeys = paramCollection;
      return this;
    }
  }
}
