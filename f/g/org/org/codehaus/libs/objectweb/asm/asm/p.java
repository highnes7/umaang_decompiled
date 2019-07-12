package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import java.io.IOException;
import java.util.Iterator;

public class p
  extends f
{
  public p(f paramF1, f paramF2)
  {
    super(paramF2, null);
  }
  
  public d a(String paramString)
  {
    if (paramString != null) {
      throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
    throw new NullPointerException();
  }
  
  public Appendable a(Appendable paramAppendable, Iterator paramIterator)
    throws IOException
  {
    Preconditions.checkNotNull(paramAppendable, "appendable");
    Preconditions.checkNotNull(paramIterator, "parts");
    Object localObject;
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramAppendable.append(d.a(localObject));
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramAppendable.append(d.d);
        paramAppendable.append(d.a(localObject));
      }
    }
    return paramAppendable;
  }
  
  public f c(String paramString)
  {
    if (paramString != null) {
      throw new UnsupportedOperationException("already specified skipNulls");
    }
    throw new NullPointerException();
  }
}
