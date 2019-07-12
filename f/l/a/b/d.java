package f.l.a.b;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import f.l.a.b.c.f;

public class d
{
  public int a = 0;
  public int b = 0;
  public f.l.a.b.g.a c = null;
  public Drawable d = null;
  public Drawable e = null;
  public Drawable f = null;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public f.l.a.b.a.d j = f.l.a.b.a.d.c;
  public BitmapFactory.Options k = new BitmapFactory.Options();
  public int l = 0;
  public boolean m = false;
  public f.l.a.b.g.a n = null;
  public f.l.a.b.c.a p = new f();
  public int q = 0;
  public Handler s = null;
  public boolean u = false;
  public Object x = null;
  
  public d() {}
  
  public d a()
  {
    g = true;
    return this;
  }
  
  public d a(int paramInt)
  {
    l = paramInt;
    return this;
  }
  
  public d a(BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null)
    {
      k = paramOptions;
      return this;
    }
    throw new IllegalArgumentException("decodingOptions can't be null");
  }
  
  public d a(Drawable paramDrawable)
  {
    e = paramDrawable;
    return this;
  }
  
  public d a(Handler paramHandler)
  {
    s = paramHandler;
    return this;
  }
  
  public d a(ClassWriter paramClassWriter)
  {
    a = a;
    b = b;
    q = c;
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
    c = r;
    p = t;
    s = w;
    u = u;
    return this;
  }
  
  public d a(f.l.a.b.a.d paramD)
  {
    j = paramD;
    return this;
  }
  
  public d a(f.l.a.b.c.a paramA)
  {
    if (paramA != null)
    {
      p = paramA;
      return this;
    }
    throw new IllegalArgumentException("displayer can't be null");
  }
  
  public d a(f.l.a.b.g.a paramA)
  {
    n = paramA;
    return this;
  }
  
  public d a(Object paramObject)
  {
    x = paramObject;
    return this;
  }
  
  public d a(boolean paramBoolean)
  {
    m = paramBoolean;
    return this;
  }
  
  public d add(int paramInt)
  {
    a = paramInt;
    return this;
  }
  
  public d b()
  {
    h = true;
    return this;
  }
  
  public d b(int paramInt)
  {
    a = paramInt;
    return this;
  }
  
  public d b(Drawable paramDrawable)
  {
    d = paramDrawable;
    return this;
  }
  
  public d b(f.l.a.b.g.a paramA)
  {
    c = paramA;
    return this;
  }
  
  public d b(boolean paramBoolean)
  {
    u = paramBoolean;
    return this;
  }
  
  public d c(Drawable paramDrawable)
  {
    f = paramDrawable;
    return this;
  }
  
  public d c(boolean paramBoolean)
  {
    g = paramBoolean;
    return this;
  }
  
  public d d()
  {
    return d(true);
  }
  
  public d d(int paramInt)
  {
    b = paramInt;
    return this;
  }
  
  public d d(boolean paramBoolean)
  {
    i = paramBoolean;
    return this;
  }
  
  public d get(Bitmap.Config paramConfig)
  {
    if (paramConfig != null)
    {
      k.inPreferredConfig = paramConfig;
      return this;
    }
    throw new IllegalArgumentException("bitmapConfig can't be null");
  }
  
  public ClassWriter getString()
  {
    return new ClassWriter(this);
  }
  
  public d getString(int paramInt)
  {
    q = paramInt;
    return this;
  }
  
  public d read(boolean paramBoolean)
  {
    return d(paramBoolean);
  }
  
  public d setId(boolean paramBoolean)
  {
    h = paramBoolean;
    return this;
  }
}
