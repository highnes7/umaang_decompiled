package f.objectweb.asm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import b.b.a.G;
import b.b.a.m;
import b.b.a.n;
import support.android.v4.content.ContextCompat;

public class f
{
  public int A = 18;
  public float B = 0.54F;
  public Drawable a;
  public Integer b = null;
  @m
  public int c = -1;
  public int d = 44;
  public Rect e;
  public boolean f = true;
  @G
  public final CharSequence g;
  public Typeface h;
  @m
  public int i = -1;
  @m
  public int j = -1;
  public boolean k = false;
  @m
  public int l = -1;
  public int m = -1;
  @m
  public int n = -1;
  public Integer o = null;
  @n
  public int p = -1;
  public boolean q = true;
  public int r = 20;
  public Integer s = null;
  public Integer t = null;
  public final CharSequence u;
  public Integer v = null;
  public boolean w = false;
  @n
  public int x = -1;
  public float y = 0.96F;
  public Typeface z;
  
  public f(Rect paramRect, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this(paramCharSequence1, paramCharSequence2);
    if (paramRect != null)
    {
      e = paramRect;
      return;
    }
    throw new IllegalArgumentException("Cannot pass null bounds or title");
  }
  
  public f(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 != null)
    {
      u = paramCharSequence1;
      g = paramCharSequence2;
      return;
    }
    throw new IllegalArgumentException("Cannot pass null title");
  }
  
  private int a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt2 != -1) {
      return paramContext.getResources().getDimensionPixelSize(paramInt2);
    }
    return Label.b(paramContext, paramInt1);
  }
  
  public static f a(Rect paramRect, CharSequence paramCharSequence)
  {
    return new f(paramRect, paramCharSequence, null);
  }
  
  public static f a(android.support.v7.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence)
  {
    return new Type(paramToolbar, paramInt, paramCharSequence, null);
  }
  
  public static f a(android.support.v7.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, paramInt, paramCharSequence1, paramCharSequence2);
  }
  
  public static f a(android.support.v7.widget.Toolbar paramToolbar, CharSequence paramCharSequence)
  {
    return b(paramToolbar, paramCharSequence, null);
  }
  
  public static f a(android.support.v7.widget.Toolbar paramToolbar, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, true, paramCharSequence1, paramCharSequence2);
  }
  
  public static f a(View paramView, CharSequence paramCharSequence)
  {
    return new e(paramView, paramCharSequence, null);
  }
  
  public static f a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new e(paramView, paramCharSequence1, paramCharSequence2);
  }
  
  public static f a(android.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence)
  {
    return new Type(paramToolbar, paramInt, paramCharSequence, null);
  }
  
  public static f a(android.widget.Toolbar paramToolbar, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, paramInt, paramCharSequence1, paramCharSequence2);
  }
  
  public static f a(android.widget.Toolbar paramToolbar, CharSequence paramCharSequence)
  {
    return b(paramToolbar, paramCharSequence, null);
  }
  
  public static f a(android.widget.Toolbar paramToolbar, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, true, paramCharSequence1, paramCharSequence2);
  }
  
  private Integer a(Context paramContext, Integer paramInteger, int paramInt)
  {
    if (paramInt != -1) {
      paramInteger = Integer.valueOf(ContextCompat.getColor(paramContext, paramInt));
    }
    return paramInteger;
  }
  
  public static f b(android.support.v7.widget.Toolbar paramToolbar, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, false, paramCharSequence1, paramCharSequence2);
  }
  
  public static f b(android.widget.Toolbar paramToolbar, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new Type(paramToolbar, false, paramCharSequence1, paramCharSequence2);
  }
  
  public static f d(android.support.v7.widget.Toolbar paramToolbar, CharSequence paramCharSequence)
  {
    return a(paramToolbar, paramCharSequence, null);
  }
  
  public static f d(android.widget.Toolbar paramToolbar, CharSequence paramCharSequence)
  {
    return a(paramToolbar, paramCharSequence, null);
  }
  
  public static f f(Rect paramRect, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return new f(paramRect, paramCharSequence1, paramCharSequence2);
  }
  
  public f a(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      B = paramFloat;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Given an invalid alpha value: ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public f a(int paramInt)
  {
    t = Integer.valueOf(paramInt);
    b = Integer.valueOf(paramInt);
    return this;
  }
  
  public f a(Typeface paramTypeface)
  {
    if (paramTypeface != null)
    {
      z = paramTypeface;
      return this;
    }
    throw new IllegalArgumentException("Cannot use a null typeface");
  }
  
  public f a(Drawable paramDrawable)
  {
    return a(paramDrawable, false);
  }
  
  public f a(Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramDrawable != null)
    {
      a = paramDrawable;
      if (!paramBoolean)
      {
        paramDrawable = a;
        paramDrawable.setBounds(new Rect(0, 0, paramDrawable.getIntrinsicWidth(), a.getIntrinsicHeight()));
        return this;
      }
    }
    else
    {
      throw new IllegalArgumentException("Cannot use null drawable");
    }
    return this;
  }
  
  public f a(boolean paramBoolean)
  {
    k = paramBoolean;
    return this;
  }
  
  public Integer a(Context paramContext)
  {
    return a(paramContext, t, l);
  }
  
  public void a(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public int add(Context paramContext)
  {
    return a(paramContext, r, p);
  }
  
  public f add(int paramInt)
  {
    v = Integer.valueOf(paramInt);
    return this;
  }
  
  public f b(int paramInt)
  {
    if (paramInt >= 0)
    {
      r = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Given negative text size");
  }
  
  public f b(Typeface paramTypeface)
  {
    if (paramTypeface != null)
    {
      h = paramTypeface;
      z = paramTypeface;
      return this;
    }
    throw new IllegalArgumentException("Cannot use a null typeface");
  }
  
  public f b(boolean paramBoolean)
  {
    w = paramBoolean;
    return this;
  }
  
  public Integer b(Context paramContext)
  {
    return a(paramContext, v, i);
  }
  
  public f c(int paramInt)
  {
    j = paramInt;
    return this;
  }
  
  public Integer c(Context paramContext)
  {
    return a(paramContext, s, c);
  }
  
  public f clear(int paramInt)
  {
    p = paramInt;
    return this;
  }
  
  public Integer clear(Context paramContext)
  {
    return a(paramContext, b, n);
  }
  
  public f close(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      y = paramFloat;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Given an invalid alpha value: ");
    localStringBuilder.append(paramFloat);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public f close(int paramInt)
  {
    t = Integer.valueOf(paramInt);
    return this;
  }
  
  public int d(Context paramContext)
  {
    return a(paramContext, A, x);
  }
  
  public f d(int paramInt)
  {
    i = paramInt;
    return this;
  }
  
  public f e(int paramInt)
  {
    m = paramInt;
    return this;
  }
  
  public f e(boolean paramBoolean)
  {
    q = paramBoolean;
    return this;
  }
  
  public Integer e(Context paramContext)
  {
    return a(paramContext, o, j);
  }
  
  public f f(int paramInt)
  {
    x = paramInt;
    return this;
  }
  
  public f f(Typeface paramTypeface)
  {
    if (paramTypeface != null)
    {
      h = paramTypeface;
      return this;
    }
    throw new IllegalArgumentException("Cannot use a null typeface");
  }
  
  public f f(boolean paramBoolean)
  {
    f = paramBoolean;
    return this;
  }
  
  public f g(int paramInt)
  {
    l = paramInt;
    n = paramInt;
    return this;
  }
  
  public Rect getItem()
  {
    Rect localRect = e;
    if (localRect != null) {
      return localRect;
    }
    throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
  }
  
  public f i(int paramInt)
  {
    o = Integer.valueOf(paramInt);
    return this;
  }
  
  public f init(int paramInt)
  {
    if (paramInt >= 0)
    {
      A = paramInt;
      return this;
    }
    throw new IllegalArgumentException("Given negative text size");
  }
  
  public int l()
  {
    return m;
  }
  
  public f p(int paramInt)
  {
    n = paramInt;
    return this;
  }
  
  public f putLong(int paramInt)
  {
    b = Integer.valueOf(paramInt);
    return this;
  }
  
  public f setDefaultShowAsAction(int paramInt)
  {
    d = paramInt;
    return this;
  }
  
  public f setHeaderIconInt(int paramInt)
  {
    l = paramInt;
    return this;
  }
  
  public f setHeaderTitleInt(int paramInt)
  {
    c = paramInt;
    return this;
  }
  
  public f setValue(int paramInt)
  {
    s = Integer.valueOf(paramInt);
    return this;
  }
}
