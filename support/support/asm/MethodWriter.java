package support.support.asm;

import b.a.a.b.a;
import b.a.b.h.b;
import b.a.b.i;
import b.a.b.j;
import b.a.b.l.a;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import support.support.v7.util.CopyOnWriteArrayList;
import support.support.v7.util.LinkedListMultimap;
import support.support.v7.util.RefMap.SetIterator;

public class MethodWriter
  extends ClassReader
{
  public static final String descriptor = "LifecycleRegistry";
  public final WeakReference<j> a;
  public a<i, l.a> b = new CopyOnWriteArrayList();
  public ArrayList<h.b> c = new ArrayList();
  public boolean d = false;
  public int f = 0;
  public boolean i = false;
  public f j;
  
  public MethodWriter(d paramD)
  {
    a = new WeakReference(paramD);
    j = f.b;
  }
  
  public static f a(c paramC)
  {
    int k = paramC.ordinal();
    if (k != 0)
    {
      if (k != 1) {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4) {
              break label60;
            }
            if (k == 5) {
              return f.c;
            }
            throw new IllegalArgumentException(StringBuilder.toString("Unexpected event value ", paramC));
          }
        }
        else {
          return f.y;
        }
      }
      return f.g;
    }
    label60:
    return f.d;
  }
  
  public static f a(f paramF1, f paramF2)
  {
    if ((paramF2 != null) && (paramF2.compareTo(paramF1) < 0)) {
      return paramF2;
    }
    return paramF1;
  }
  
  private void a(d paramD)
  {
    RefMap.SetIterator localSetIterator = b.put();
    while ((localSetIterator.hasNext()) && (!d))
    {
      Map.Entry localEntry = (Map.Entry)localSetIterator.next();
      e localE = (e)localEntry.getValue();
      while ((a.compareTo(j) < 0) && (!d) && (b.contains(localEntry.getKey())))
      {
        f localF = a;
        c.add(localF);
        localE.a(paramD, b(a));
        c();
      }
    }
  }
  
  private void accept()
  {
    d localD = (d)a.get();
    if (localD == null) {
      return;
    }
    while (!b())
    {
      d = false;
      if (j.compareTo(b.get().getValue()).a) < 0) {
        b(localD);
      }
      Map.Entry localEntry = b.values();
      if ((!d) && (localEntry != null) && (j.compareTo(getValuea) > 0)) {
        a(localD);
      }
    }
    d = false;
  }
  
  public static c b(f paramF)
  {
    int k = paramF.ordinal();
    if ((k != 0) && (k != 1))
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4) {
            throw new IllegalArgumentException(StringBuilder.toString("Unexpected state value ", paramF));
          }
          throw new IllegalArgumentException();
        }
        return c.ON_RESUME;
      }
      return c.ON_START;
    }
    return c.ON_CREATE;
  }
  
  private f b(MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor = b.get(paramMethodVisitor);
    Object localObject = null;
    if (paramMethodVisitor != null) {
      paramMethodVisitor = getValuea;
    } else {
      paramMethodVisitor = null;
    }
    if (!c.isEmpty())
    {
      localObject = c;
      localObject = (f)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return a(a(j, paramMethodVisitor), (f)localObject);
  }
  
  private void b(d paramD)
  {
    Iterator localIterator = b.descendingIterator();
    while ((localIterator.hasNext()) && (!d))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      e localE = (e)localEntry.getValue();
      while ((a.compareTo(j) > 0) && (!d) && (b.contains(localEntry.getKey())))
      {
        c localC = c(a);
        f localF = a(localC);
        c.add(localF);
        localE.a(paramD, localC);
        c();
      }
    }
  }
  
  private boolean b()
  {
    if (b.size() == 0) {
      return true;
    }
    f localF1 = b.get().getValue()).a;
    f localF2 = b.values().getValue()).a;
    return (localF1 == localF2) && (j == localF2);
  }
  
  public static c c(f paramF)
  {
    int k = paramF.ordinal();
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 3)
          {
            if (k == 4) {
              return c.ON_PAUSE;
            }
            throw new IllegalArgumentException(StringBuilder.toString("Unexpected state value ", paramF));
          }
          return c.ON_STOP;
        }
        return c.ON_DESTROY;
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  private void c()
  {
    ArrayList localArrayList = c;
    localArrayList.remove(localArrayList.size() - 1);
  }
  
  private void d(f paramF)
  {
    if (j == paramF) {
      return;
    }
    j = paramF;
    if ((!i) && (f == 0))
    {
      i = true;
      accept();
      i = false;
      return;
    }
    d = true;
  }
  
  private void visitLabel(f paramF)
  {
    c.add(paramF);
  }
  
  public f a()
  {
    return j;
  }
  
  public void a(MethodVisitor paramMethodVisitor)
  {
    Object localObject = j;
    f localF = f.c;
    if (localObject != localF) {
      localF = f.b;
    }
    localObject = new e(paramMethodVisitor, localF);
    if ((e)b.remove(paramMethodVisitor, localObject) != null) {
      return;
    }
    d localD = (d)a.get();
    if (localD == null) {
      return;
    }
    int k;
    if ((f == 0) && (!i)) {
      k = 0;
    } else {
      k = 1;
    }
    localF = b(paramMethodVisitor);
    f += 1;
    while ((a.compareTo(localF) < 0) && (b.contains(paramMethodVisitor)))
    {
      localF = a;
      c.add(localF);
      ((e)localObject).a(localD, b(a));
      c();
      localF = b(paramMethodVisitor);
    }
    if (k == 0) {
      accept();
    }
    f -= 1;
  }
  
  public void a(f paramF)
  {
    d(paramF);
  }
  
  public void append(c paramC)
  {
    d(a(paramC));
  }
  
  public void d(MethodVisitor paramMethodVisitor)
  {
    b.remove(paramMethodVisitor);
  }
  
  public int getSize()
  {
    return b.size();
  }
}
