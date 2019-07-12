package f.g.org.org.util;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@h
public final class PemReader
{
  public static final Pattern BEGIN_PATTERN = Pattern.compile("-----BEGIN ([A-Z ]+)-----");
  public static final Pattern END_PATTERN = Pattern.compile("-----END ([A-Z ]+)-----");
  public BufferedReader reader;
  
  public PemReader(Reader paramReader)
  {
    reader = new BufferedReader(paramReader);
  }
  
  public static Section readFirstSectionAndClose(Reader paramReader)
    throws IOException
  {
    return readFirstSectionAndClose(paramReader, null);
  }
  
  public static Section readFirstSectionAndClose(Reader paramReader, String paramString)
    throws IOException
  {
    paramReader = new PemReader(paramReader);
    try
    {
      paramString = paramReader.readNextSection(paramString);
      paramReader.close();
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramReader.close();
      throw paramString;
    }
  }
  
  public void close()
    throws IOException
  {
    reader.close();
  }
  
  public Section readNextSection()
    throws IOException
  {
    return readNextSection(null);
  }
  
  public Section readNextSection(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = null;
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2 = reader.readLine();
      if (localObject2 == null)
      {
        boolean bool;
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        Preconditions.checkArgument(bool, "missing end tag (%s)", new Object[] { localObject1 });
        return null;
      }
      if (localStringBuilder == null)
      {
        localObject2 = BEGIN_PATTERN.matcher((CharSequence)localObject2);
        if (((Matcher)localObject2).matches())
        {
          localObject2 = ((Matcher)localObject2).group(1);
          if ((paramString == null) || (((String)localObject2).equals(paramString)))
          {
            localStringBuilder = new StringBuilder();
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        Matcher localMatcher = END_PATTERN.matcher((CharSequence)localObject2);
        if (localMatcher.matches())
        {
          paramString = localMatcher.group(1);
          Preconditions.checkArgument(paramString.equals(localObject1), "end tag (%s) doesn't match begin tag (%s)", new Object[] { paramString, localObject1 });
          return new Section(localObject1, Base64.decodeBase64(localStringBuilder.toString()));
        }
        localStringBuilder.append((String)localObject2);
      }
    }
  }
  
  public final class Section
  {
    public final byte[] base64decodedBytes;
    
    public Section(byte[] paramArrayOfByte)
    {
      if (PemReader.this != null)
      {
        if (paramArrayOfByte != null)
        {
          base64decodedBytes = paramArrayOfByte;
          return;
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    
    public byte[] getBase64DecodedBytes()
    {
      return base64decodedBytes;
    }
    
    public String getTitle()
    {
      return PemReader.this;
    }
  }
}
