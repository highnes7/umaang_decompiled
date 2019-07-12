package f.g.c.package_10;

import f.g.c.b.X;
import f.g.c.b.c;
import java.util.Iterator;

public class Switch
  extends c<T>
{
  public final Iterator<? extends X<? extends T>> i;
  
  public Switch(Optional.1 param1)
  {
    param1 = this$0.val$optionals.iterator();
    Preconditions.checkNotNull(param1);
    i = ((Iterator)param1);
  }
  
  public Object a()
  {
    while (i.hasNext())
    {
      Optional localOptional = (Optional)i.next();
      if (localOptional.equals()) {
        return localOptional.get();
      }
    }
    return read();
  }
}
