package f.g.org.org.org.objectweb.asm;

import f.g.b.a.g.h;
import f.g.org.org.dom4j.tree.i;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.digests.JsonWebSignature;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.List;

@h
public class Record
  extends i
{
  public final Log this$0;
  
  public Record(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    super(paramHttpTransport);
    this$0 = d;
  }
  
  public Record(Label paramLabel)
  {
    super(paramLabel);
    this$0 = d;
  }
  
  public Record(Log paramLog)
  {
    super(paramLog);
    this$0 = d;
  }
  
  public final long f()
  {
    return this$0.f();
  }
  
  public final JsonFactory getData()
  {
    return this$0.getText();
  }
  
  public final Log getKey()
  {
    return this$0;
  }
  
  public final String getType()
  {
    return this$0.d();
  }
  
  public final HttpTransport log()
  {
    return this$0.log();
  }
  
  public ContentType parse(String paramString)
    throws GeneralSecurityException, IOException
  {
    paramString = ContentType.parse(getData(), paramString);
    if (verify(paramString)) {
      return paramString;
    }
    return null;
  }
  
  public final List parse()
    throws GeneralSecurityException, IOException
  {
    return this$0.getPublicKeys();
  }
  
  public Record replace()
    throws GeneralSecurityException, IOException
  {
    this$0.refresh();
    return this;
  }
  
  public boolean verify(ContentType paramContentType)
    throws GeneralSecurityException, IOException
  {
    if (!super.add(paramContentType)) {
      return false;
    }
    Iterator localIterator = this$0.getPublicKeys().iterator();
    while (localIterator.hasNext()) {
      if (paramContentType.verifySignature((PublicKey)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}
