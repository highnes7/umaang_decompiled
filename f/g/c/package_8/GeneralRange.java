package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.eb;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import m.a.h;

@b(serializable=true)
public final class GeneralRange<T>
  implements Serializable
{
  public final Comparator<? super T> comparator;
  public final boolean hasLowerBound;
  public final boolean hasUpperBound;
  public final BoundType lowerBoundType;
  @h
  public final T lowerEndpoint;
  public transient eb<T> reverse;
  public final BoundType upperBoundType;
  @h
  public final T upperEndpoint;
  
  public GeneralRange(Comparator paramComparator, boolean paramBoolean1, Object paramObject1, BoundType paramBoundType1, boolean paramBoolean2, Object paramObject2, BoundType paramBoundType2)
  {
    if (paramComparator != null)
    {
      comparator = paramComparator;
      hasLowerBound = paramBoolean1;
      hasUpperBound = paramBoolean2;
      lowerEndpoint = paramObject1;
      if (paramBoundType1 != null)
      {
        lowerBoundType = paramBoundType1;
        upperEndpoint = paramObject2;
        if (paramBoundType2 != null)
        {
          upperBoundType = paramBoundType2;
          if (paramBoolean1) {
            paramComparator.compare(paramObject1, paramObject1);
          }
          if (paramBoolean2) {
            paramComparator.compare(paramObject2, paramObject2);
          }
          if ((paramBoolean1) && (paramBoolean2))
          {
            int i = paramComparator.compare(paramObject1, paramObject2);
            int j = 1;
            if (i <= 0) {
              paramBoolean1 = true;
            } else {
              paramBoolean1 = false;
            }
            Preconditions.checkArgument(paramBoolean1, "lowerEndpoint (%s) > upperEndpoint (%s)", new Object[] { paramObject1, paramObject2 });
            if (i == 0)
            {
              if (paramBoundType1 != BoundType.OPEN) {
                i = 1;
              } else {
                i = 0;
              }
              if (paramBoundType2 == BoundType.OPEN) {
                j = 0;
              }
              Preconditions.checkArgument(i | j);
            }
          }
        }
        else
        {
          throw new NullPointerException();
        }
      }
      else
      {
        throw new NullPointerException();
      }
    }
    else
    {
      throw new NullPointerException();
    }
  }
  
  public static GeneralRange all(Comparator paramComparator)
  {
    BoundType localBoundType = BoundType.OPEN;
    return new GeneralRange(paramComparator, false, null, localBoundType, false, null, localBoundType);
  }
  
  public static GeneralRange downTo(Comparator paramComparator, Object paramObject, BoundType paramBoundType)
  {
    return new GeneralRange(paramComparator, true, paramObject, paramBoundType, false, null, BoundType.OPEN);
  }
  
  public static GeneralRange from(Range paramRange)
  {
    boolean bool = paramRange.hasLowerBound();
    Comparable localComparable2 = null;
    Comparable localComparable1;
    if (bool) {
      localComparable1 = paramRange.lowerEndpoint();
    } else {
      localComparable1 = null;
    }
    BoundType localBoundType1;
    if (paramRange.hasLowerBound()) {
      localBoundType1 = paramRange.lowerBoundType();
    } else {
      localBoundType1 = BoundType.OPEN;
    }
    if (paramRange.hasUpperBound()) {
      localComparable2 = paramRange.upperEndpoint();
    }
    BoundType localBoundType2;
    if (paramRange.hasUpperBound()) {
      localBoundType2 = paramRange.upperBoundType();
    } else {
      localBoundType2 = BoundType.OPEN;
    }
    return new GeneralRange(Ordering.natural(), paramRange.hasLowerBound(), localComparable1, localBoundType1, paramRange.hasUpperBound(), localComparable2, localBoundType2);
  }
  
  public static GeneralRange range(Comparator paramComparator, Object paramObject1, BoundType paramBoundType1, Object paramObject2, BoundType paramBoundType2)
  {
    return new GeneralRange(paramComparator, true, paramObject1, paramBoundType1, true, paramObject2, paramBoundType2);
  }
  
  public static GeneralRange upTo(Comparator paramComparator, Object paramObject, BoundType paramBoundType)
  {
    return new GeneralRange(paramComparator, false, null, BoundType.OPEN, true, paramObject, paramBoundType);
  }
  
  public Comparator comparator()
  {
    return comparator;
  }
  
  public boolean contains(Object paramObject)
  {
    return (!tooLow(paramObject)) && (!tooHigh(paramObject));
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GeneralRange))
    {
      paramObject = (GeneralRange)paramObject;
      if ((comparator.equals(comparator)) && (hasLowerBound == hasLowerBound) && (hasUpperBound == hasUpperBound) && (getLowerBoundType().equals(paramObject.getLowerBoundType())) && (getUpperBoundType().equals(paramObject.getUpperBoundType())) && (Objects.equal(getLowerEndpoint(), paramObject.getLowerEndpoint())) && (Objects.equal(getUpperEndpoint(), paramObject.getUpperEndpoint()))) {
        return true;
      }
    }
    return false;
  }
  
  public BoundType getLowerBoundType()
  {
    return lowerBoundType;
  }
  
  public Object getLowerEndpoint()
  {
    return lowerEndpoint;
  }
  
  public BoundType getUpperBoundType()
  {
    return upperBoundType;
  }
  
  public Object getUpperEndpoint()
  {
    return upperEndpoint;
  }
  
  public boolean hasLowerBound()
  {
    return hasLowerBound;
  }
  
  public boolean hasUpperBound()
  {
    return hasUpperBound;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType() });
  }
  
  public GeneralRange intersect(GeneralRange paramGeneralRange)
  {
    if (paramGeneralRange != null)
    {
      Preconditions.checkArgument(comparator.equals(comparator));
      boolean bool2 = hasLowerBound;
      Object localObject3 = getLowerEndpoint();
      Object localObject4 = getLowerBoundType();
      boolean bool1;
      Object localObject1;
      Object localObject2;
      int i;
      if (!hasLowerBound())
      {
        bool1 = hasLowerBound;
        localObject1 = paramGeneralRange.getLowerEndpoint();
        localObject2 = paramGeneralRange.getLowerBoundType();
      }
      else
      {
        bool1 = bool2;
        localObject1 = localObject3;
        localObject2 = localObject4;
        if (paramGeneralRange.hasLowerBound())
        {
          i = comparator.compare(getLowerEndpoint(), paramGeneralRange.getLowerEndpoint());
          if (i >= 0)
          {
            bool1 = bool2;
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (i == 0)
            {
              bool1 = bool2;
              localObject1 = localObject3;
              localObject2 = localObject4;
              if (paramGeneralRange.getLowerBoundType() != BoundType.OPEN) {}
            }
          }
          else
          {
            localObject1 = paramGeneralRange.getLowerEndpoint();
            localObject2 = paramGeneralRange.getLowerBoundType();
            bool1 = bool2;
          }
        }
      }
      boolean bool3 = hasUpperBound;
      Object localObject5 = getUpperEndpoint();
      Object localObject6 = getUpperBoundType();
      if (!hasUpperBound())
      {
        bool2 = hasUpperBound;
        localObject3 = paramGeneralRange.getUpperEndpoint();
        localObject4 = paramGeneralRange.getUpperBoundType();
      }
      else
      {
        bool2 = bool3;
        localObject3 = localObject5;
        localObject4 = localObject6;
        if (paramGeneralRange.hasUpperBound())
        {
          i = comparator.compare(getUpperEndpoint(), paramGeneralRange.getUpperEndpoint());
          if (i <= 0)
          {
            bool2 = bool3;
            localObject3 = localObject5;
            localObject4 = localObject6;
            if (i == 0)
            {
              bool2 = bool3;
              localObject3 = localObject5;
              localObject4 = localObject6;
              if (paramGeneralRange.getUpperBoundType() != BoundType.OPEN) {}
            }
          }
          else
          {
            localObject3 = paramGeneralRange.getUpperEndpoint();
            localObject4 = paramGeneralRange.getUpperBoundType();
            bool2 = bool3;
          }
        }
      }
      paramGeneralRange = localObject1;
      localObject5 = localObject2;
      localObject6 = localObject4;
      if (bool1)
      {
        paramGeneralRange = localObject1;
        localObject5 = localObject2;
        localObject6 = localObject4;
        if (bool2)
        {
          i = comparator.compare(localObject1, localObject3);
          if (i <= 0)
          {
            paramGeneralRange = localObject1;
            localObject5 = localObject2;
            localObject6 = localObject4;
            if (i == 0)
            {
              BoundType localBoundType = BoundType.OPEN;
              paramGeneralRange = localObject1;
              localObject5 = localObject2;
              localObject6 = localObject4;
              if (localObject2 == localBoundType)
              {
                paramGeneralRange = localObject1;
                localObject5 = localObject2;
                localObject6 = localObject4;
                if (localObject4 != localBoundType) {}
              }
            }
          }
          else
          {
            localObject5 = BoundType.OPEN;
            localObject6 = BoundType.CLOSED;
            paramGeneralRange = localObject3;
          }
        }
      }
      return new GeneralRange(comparator, bool1, paramGeneralRange, (BoundType)localObject5, bool2, localObject3, (BoundType)localObject6);
    }
    throw new NullPointerException();
  }
  
  public boolean isEmpty()
  {
    return ((hasUpperBound()) && (tooLow(getUpperEndpoint()))) || ((hasLowerBound()) && (tooHigh(getLowerEndpoint())));
  }
  
  public GeneralRange reverse()
  {
    GeneralRange localGeneralRange2 = reverse;
    GeneralRange localGeneralRange1 = localGeneralRange2;
    if (localGeneralRange2 == null)
    {
      localGeneralRange1 = new GeneralRange(Ordering.from(comparator).reverse(), hasUpperBound, getUpperEndpoint(), getUpperBoundType(), hasLowerBound, getLowerEndpoint(), getLowerBoundType());
      reverse = this;
      reverse = localGeneralRange1;
    }
    return localGeneralRange1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(comparator);
    localStringBuilder.append(":");
    int i = getLowerBoundType().ordinal();
    if (i != 0)
    {
      if (i == 1) {
        localStringBuilder.append('[');
      }
    }
    else {
      localStringBuilder.append('(');
    }
    if (hasLowerBound()) {
      localStringBuilder.append(getLowerEndpoint());
    } else {
      localStringBuilder.append("-?");
    }
    localStringBuilder.append(',');
    if (hasUpperBound()) {
      localStringBuilder.append(getUpperEndpoint());
    } else {
      localStringBuilder.append("?");
    }
    i = getUpperBoundType().ordinal();
    if (i != 0)
    {
      if (i == 1) {
        localStringBuilder.append(']');
      }
    }
    else {
      localStringBuilder.append(')');
    }
    return localStringBuilder.toString();
  }
  
  public boolean tooHigh(Object paramObject)
  {
    if (!hasUpperBound()) {
      return false;
    }
    Object localObject = getUpperEndpoint();
    int j = comparator.compare(paramObject, localObject);
    int k = 1;
    int i;
    if (j > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (j == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (getUpperBoundType() != BoundType.OPEN) {
      k = 0;
    }
    return j & k | i;
  }
  
  public boolean tooLow(Object paramObject)
  {
    if (!hasLowerBound()) {
      return false;
    }
    Object localObject = getLowerEndpoint();
    int j = comparator.compare(paramObject, localObject);
    int k = 1;
    int i;
    if (j < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (j == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (getLowerBoundType() != BoundType.OPEN) {
      k = 0;
    }
    return j & k | i;
  }
}
