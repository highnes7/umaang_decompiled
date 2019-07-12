package f.g.org.org.org.objectweb.asm;

import f.g.b.a.b.b.b.h.a;
import f.g.b.a.g.h;
import f.g.org.org.dom4j.tree.Item;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.digests.JsonWebSignature;
import f.g.org.org.stream.digests.JsonWebSignature.Header;
import f.g.org.org.stream.digests.JsonWebToken;
import f.g.org.org.stream.digests.f;
import java.io.IOException;
import java.security.GeneralSecurityException;

@h
public class ContentType
  extends Item
{
  public ContentType(JsonWebSignature.Header paramHeader, Property paramProperty, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramHeader, paramProperty, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static ContentType parse(JsonFactory paramJsonFactory, String paramString)
    throws IOException
  {
    paramJsonFactory = new f(paramJsonFactory).e(h.a.class).parse(paramString);
    return new ContentType(paramJsonFactory.getHeader(), (Property)paramJsonFactory.get(), paramJsonFactory.getSignatureBytes(), paramJsonFactory.getSignedContentBytes());
  }
  
  public boolean add(Record paramRecord)
    throws GeneralSecurityException, IOException
  {
    return paramRecord.verify(this);
  }
  
  public Property get()
  {
    return (Property)payload;
  }
}
