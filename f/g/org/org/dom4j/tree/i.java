package f.g.org.org.dom4j.tree;

import f.g.b.a.g.h;
import java.util.Collection;
import java.util.Collections;

@h
public class i
{
  public static final long ANIM_DURATION = 300L;
  public final long b;
  public final String c;
  public final f.g.org.org.util.Item g;
  public final Collection<String> j;
  
  public i()
  {
    this(new Label());
  }
  
  public i(Label paramLabel)
  {
    g = g;
    b = b;
    c = a;
    paramLabel = audience;
    if (paramLabel == null) {
      paramLabel = null;
    } else {
      paramLabel = Collections.unmodifiableCollection(paramLabel);
    }
    j = paramLabel;
  }
  
  public final String a()
  {
    return c;
  }
  
  public boolean add(Item paramItem)
  {
    Object localObject = c;
    if ((localObject == null) || (paramItem.a((String)localObject)))
    {
      localObject = j;
      if (((localObject == null) || (paramItem.set((Collection)localObject))) && (paramItem.update(g.currentTimeMillis(), b))) {
        return true;
      }
    }
    return false;
  }
  
  public final f.g.org.org.util.Item b()
  {
    return g;
  }
  
  public final Collection h()
  {
    return j;
  }
  
  public final long size()
  {
    return b;
  }
}
