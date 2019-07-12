package f.objectweb.asm;

import android.app.Activity;
import android.app.Dialog;
import b.b.a.G;
import f.e.a.g;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class h
{
  public boolean G;
  @G
  public final Activity a;
  public final d b = new MethodWriter(this);
  @G
  public PagerSlidingTabStrip c;
  public boolean f;
  public l g;
  @G
  public final Dialog p;
  public final Queue<g> q;
  public boolean s;
  
  public h(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      a = paramActivity;
      p = null;
      q = new LinkedList();
      return;
    }
    throw new IllegalArgumentException("Activity is null");
  }
  
  public h(Dialog paramDialog)
  {
    if (paramDialog != null)
    {
      p = paramDialog;
      a = null;
      q = new LinkedList();
      return;
    }
    throw new IllegalArgumentException("Given null Dialog");
  }
  
  public h a(f paramF)
  {
    q.add(paramF);
    return this;
  }
  
  public h a(l paramL)
  {
    g = paramL;
    return this;
  }
  
  public h a(List paramList)
  {
    q.addAll(paramList);
    return this;
  }
  
  public h a(boolean paramBoolean)
  {
    f = paramBoolean;
    return this;
  }
  
  public h a(f... paramVarArgs)
  {
    Collections.addAll(q, paramVarArgs);
    return this;
  }
  
  public void a()
  {
    Object localObject1 = q;
    try
    {
      localObject1 = ((Queue)localObject1).remove();
      localObject1 = (f)localObject1;
      if (a != null)
      {
        localObject2 = a;
        localD = b;
        localObject1 = PagerSlidingTabStrip.a((Activity)localObject2, (f)localObject1, localD);
        c = ((PagerSlidingTabStrip)localObject1);
        return;
      }
      Object localObject2 = p;
      d localD = b;
      localObject1 = PagerSlidingTabStrip.a((Dialog)localObject2, (f)localObject1, localD);
      c = ((PagerSlidingTabStrip)localObject1);
      return;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      for (;;) {}
    }
    localObject1 = g;
    if (localObject1 != null)
    {
      ((l)localObject1).a();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (s) {
      return;
    }
    while ((q.peek() != null) && (((f)q.peek()).l() != paramInt)) {
      q.poll();
    }
    Object localObject = (f)q.peek();
    if ((localObject != null) && (((f)localObject).l() == paramInt))
    {
      c();
      return;
    }
    localObject = new IllegalStateException(StringBuilder.toString("Given target ", paramInt, " not in sequence"));
    throw ((Throwable)localObject);
  }
  
  public boolean b()
  {
    if (!q.isEmpty())
    {
      if (!s) {
        return false;
      }
      Object localObject = c;
      if (localObject != null)
      {
        if (!u) {
          return false;
        }
        ((PagerSlidingTabStrip)localObject).show(false);
        s = false;
        q.clear();
        localObject = g;
        if (localObject != null) {
          ((l)localObject).a(c.b);
        }
        return true;
      }
    }
    return false;
  }
  
  public h c(boolean paramBoolean)
  {
    G = paramBoolean;
    return this;
  }
  
  public void c()
  {
    if (!q.isEmpty())
    {
      if (s) {
        return;
      }
      s = true;
      a();
    }
  }
  
  public void parse(int paramInt)
  {
    if (s) {
      return;
    }
    if ((paramInt >= 0) && (paramInt < q.size()))
    {
      int i = q.size() - paramInt;
      while ((q.peek() != null) && (q.size() != i)) {
        q.poll();
      }
      if (q.size() == i)
      {
        c();
        return;
      }
      throw new IllegalStateException(StringBuilder.toString("Given index ", paramInt, " not in sequence"));
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(StringBuilder.toString("Given invalid index ", paramInt));
    throw localIllegalArgumentException;
  }
}
