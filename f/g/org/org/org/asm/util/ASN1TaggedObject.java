package f.g.org.org.org.asm.util;

import f.g.b.a.b.h.f;
import f.g.b.a.g.h;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import java.io.IOException;

@h
public abstract class ASN1TaggedObject<T>
  extends f<T>
{
  public static final long EXTRA_GOTO_DATE = 1L;
  
  public ASN1TaggedObject() {}
  
  public abstract JsonFactory getJsonFactory()
    throws IOException;
  
  public final JsonObjectParser getObjectParser()
    throws IOException
  {
    return new JsonObjectParser(getJsonFactory());
  }
}
