package f.g.org.org.stream.digests;

import f.g.b.a.d.c.a.a;
import f.g.b.a.d.c.b.b;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public final class f
{
  public final JsonFactory e;
  public Class<? extends b.b> i = b.b.class;
  public Class<? extends a.a> s = a.a.class;
  
  public f(JsonFactory paramJsonFactory)
  {
    if (paramJsonFactory != null)
    {
      e = paramJsonFactory;
      return;
    }
    throw new NullPointerException();
  }
  
  public f a(Class paramClass)
  {
    s = paramClass;
    return this;
  }
  
  public Class d()
  {
    return s;
  }
  
  public JsonFactory e()
  {
    return e;
  }
  
  public f e(Class paramClass)
  {
    i = paramClass;
    return this;
  }
  
  public Class i()
  {
    return i;
  }
  
  public JsonWebSignature parse(String paramString)
    throws IOException
  {
    int j = paramString.indexOf('.');
    boolean bool2 = true;
    boolean bool1;
    if (j != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    Object localObject = Base64.decodeBase64(paramString.substring(0, j));
    j += 1;
    int k = paramString.indexOf('.', j);
    if (k != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    int m = k + 1;
    if (paramString.indexOf('.', m) == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    byte[] arrayOfByte1 = Base64.decodeBase64(paramString.substring(j, k));
    byte[] arrayOfByte2 = Base64.decodeBase64(paramString.substring(m));
    paramString = StringUtils.getBytesUtf8(paramString.substring(0, k));
    localObject = (JsonWebSignature.Header)e.fromInputStream(new ByteArrayInputStream((byte[])localObject), s);
    if (((JsonWebSignature.Header)localObject).getAlgorithm() != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    return new JsonWebSignature((JsonWebSignature.Header)localObject, (JsonWebToken.Payload)e.fromInputStream(new ByteArrayInputStream(arrayOfByte1), i), arrayOfByte2, paramString);
  }
}
