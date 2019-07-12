package support.android.v4.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import b.b.a.K;
import b.b.a.N;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import support.android.v4.content.asm.f;
import support.android.v4.content.asm.x;
import support.android.v4.tts.Label;
import support.android.v4.util.SimpleArrayMap;

@K(24)
@N({b.b.a.N.a.b})
public class c
  extends d
{
  public static final Constructor RegionParamsConstructor;
  public static final Method a;
  public static final Class c;
  public static final Method d;
  public static final String e = "TypefaceCompatApi24Impl";
  public static final String f = "createFromFamiliesWithDefault";
  public static final String h = "android.graphics.FontFamily";
  public static final String l = "addFontWeightStyle";
  
  static
  {
    Object localObject3 = null;
    try
    {
      Object localObject6 = Class.forName("android.graphics.FontFamily");
      Object localObject1 = localObject6;
      localObject4 = ((Class)localObject6).getConstructor(new Class[0]);
      localObject5 = Integer.TYPE;
      Class localClass1 = Integer.TYPE;
      Class localClass2 = Boolean.TYPE;
      localObject5 = ((Class)localObject6).getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, localObject5, List.class, localClass1, localClass2 });
      localObject6 = Array.newInstance((Class)localObject6, 1);
      localObject6 = localObject6.getClass();
      localObject6 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { localObject6 });
      localObject3 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject6;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    localClassNotFoundException.getClass().getName();
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    RegionParamsConstructor = localObject3;
    c = localObject2;
    d = (Method)localObject4;
    a = (Method)localObject5;
  }
  
  public c() {}
  
  public static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Method localMethod = d;
    try
    {
      paramObject = localMethod.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
      paramObject = (Boolean)paramObject;
      paramBoolean = paramObject.booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public static boolean b()
  {
    Method localMethod = d;
    return d != null;
  }
  
  public static Typeface get(Object paramObject)
  {
    Object localObject = c;
    try
    {
      localObject = Array.newInstance((Class)localObject, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = a;
      paramObject = paramObject.invoke(null, new Object[] { localObject });
      return (Typeface)paramObject;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  public static Object valueOf()
  {
    Object localObject = RegionParamsConstructor;
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel, int paramInt)
  {
    Object localObject = valueOf();
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int j = paramArrayOfLabel.length;
    int i = 0;
    while (i < j)
    {
      Label localLabel = paramArrayOfLabel[i];
      Uri localUri = localLabel.getName();
      ByteBuffer localByteBuffer2 = (ByteBuffer)localSimpleArrayMap.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer2 = a.read(paramContext, paramCancellationSignal, localUri);
        localByteBuffer1 = localByteBuffer2;
        localSimpleArrayMap.put(localUri, localByteBuffer2);
      }
      if (!a(localObject, localByteBuffer1, localLabel.b(), localLabel.a(), localLabel.getValue())) {
        return null;
      }
      i += 1;
    }
    return Typeface.create(get(localObject), paramInt);
  }
  
  public Typeface a(Context paramContext, x paramX, Resources paramResources, int paramInt)
  {
    Object localObject1 = valueOf();
    paramX = paramX.a();
    int i = paramX.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramX[paramInt];
      ByteBuffer localByteBuffer = a.a(paramContext, paramResources, localObject2.b());
      if (localByteBuffer == null) {
        return null;
      }
      if (!a(localObject1, localByteBuffer, localObject2.c(), localObject2.e(), localObject2.r())) {
        return null;
      }
      paramInt += 1;
    }
    return get(localObject1);
  }
}
