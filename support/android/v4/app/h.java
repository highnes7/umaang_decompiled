package support.android.v4.app;

import android.os.Build.VERSION;
import b.b.a.F;
import b.b.a.N;
import b.b.a.t;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@N({b.b.a.N.a.b})
public final class h
{
  public static final String F = "en-XA";
  public static final Locale a;
  @t("sLock")
  public static h b = null;
  @t("sLock")
  public static h c = null;
  public static final Object d;
  @t("sLock")
  public static h e;
  public static final h g;
  @t("sLock")
  public static Locale i = null;
  public static final Locale m;
  public static final Locale[] o = new Locale[0];
  public static final int q = 2;
  public static final Locale s;
  public static final String t = "ar-XB";
  @F
  public final String f;
  public final Locale[] h;
  
  static
  {
    g = new h(new Locale[0]);
    m = new Locale("en", "XA");
    s = new Locale("ar", "XB");
    a = Format.getName("en-Latn");
    d = new Object();
    e = null;
  }
  
  public h(Locale paramLocale, h paramH)
  {
    if (paramLocale != null)
    {
      int i1 = 0;
      int k;
      if (paramH == null) {
        k = 0;
      } else {
        k = h.length;
      }
      int j = 0;
      while (j < k)
      {
        if (paramLocale.equals(h[j])) {
          break label61;
        }
        j += 1;
      }
      j = -1;
      label61:
      if (j == -1) {
        n = 1;
      } else {
        n = 0;
      }
      int i3 = n + k;
      Locale[] arrayOfLocale = new Locale[i3];
      arrayOfLocale[0] = ((Locale)paramLocale.clone());
      if (j == -1) {
        for (j = 0; j < k; j = n)
        {
          n = j + 1;
          arrayOfLocale[n] = ((Locale)h[j].clone());
        }
      }
      int i2;
      for (int n = 0; n < j; n = i2)
      {
        i2 = n + 1;
        arrayOfLocale[i2] = ((Locale)h[n].clone());
      }
      j += 1;
      while (j < k)
      {
        arrayOfLocale[j] = ((Locale)h[j].clone());
        j += 1;
      }
      paramLocale = new StringBuilder();
      j = i1;
      while (j < i3)
      {
        paramLocale.append(Format.getTitle(arrayOfLocale[j]));
        if (j < i3 - 1) {
          paramLocale.append(',');
        }
        j += 1;
      }
      h = arrayOfLocale;
      f = paramLocale.toString();
      return;
    }
    paramLocale = new NullPointerException("topLocale is null");
    throw paramLocale;
  }
  
