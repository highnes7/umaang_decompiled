package l.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ClassWriter
  implements h<t>, p, t
{
  public final AtomicReference<Throwable> A = new AtomicReference(null);
  public final AtomicBoolean a = new AtomicBoolean(false);
  public final List<t> y = new ArrayList();
  
  public ClassWriter() {}
  
  public static boolean get(Object paramObject)
  {
    try
    {
      Type localType = (Type)paramObject;
      l localL = (l)paramObject;
      paramObject = (Segment)paramObject;
      if ((localType != null) && (localL != null) && (paramObject != null)) {
        return true;
      }
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public void a(Throwable paramThrowable)
  {
    A.set(paramThrowable);
  }
  
  public void a(l paramL)
  {
    try
    {
      y.add(paramL);
      return;
    }
    catch (Throwable paramL)
    {
      throw paramL;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a.set(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = get().iterator();
    while (localIterator.hasNext()) {
      if (!((l)localIterator.next()).b()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean b()
  {
    return a.get();
  }
  
  public int compareTo(Object paramObject)
  {
    return Request.Priority.compareTo(this, paramObject);
  }
  
  public Collection get()
  {
    try
    {
      Collection localCollection = Collections.unmodifiableCollection(y);
      return localCollection;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Throwable getError()
  {
    return (Throwable)A.get();
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.LOW;
  }
}
