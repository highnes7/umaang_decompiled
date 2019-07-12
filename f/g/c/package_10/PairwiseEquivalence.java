package f.g.c.package_10;

import f.g.c.a.b;
import f.g.c.b.C;
import java.io.Serializable;
import java.util.Iterator;

@b(serializable=true)
public final class PairwiseEquivalence<T>
  extends C<Iterable<T>>
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public final C<? super T> elementEquivalence;
  
  public PairwiseEquivalence(Equivalence paramEquivalence)
  {
    if (paramEquivalence != null)
    {
      elementEquivalence = paramEquivalence;
      return;
    }
    throw new NullPointerException();
  }
  
  public boolean doEquivalent(Iterable paramIterable1, Iterable paramIterable2)
  {
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    while ((paramIterable1.hasNext()) && (paramIterable2.hasNext())) {
      if (!elementEquivalence.equivalent(paramIterable1.next(), paramIterable2.next())) {
        return false;
      }
    }
    return (!paramIterable1.hasNext()) && (!paramIterable2.hasNext());
  }
  
  public int doHash(Iterable paramIterable)
  {
    paramIterable = paramIterable.iterator();
    Object localObject;
    for (int i = 78721; paramIterable.hasNext(); i = i * 24943 + elementEquivalence.hash(localObject)) {
      localObject = paramIterable.next();
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PairwiseEquivalence))
    {
      paramObject = (PairwiseEquivalence)paramObject;
      return elementEquivalence.equals(elementEquivalence);
    }
    return false;
  }
  
  public int hashCode()
  {
    return elementEquivalence.hashCode() ^ 0x46A3EB07;
  }
  
  public String toString()
  {
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(), elementEquivalence, ".pairwise()");
  }
}
