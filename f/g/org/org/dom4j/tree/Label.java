package f.g.org.org.dom4j.tree;

import f.g.b.a.g.h;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.Item;
import java.util.Collection;

@h
public class Label
{
  public String a;
  public Collection<String> audience;
  public long b = 300L;
  public Item g = Item.g;
  
  public Label() {}
  
  public Label a(long paramLong)
  {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    b = paramLong;
    return this;
  }
  
  public Label a(Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Label a(String paramString)
  {
    a = paramString;
    return this;
  }
  
  public Label a(Collection paramCollection)
  {
    audience = paramCollection;
    return this;
  }
  
  public final Item a()
  {
    return g;
  }
  
  public final long flip()
  {
    return b;
  }
  
  public final Collection getAudience()
  {
    return audience;
  }
  
  public final String getFirst()
  {
    return a;
  }
  
  public i setIcon()
  {
    return new i(this);
  }
}