  public h(Locale... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      h = o;
      f = "";
      return;
    }
    Locale[] arrayOfLocale = new Locale[paramVarArgs.length];
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    while (j < paramVarArgs.length)
    {
      Locale localLocale = paramVarArgs[j];
      if (localLocale != null)
      {
        if (!localHashSet.contains(localLocale))
        {
          localLocale = (Locale)localLocale.clone();
          arrayOfLocale[j] = localLocale;
          localStringBuilder.append(Format.getTitle(localLocale));
          if (j < paramVarArgs.length - 1) {
            localStringBuilder.append(',');
          }
          localHashSet.add(localLocale);
          j += 1;
        }
        else
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("list[", j, "] is a repetition"));
        }
      }
      else {
        throw new NullPointerException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("list[", j, "] is null"));
      }
    }
    h = arrayOfLocale;
    f = localStringBuilder.toString();
  }
  
  private int a(Collection paramCollection, boolean paramBoolean)
  {
    Locale[] arrayOfLocale = h;
    if (arrayOfLocale.length == 1) {
      return 0;
    }
    if (arrayOfLocale.length == 0) {
      return -1;
    }
    int k;
    int j;
    if (paramBoolean)
    {
      k = d(a);
      j = k;
      if (k == 0) {
        return 0;
      }
      if (k < Integer.MAX_VALUE) {}
    }
    else
    {
      j = Integer.MAX_VALUE;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      k = d(Format.getName((String)paramCollection.next()));
      if (k == 0) {
        return 0;
      }
      if (k < j) {
        j = k;
      }
    }
    if (j == Integer.MAX_VALUE) {
      return 0;
    }
    return j;
  }
  
  public static int a(Locale paramLocale1, Locale paramLocale2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static h a()
  {
    Object localObject2 = Locale.getDefault();
    Object localObject1 = d;
    try
    {
      if (!((Locale)localObject2).equals(i))
      {
        i = (Locale)localObject2;
        if ((b != null) && (((Locale)localObject2).equals(b.getTitle(0))))
        {
          localObject2 = b;
          return localObject2;
        }
        b = new h((Locale)localObject2, e);
        c = b;
      }
      localObject2 = b;
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static h a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.split(",", -1);
      Locale[] arrayOfLocale = new Locale[paramString.length];
      int j = 0;
      while (j < arrayOfLocale.length)
      {
        arrayOfLocale[j] = Format.getName(paramString[j]);
        j += 1;
      }
      return new h(arrayOfLocale);
    }
    return g;
  }
  
  public static void a(h paramH, int paramInt)
  {
    if (paramH != null)
    {
      if (!paramH.d())
      {
        Object localObject = d;
        try
        {
          i = paramH.getTitle(paramInt);
          Locale.setDefault(i);
          e = paramH;
          b = paramH;
          if (paramInt == 0) {
            c = b;
          } else {
            c = new h(i, b);
          }
          return;
        }
        catch (Throwable paramH)
        {
          throw paramH;
        }
      }
      throw new IllegalArgumentException("locales is empty");
    }
    throw new NullPointerException("locales is null");
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return true;
    }
    if (paramArrayOfString.length > 3) {
      return false;
    }
    int k = paramArrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = paramArrayOfString[j];
      if ((!str.isEmpty()) && (!c(str))) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public static h b()
  {
    return g;
  }
  
  public static boolean b(Locale paramLocale)
  {
    return (m.equals(paramLocale)) || (s.equals(paramLocale));
  }
  
  public static h c()
  {
    a();
    Object localObject = d;
    try
    {
      h localH = c;
      return localH;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static void c(h paramH)
  {
    a(paramH, 0);
  }
  
  public static boolean c(String paramString)
  {
    return ("en-XA".equals(paramString)) || ("ar-XB".equals(paramString));
  }
  
  private Locale create(Collection paramCollection, boolean paramBoolean)
  {
    int j = a(paramCollection, paramBoolean);
    if (j == -1) {
      return null;
    }
    return h[j];
  }
  
  private int d(Locale paramLocale)
  {
    int j = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = h;
      if (j >= arrayOfLocale.length) {
        break;
      }
      if (a(paramLocale, arrayOfLocale[j]) > 0) {
        return j;
      }
      j += 1;
    }
    return Integer.MAX_VALUE;
  }
  
  public static String getTitle(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLocale = paramLocale.getScript();
      if (!paramLocale.isEmpty()) {
        return paramLocale;
      }
    }
    return "";
  }
  
  public int a(Locale paramLocale)
  {
    int j = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = h;
      if (j >= arrayOfLocale.length) {
        break;
      }
      if (arrayOfLocale[j].equals(paramLocale)) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  public int c(Collection paramCollection)
  {
    return a(paramCollection, true);
  }
  
  public Locale create(String[] paramArrayOfString)
  {
    return create(Arrays.asList(paramArrayOfString), true);
  }
  
  public boolean d()
  {
    return h.length == 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof h)) {
      return false;
    }
    paramObject = h;
    if (h.length != paramObject.length) {
      return false;
    }
    int j = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = h;
      if (j >= arrayOfLocale.length) {
        break;
      }
      if (!arrayOfLocale[j].equals(paramObject[j])) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public String f()
  {
    return f;
  }
  
  public int g()
  {
    return h.length;
  }
  
  public int getItem(String[] paramArrayOfString)
  {
    return a(Arrays.asList(paramArrayOfString), false);
  }
  
  public Locale getTitle(int paramInt)
  {
    if (paramInt >= 0)
    {
      Locale[] arrayOfLocale = h;
      if (paramInt < arrayOfLocale.length) {
        return arrayOfLocale[paramInt];
      }
    }
    return null;
  }
  
  public int hashCode()
  {
    int k = 1;
    int j = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = h;
      if (j >= arrayOfLocale.length) {
        break;
      }
      k = k * 31 + arrayOfLocale[j].hashCode();
      j += 1;
    }
    return k;
  }
  
  public Locale read(String[] paramArrayOfString)
  {
    return create(Arrays.asList(paramArrayOfString), false);
  }
  
  public int setIcon(String[] paramArrayOfString)
  {
    return c(Arrays.asList(paramArrayOfString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[");
    int j = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = h;
      if (j >= arrayOfLocale.length) {
        break;
      }
      localStringBuilder.append(arrayOfLocale[j]);
      if (j < h.length - 1) {
        localStringBuilder.append(',');
      }
      j += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}
