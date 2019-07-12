package f.g.org.org.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class AdapterBoolean
{
  public AdapterBoolean() {}
  
  public static ArrayList parse()
  {
    return new ArrayList();
  }
  
  public static ArrayList parse(int paramInt)
  {
    return new ArrayList(paramInt);
  }
  
  public static ArrayList parse(Iterable paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new ArrayList((Collection)paramIterable);
    }
    return parseAttributes(paramIterable.iterator());
  }
  
  public static ArrayList parseAttributes(Iterator paramIterator)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramIterator.hasNext()) {
      localArrayList.add(paramIterator.next());
    }
    return localArrayList;
  }
}
