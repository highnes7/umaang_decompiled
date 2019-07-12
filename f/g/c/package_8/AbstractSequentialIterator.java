package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.th;
import java.util.NoSuchElementException;

@b
public abstract class AbstractSequentialIterator<T>
  extends th<T>
{
  public T nextOrNull;
  
  public AbstractSequentialIterator(Object paramObject)
  {
    nextOrNull = paramObject;
  }
  
  public abstract Object computeNext(Object paramObject);
  
  public final boolean hasNext()
  {
    return nextOrNull != null;
  }
  
  public final Object next()
  {
    if (hasNext()) {
      try
      {
        Object localObject = nextOrNull;
        nextOrNull = computeNext(nextOrNull);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        nextOrNull = computeNext(nextOrNull);
        throw localThrowable;
      }
    }
    throw new NoSuchElementException();
  }
}
