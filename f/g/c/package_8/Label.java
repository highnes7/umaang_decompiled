package f.g.c.package_8;

import java.util.Iterator;
import java.util.Set;

public abstract class Label<C extends Comparable>
{
  public Label() {}
  
  public abstract Label a();
  
  public void a(Label paramLabel)
  {
    paramLabel = paramLabel.getValue().iterator();
    while (paramLabel.hasNext()) {
      b((Range)paramLabel.next());
    }
  }
  
  public void a(Range paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public void b(Label paramLabel)
  {
    paramLabel = paramLabel.getValue().iterator();
    while (paramLabel.hasNext()) {
      a((Range)paramLabel.next());
    }
  }
  
  public void b(Range paramRange)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Label))
    {
      paramObject = (Label)paramObject;
      return getValue().equals(paramObject.getValue());
    }
    return false;
  }
  
  public Range get(Comparable paramComparable)
  {
    if (paramComparable != null)
    {
      Iterator localIterator = getValue().iterator();
      while (localIterator.hasNext())
      {
        Range localRange = (Range)localIterator.next();
        if (localRange.contains(paramComparable)) {
          return localRange;
        }
      }
      return null;
    }
    paramComparable = new NullPointerException();
    throw paramComparable;
  }
  
  public abstract Set getValue();
  
  public final int hashCode()
  {
    return getValue().hashCode();
  }
  
  public boolean put()
  {
    return getValue().isEmpty();
  }
  
  public boolean put(Label paramLabel)
  {
    paramLabel = paramLabel.getValue().iterator();
    while (paramLabel.hasNext()) {
      if (!put((Range)paramLabel.next())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean put(Range paramRange)
  {
    Iterator localIterator = getValue().iterator();
    while (localIterator.hasNext()) {
      if (((Range)localIterator.next()).isEmpty(paramRange)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean put(Comparable paramComparable)
  {
    return get(paramComparable) != null;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    Iterator localIterator = getValue().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Range)localIterator.next());
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}
