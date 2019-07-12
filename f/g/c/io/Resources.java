package f.g.c.io;

import f.g.c.a.a;
import f.g.c.g.M;
import f.g.c.package_10.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@a
public final class Resources
{
  public Resources() {}
  
  public static InputSupplier copy(URL paramURL)
  {
    if (paramURL != null) {
      return new CharSource(paramURL);
    }
    throw new NullPointerException();
  }
  
  public static void copy(URL paramURL, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramURL != null)
    {
      ByteStreams.copy(new CharSource(paramURL), paramOutputStream);
      return;
    }
    throw new NullPointerException();
  }
  
  public static URL getResource(Class paramClass, String paramString)
  {
    URL localURL = paramClass.getResource(paramString);
    boolean bool;
    if (localURL != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "resource %s relative to %s not found.", new Object[] { paramString, paramClass.getName() });
    return localURL;
  }
  
  public static URL getResource(String paramString)
  {
    URL localURL = M.class.getClassLoader().getResource(paramString);
    boolean bool;
    if (localURL != null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "resource %s not found.", new Object[] { paramString });
    return localURL;
  }
  
  public static InputSupplier newReaderSupplier(URL paramURL, Charset paramCharset)
  {
    if (paramURL != null)
    {
      paramURL = new CharSource(paramURL);
      if (paramCharset != null) {
        return new CharStreams.2(paramURL, paramCharset);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static byte[] read(URL paramURL)
    throws IOException
  {
    if (paramURL != null) {
      return ByteStreams.toByteArray(new CharSource(paramURL));
    }
    throw new NullPointerException();
  }
  
  public static Object readLines(URL paramURL, Charset paramCharset, LineProcessor paramLineProcessor)
    throws IOException
  {
    return CharStreams.readLines(newReaderSupplier(paramURL, paramCharset), paramLineProcessor);
  }
  
  public static List readLines(URL paramURL, Charset paramCharset)
    throws IOException
  {
    return CharStreams.readLines(newReaderSupplier(paramURL, paramCharset));
  }
  
  public static String toString(URL paramURL, Charset paramCharset)
    throws IOException
  {
    return CharStreams.toString(newReaderSupplier(paramURL, paramCharset));
  }
}
