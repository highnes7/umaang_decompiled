package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Ab;
import f.g.c.d.mf;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@b(serializable=true)
public final class ExplicitOrdering<T>
  extends mf<T>
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public final Ab<T, Integer> rankMap;
  
  public ExplicitOrdering(ImmutableMap paramImmutableMap)
  {
    rankMap = paramImmutableMap;
  }
  
  public ExplicitOrdering(List paramList)
  {
    rankMap = paramList;
  }
  
  public static ImmutableMap buildRankMap(List paramList)
  {
    Ab.a localA = ImmutableMap.builder();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localA.put(paramList.next(), Integer.valueOf(i));
      i += 1;
    }
    return localA.build();
  }
  
  private int rank(Object paramObject)
  {
    Integer localInteger = (Integer)rankMap.get(paramObject);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new mf.c(paramObject);
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return rank(paramObject1) - rank(paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ExplicitOrdering))
    {
      paramObject = (ExplicitOrdering)paramObject;
      return rankMap.equals(rankMap);
    }
    return false;
  }
  
  public int hashCode()
  {
    return rankMap.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Ordering.explicit(");
    localStringBuilder.append(rankMap.keySet());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}
