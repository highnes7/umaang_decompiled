package f.g.c.package_8;

import f.g.c.b.ca;
import f.g.c.package_10.Predicate;
import java.util.Map.Entry;

public final class BeanPredicate
  implements ca<Map.Entry<K, V>>
{
  public BeanPredicate(Predicate paramPredicate) {}
  
  public boolean evaluate(Map.Entry paramEntry)
  {
    return predicate.apply(paramEntry.getValue());
  }
}
