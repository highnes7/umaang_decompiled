package f.l.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import f.l.a.b.a.e;
import f.l.a.c.L;
import f.l.a.c.g;

public class f
{
  public static final String ACTION_VIEW_STATES_KEY = "Load image from memory cache [%s]";
  public static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
  public static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
  public static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  public static final String EXPANDED_ACTION_VIEW_ID = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  public static final String LOG_DESTROY = "Destroy ImageLoader";
  public static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
  public static final String TAG = "f";
  public static volatile f o;
  public j b;
  public f.l.a.b.f.a c = new f.l.a.b.f.d();
  public i q;
  
  public f() {}
  
  public static Handler a(ClassWriter paramClassWriter)
  {
    Handler localHandler = paramClassWriter.visitAttribute();
    if (paramClassWriter.b()) {
      return null;
    }
    paramClassWriter = localHandler;
    if (localHandler == null)
    {
      paramClassWriter = localHandler;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        paramClassWriter = new Handler();
      }
    }
    return paramClassWriter;
  }
  
  public static f a()
  {
    if (o == null) {
      try
      {
        if (o == null) {
          o = new f();
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
    }
    return o;
  }
  
  private void clear()
  {
    if (q != null) {
      return;
    }
    throw new IllegalStateException("ImageLoader must be init with configuration before using");
  }
  
  public Bitmap a(String paramString, e paramE, ClassWriter paramClassWriter)
  {
    Object localObject = paramClassWriter;
    if (paramClassWriter == null) {
      localObject = q.b;
    }
    paramClassWriter = new d().a((ClassWriter)localObject).b(true).getString();
    localObject = new f.a(null);
    a(paramString, paramE, paramClassWriter, (f.l.a.b.f.a)localObject);
    return ((f.a)localObject).a();
  }
  
  public String a(ImageView paramImageView)
  {
    return b.b(new f.l.a.b.e.b(paramImageView));
  }
  
  public String a(f.l.a.b.e.a paramA)
  {
    return b.b(paramA);
  }
  
  public void a(f.l.a.b.f.a paramA)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a3 = a2\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public void a(String paramString, ImageView paramImageView, ClassWriter paramClassWriter)
  {
    a(paramString, new f.l.a.b.e.b(paramImageView), paramClassWriter, null, null);
  }
  
  public void a(String paramString, ImageView paramImageView, ClassWriter paramClassWriter, f.l.a.b.f.a paramA)
  {
    a(paramString, paramImageView, paramClassWriter, paramA, null);
  }
  
  public void a(String paramString, ImageView paramImageView, ClassWriter paramClassWriter, f.l.a.b.f.a paramA, f.l.a.b.f.b paramB)
  {
    a(paramString, new f.l.a.b.e.b(paramImageView), paramClassWriter, paramA, paramB);
  }
  
  public void a(String paramString, ImageView paramImageView, f.l.a.b.f.a paramA)
  {
    a(paramString, new f.l.a.b.e.b(paramImageView), null, paramA, null);
  }
  
  public void a(String paramString, ClassWriter paramClassWriter, f.l.a.b.f.a paramA)
  {
    a(paramString, null, paramClassWriter, paramA, null);
  }
  
  public void a(String paramString, e paramE, ClassWriter paramClassWriter, f.l.a.b.f.a paramA)
  {
    a(paramString, paramE, paramClassWriter, paramA, null);
  }
  
  public void a(String paramString, e paramE, ClassWriter paramClassWriter, f.l.a.b.f.a paramA, f.l.a.b.f.b paramB)
  {
    clear();
    e localE = paramE;
    if (paramE == null) {
      localE = q.a();
    }
    paramE = paramClassWriter;
    if (paramClassWriter == null) {
      paramE = q.b;
    }
    a(paramString, new f.l.a.b.e.c(paramString, localE, f.l.a.b.a.i.b), paramE, paramA, paramB);
  }
  
  public void a(String paramString, e paramE, f.l.a.b.f.a paramA)
  {
    a(paramString, paramE, null, paramA, null);
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA)
  {
    a(paramString, paramA, null, null, null);
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA, ClassWriter paramClassWriter)
  {
    a(paramString, paramA, paramClassWriter, null, null);
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA, ClassWriter paramClassWriter, e paramE, f.l.a.b.f.a paramA1, f.l.a.b.f.b paramB)
  {
    clear();
    if (paramA != null)
    {
      f.l.a.b.f.a localA = paramA1;
      if (paramA1 == null) {
        localA = c;
      }
      paramA1 = paramClassWriter;
      if (paramClassWriter == null) {
        paramA1 = q.b;
      }
      if (TextUtils.isEmpty(paramString))
      {
        b.a(paramA);
        localA.onLoadingStarted(paramString, paramA.a());
        if (paramA1.put()) {
          paramA.a(paramA1.b(q.j));
        } else {
          paramA.a(null);
        }
        localA.onLoadingComplete(paramString, paramA.a(), null);
        return;
      }
      paramClassWriter = paramE;
      if (paramE == null) {
        paramClassWriter = f.l.a.c.c.a(paramA, q.a());
      }
      String str = g.a(paramString, paramClassWriter);
      b.a(paramA, str);
      localA.onLoadingStarted(paramString, paramA.a());
      paramE = q.a.get(str);
      if ((paramE != null) && (!paramE.isRecycled()))
      {
        L.d("Load image from memory cache [%s]", new Object[] { str });
        if (paramA1.m())
        {
          paramString = new k(paramString, paramA, paramClassWriter, str, paramA1, localA, paramB, b.a(paramString));
          paramString = new p(b, paramE, paramString, a(paramA1));
          if (paramA1.b())
          {
            paramString.run();
            return;
          }
          b.a(paramString);
          return;
        }
        paramA1.a().a(paramE, paramA, f.l.a.b.a.f.c);
        localA.onLoadingComplete(paramString, paramA.a(), paramE);
        return;
      }
      if (paramA1.c()) {
        paramA.a(paramA1.a(q.j));
      } else if (paramA1.newUTF8()) {
        paramA.a(null);
      }
      paramString = new k(paramString, paramA, paramClassWriter, str, paramA1, localA, paramB, b.a(paramString));
      paramString = new o(b, paramString, a(paramA1));
      if (paramA1.b())
      {
        paramString.run();
        return;
      }
      b.a(paramString);
      return;
    }
    throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA, ClassWriter paramClassWriter, f.l.a.b.f.a paramA1)
  {
    a(paramString, paramA, paramClassWriter, paramA1, null);
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA, ClassWriter paramClassWriter, f.l.a.b.f.a paramA1, f.l.a.b.f.b paramB)
  {
    a(paramString, paramA, paramClassWriter, null, paramA1, paramB);
  }
  
  public void a(String paramString, f.l.a.b.e.a paramA, f.l.a.b.f.a paramA1)
  {
    a(paramString, paramA, null, paramA1, null);
  }
  
  public void a(String paramString, f.l.a.b.f.a paramA)
  {
    a(paramString, null, null, paramA, null);
  }
  
  public void a(boolean paramBoolean)
  {
    b.b(paramBoolean);
  }
  
  public void add()
  {
    clear();
    q.a.clear();
  }
  
  public Bitmap b(String paramString, ClassWriter paramClassWriter)
  {
    return a(paramString, null, paramClassWriter);
  }
  
  public void b()
  {
    clear();
    q.q.clear();
  }
  
  public Bitmap c(String paramString, e paramE)
  {
    return a(paramString, paramE, null);
  }
  
  public void c()
  {
    b.g();
  }
  
  public void c(String paramString, ImageView paramImageView)
  {
    a(paramString, new f.l.a.b.e.b(paramImageView), null, null, null);
  }
  
  public void c(String paramString, ImageView paramImageView, e paramE)
  {
    a(paramString, new f.l.a.b.e.b(paramImageView), null, paramE, null, null);
  }
  
  public Bitmap d(String paramString)
  {
    return a(paramString, null, null);
  }
  
  public void d()
  {
    if (q != null) {
      L.d("Destroy ImageLoader", new Object[0]);
    }
    c();
    q.q.close();
    b = null;
    q = null;
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    b.e();
  }
  
  public void f(ImageView paramImageView)
  {
    b.a(new f.l.a.b.e.b(paramImageView));
  }
  
  public void f(f.l.a.b.e.a paramA)
  {
    b.a(paramA);
  }
  
  public void f(boolean paramBoolean)
  {
    b.a(paramBoolean);
  }
  
  public void getItem()
  {
    b.f();
  }
  
  public f.l.a.a.a.a i()
  {
    return l();
  }
  
  public void init(i paramI)
  {
    if (paramI != null) {
      try
      {
        if (q == null)
        {
          L.d("Initialize ImageLoader with configuration", new Object[0]);
          b = new j(paramI);
          q = paramI;
        }
        else
        {
          L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
        return;
      }
      catch (Throwable paramI) {}
    }
    throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
    throw paramI;
  }
  
  public boolean j()
  {
    return q != null;
  }
  
  public f.l.a.a.b.c k()
  {
    clear();
    return q.a;
  }
  
  public f.l.a.a.a.a l()
  {
    clear();
    return q.q;
  }
}
