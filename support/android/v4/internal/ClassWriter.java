package support.android.v4.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import b.b.a.K;
import b.b.a.N;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import support.android.v4.content.asm.x;
import support.android.v4.tts.Label;

@K(26)
@N({b.b.a.N.a.b})
public class ClassWriter
  extends f
{
  public static final String A = "createFromFamiliesWithDefault";
  public static final String DEFAULT_FONT_FAMILY = "sans-serif";
  public static final int FIELD = -1;
  public static final String INT = "abortCreation";
  public static final String e = "addFontFromAssetManager";
  public static final String i = "freeze";
  public static final String key = "addFontFromBuffer";
  public static final String t = "TypefaceCompatApi26Impl";
  public static final String threshold = "android.graphics.FontFamily";
  public final Method a;
  public final Method b;
  public final Constructor c;
  public final Method d;
  public final Method f;
  public final Method method;
  public final Class target;
  
  public ClassWriter()
  {
    Object localObject3 = null;
    try
    {
      Class localClass = get();
      localObject2 = getConstructor(localClass);
      localMethod1 = get(localClass);
      localMethod2 = find(localClass);
      localMethod3 = findAddRemoveListenerMethod(localClass);
      localMethod4 = getMethod(localClass);
      localMethod5 = newInstance(localClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Object localObject2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unable to collect necessary methods for class ");
    ((StringBuilder)localObject2).append(localClassNotFoundException.getClass().getName());
    ((StringBuilder)localObject2).toString();
    Method localMethod5 = null;
    localObject2 = null;
    Method localMethod1 = null;
    Method localMethod2 = null;
    Method localMethod3 = null;
    Method localMethod4 = null;
    Object localObject1 = localObject3;
    target = localObject1;
    c = ((Constructor)localObject2);
    d = localMethod1;
    a = localMethod2;
    f = localMethod3;
    b = localMethod4;
    method = localMethod5;
  }
  
  private Object a()
  {
    Object localObject = c;
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  private boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    Method localMethod = d;
    try
    {
      paramContext = paramContext.getAssets();
      paramContext = localMethod.invoke(paramObject, new Object[] { paramContext, paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis });
      paramContext = (Boolean)paramContext;
      boolean bool = paramContext.booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
    throw new RuntimeException(paramContext);
  }
  
  private boolean a(Object paramObject)
  {
    Method localMethod = f;
    try
    {
      paramObject = localMethod.invoke(paramObject, new Object[0]);
      paramObject = (Boolean)paramObject;
      boolean bool = paramObject.booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    Method localMethod = a;
    try
    {
      paramObject = localMethod.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      paramObject = (Boolean)paramObject;
      boolean bool = paramObject.booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private boolean c()
  {
    return d != null;
  }
  
  private void put(Object paramObject)
  {
    Method localMethod = b;
    try
    {
      localMethod.invoke(paramObject, new Object[0]);
      return;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!c()) {
      return super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = a();
    if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      put(paramResources);
      return null;
    }
    if (!a(paramResources)) {
      return null;
    }
    return get(paramResources);
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public Typeface a(Context paramContext, x paramX, Resources paramResources, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public Method find(Class paramClass)
    throws NoSuchMethodException
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, localClass, [Landroid.graphics.fonts.FontVariationAxis.class, localClass, localClass });
  }
  
  public Method findAddRemoveListenerMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
  
  public Typeface get(Object paramObject)
  {
    Object localObject = target;
    try
    {
      localObject = Array.newInstance((Class)localObject, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = method;
      paramObject = paramObject.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public Class get()
    throws ClassNotFoundException
  {
    return Class.forName("android.graphics.FontFamily");
  }
  
  public Method get(Class paramClass)
    throws NoSuchMethodException
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Boolean.TYPE;
    Class localClass3 = Integer.TYPE;
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, localClass1, localClass2, localClass3, localClass3, localClass3, [Landroid.graphics.fonts.FontVariationAxis.class });
  }
  
  public Constructor getConstructor(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getConstructor(new Class[0]);
  }
  
  public Method getMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }
  
  public Method newInstance(Class paramClass)
    throws NoSuchMethodException
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
}
