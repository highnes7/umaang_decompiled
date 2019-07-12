package f.libs.asm.menu;

import java.io.InputStream;
import l.a.a.a.a.e.TShortCollection;

public class TSynchronizedShortCollection
  implements TShortCollection
{
  public final TDoubleCollection c;
  
  public TSynchronizedShortCollection(TDoubleCollection paramTDoubleCollection)
  {
    c = paramTDoubleCollection;
  }
  
  public long getNoEntryValue()
  {
    return -1L;
  }
  
  public String remove()
  {
    return c.remove();
  }
  
  public InputStream retainAll()
  {
    return c.retainAll();
  }
  
  public String[] toArray()
  {
    return c.toArray();
  }
}
