package f.g.c.package_8;

import f.g.c.b.ca;
import java.util.Collection;
import java.util.Map.Entry;

public class FieldWriter
  implements ca<Map.Entry<K, Collection<V>>>
{
  public FieldWriter(Be.h.a.c paramC, Collection paramCollection) {}
  
  public boolean put(Map.Entry paramEntry)
  {
    return c.contains(paramEntry.getValue()) ^ true;
  }
}
