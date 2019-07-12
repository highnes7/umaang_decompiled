package f.l.a.b;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;

public final class ClassWriter
{
  public final int a;
  public final int b;
  public final int c;
  public final Drawable d;
  public final Drawable e;
  public final Drawable f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final f.l.a.b.a.d j;
  public final BitmapFactory.Options k;
  public final int l;
  public final boolean m;
  public final f.l.a.b.g.a n;
  public final f.l.a.b.g.a r;
  public final f.l.a.b.c.a t;
  public final boolean u;
  public final Handler w;
  public final Object x;
  
  public ClassWriter(d paramD)
  {
    a = a;
    b = b;
    c = q;
    d = d;
    e = e;
    f = f;
    g = g;
    h = h;
    i = i;
    j = j;
    k = k;
    l = l;
    m = m;
    x = x;
    n = n;
    r = c;
    t = p;
    w = s;
    u = u;
  }
  
  public static ClassWriter setTitle()
  {
    return new d().getString();
  }
  
  public Drawable a(Resources paramResources)
  {
    int i1 = a;
    if (i1 != 0) {
      return paramResources.getDrawable(i1);
    }
    return d;
  }
  
  public f.l.a.b.c.a a()
  {
    return t;
  }
  
  public Drawable b(Resources paramResources)
  {
    int i1 = b;
    if (i1 != 0) {
      return paramResources.getDrawable(i1);
    }
    return e;
  }
  
  public boolean b()
  {
    return u;
  }
  
  public boolean c()
  {
    return (d != null) || (a != 0);
  }
  
  public int d()
  {
    return l;
  }
  
  public boolean f()
  {
    return (f != null) || (c != 0);
  }
  
  public boolean get()
  {
    return m;
  }
  
  public f.l.a.b.g.a getCalculatedMaxX()
  {
    return r;
  }
  
  public Drawable getDrawable(Resources paramResources)
  {
    int i1 = c;
    if (i1 != 0) {
      return paramResources.getDrawable(i1);
    }
    return f;
  }
  
  public f.l.a.b.a.d getMinValue()
  {
    return j;
  }
  
  public boolean isDrawPaddingEnabled()
  {
    return i;
  }
  
  public f.l.a.b.g.a j()
  {
    return n;
  }
  
  public boolean m()
  {
    return r != null;
  }
  
  public boolean newUTF8()
  {
    return g;
  }
  
  public boolean onTick()
  {
    return l > 0;
  }
  
  public boolean put()
  {
    return (e != null) || (b != 0);
  }
  
  public BitmapFactory.Options toByteArray()
  {
    return k;
  }
  
  public boolean visit()
  {
    return n != null;
  }
  
  public boolean visitAnnotation()
  {
    return h;
  }
  
  public Handler visitAttribute()
  {
    return w;
  }
  
  public Object visitInnerClass()
  {
    return x;
  }
}
