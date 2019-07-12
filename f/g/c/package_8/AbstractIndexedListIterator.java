package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.uh;
import f.g.c.package_10.Preconditions;
import java.util.NoSuchElementException;

@b
public abstract class AbstractIndexedListIterator<E>
  extends uh<E>
{
  public int position;
  public final int size;
  
  public AbstractIndexedListIterator(int paramInt)
  {
    Preconditions.checkPositionIndex(0, paramInt, "index");
    size = paramInt;
    position = 0;
  }
  
  public AbstractIndexedListIterator(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndex(paramInt2, paramInt1, "index");
    size = paramInt1;
    position = paramInt2;
  }
  
  public abstract Object get(int paramInt);
  
  public final boolean hasNext()
  {
    return position < size;
  }
  
  public final boolean hasPrevious()
  {
    return position > 0;
  }
  
  public final Object next()
  {
    if (hasNext())
    {
      int i = position;
      position = (i + 1);
      return get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int nextIndex()
  {
    return position;
  }
  
  public final Object previous()
  {
    if (hasPrevious())
    {
      int i = position - 1;
      position = i;
      return get(i);
    }
    throw new NoSuchElementException();
  }
  
  public final int previousIndex()
  {
    return position - 1;
  }
}
