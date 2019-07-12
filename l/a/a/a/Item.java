package l.a.a.a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import l.a.a.a.a.c.Function;
import l.a.a.a.a.c.Label;
import l.a.a.a.a.c.j;

public abstract class Item<Result>
  implements Comparable<n>
{
  public k<Result> a;
  public m<Result> b = new ClassWriter(this);
  public l.a.a.a.a.b.f c;
  public f d;
  public final Function g = (Function)getClass().getAnnotation(j.class);
  public Context i;
  
  public Item() {}
  
  public void a(Context paramContext, f paramF, g paramG, l.a.a.a.a.b.f paramF1)
  {
    d = paramF;
    i = new MyApplication(paramContext, getId(), getString());
    a = paramG;
    c = paramF1;
  }
  
  public void a(Object paramObject) {}
  
  public abstract String c();
  
  public int compareTo(Item paramItem)
  {
    if (get(paramItem)) {
      return 1;
    }
    if (paramItem.get(this)) {
      return -1;
    }
    if ((get()) && (!paramItem.get())) {
      return 1;
    }
    if ((!get()) && (paramItem.get())) {
      return -1;
    }
    return 0;
  }
  
  public f e()
  {
    return d;
  }
  
  public boolean get()
  {
    return g != null;
  }
  
  public boolean get(Item paramItem)
  {
    if (get())
    {
      Class[] arrayOfClass = g.value();
      int k = arrayOfClass.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfClass[j].isAssignableFrom(paramItem.getClass())) {
          return true;
        }
        j += 1;
      }
    }
    return false;
  }
  
  public Context getContext()
  {
    return i;
  }
  
  public abstract String getId();
  
  public Collection getLabels()
  {
    return b.get();
  }
  
  public l.a.a.a.a.b.f getName()
  {
    return c;
  }
  
  public String getString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(".Fabric");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(getId());
    return localStringBuilder.toString();
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public void post(Object paramObject) {}
  
  public abstract Object run();
  
  public final void setTitle()
  {
    b.a(d.b(), new Void[] { null });
  }
}
