package f.g.org.org.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public abstract interface ObjectParser
{
  public abstract Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Class paramClass)
    throws IOException;
  
  public abstract Object parseAndClose(InputStream paramInputStream, Charset paramCharset, Type paramType)
    throws IOException;
  
  public abstract Object parseAndClose(Reader paramReader, Class paramClass)
    throws IOException;
  
  public abstract Object parseAndClose(Reader paramReader, Type paramType)
    throws IOException;
}
