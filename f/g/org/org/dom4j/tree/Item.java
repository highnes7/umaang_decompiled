package f.g.org.org.dom4j.tree;

import f.g.b.a.a.c.a.a;
import f.g.b.a.g.h;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.digests.JsonWebSignature;
import f.g.org.org.stream.digests.JsonWebSignature.Header;
import f.g.org.org.stream.digests.JsonWebToken;
import f.g.org.org.stream.digests.JsonWebToken.Payload;
import f.g.org.org.stream.digests.f;
import java.io.IOException;
import java.util.Collection;

@h
public class Item
  extends JsonWebSignature
{
  public Item(JsonWebSignature.Header paramHeader, Element paramElement, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramHeader, paramElement, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static Item parse(JsonFactory paramJsonFactory, String paramString)
    throws IOException
  {
    paramJsonFactory = new f(paramJsonFactory).e(a.a.class).parse(paramString);
    return new Item(paramJsonFactory.getHeader(), (Element)paramJsonFactory.get(), paramJsonFactory.getSignatureBytes(), paramJsonFactory.getSignedContentBytes());
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 <= (get().getExpirationTimeSeconds().longValue() + paramLong2) * 1000L;
  }
  
  public final boolean a(String paramString)
  {
    return paramString.equals(get().getIssuer());
  }
  
  public Element get()
  {
    return (Element)payload;
  }
  
  public final boolean set(long paramLong1, long paramLong2)
  {
    return paramLong1 >= (get().getIssuedAtTimeSeconds().longValue() - paramLong2) * 1000L;
  }
  
  public final boolean set(Collection paramCollection)
  {
    return paramCollection.containsAll(get().getAudienceAsList());
  }
  
  public final boolean update(long paramLong1, long paramLong2)
  {
    return (a(paramLong1, paramLong2)) && (set(paramLong1, paramLong2));
  }
}
