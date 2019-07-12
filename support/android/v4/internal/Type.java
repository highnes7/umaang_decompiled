package support.android.v4.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import b.b.a.N;
import b.b.x.n.m;
import support.android.v4.content.asm.h;
import support.android.v4.content.asm.x;
import support.android.v4.tts.Frame;
import support.android.v4.util.LruCache;

@N({b.b.a.N.a.b})
public class Type
{
  public static final String A = "TypefaceCompat";
  public static final d a;
  public static final m<String, Typeface> c = new LruCache(16);
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      a = new NDCPatternConverter();
    } else if (i >= 26) {
      a = new ClassWriter();
    } else if ((i >= 24) && (c.b())) {
      a = new c();
    } else if (Build.VERSION.SDK_INT >= 21) {
      a = new f();
    } else {
      a = new d();
    }
  }
  
  public Type() {}
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = create(paramResources, paramInt1, paramInt2);
      c.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, support.android.v4.tts.Label[] paramArrayOfLabel, int paramInt)
  {
    return a.a(paramContext, paramCancellationSignal, paramArrayOfLabel, paramInt);
  }
  
  public static Typeface a(Context paramContext, support.android.v4.content.asm.Object paramObject, Resources paramResources, int paramInt1, int paramInt2, support.android.v4.content.asm.Label paramLabel, Handler paramHandler, boolean paramBoolean)
  {
    if ((paramObject instanceof h))
    {
      paramObject = (h)paramObject;
      boolean bool = false;
      if (paramBoolean ? paramObject.l() == 0 : paramLabel == null) {
        bool = true;
      }
      int i;
      if (paramBoolean) {
        i = paramObject.c();
      } else {
        i = -1;
      }
      paramObject = Frame.a(paramContext, paramObject.a(), paramLabel, paramHandler, bool, i, paramInt2);
    }
    else
    {
      Typeface localTypeface = a.a(paramContext, (x)paramObject, paramResources, paramInt2);
      paramContext = localTypeface;
      paramObject = paramContext;
      if (paramLabel != null) {
        if (localTypeface != null)
        {
          paramLabel.callbackSuccessAsync(localTypeface, paramHandler);
          paramObject = paramContext;
        }
        else
        {
          paramLabel.callbackFailAsync(-3, paramHandler);
          paramObject = paramContext;
        }
      }
    }
    if (paramObject != null) {
      c.put(create(paramResources, paramInt1, paramInt2), paramObject);
    }
    return paramObject;
  }
  
  public static String create(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static Typeface get(Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)c.get(create(paramResources, paramInt1, paramInt2));
  }
}
