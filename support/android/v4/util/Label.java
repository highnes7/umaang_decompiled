package support.android.v4.util;

import android.text.TextUtils;
import b.b.a.N;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

@N({b.b.a.N.a.b})
public class Label
{
  public Label() {}
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, String paramString)
  {
    if (!Float.isNaN(paramFloat1))
    {
      if (paramFloat1 >= paramFloat2)
      {
        if (paramFloat1 <= paramFloat3) {
          return paramFloat1;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[] { paramString, Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[] { paramString, Float.valueOf(paramFloat2), Float.valueOf(paramFloat3) }));
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be NaN"));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & paramInt2) == paramInt1) {
      return paramInt1;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Requested flags 0x");
    localStringBuilder.append(Integer.toHexString(paramInt1));
    localStringBuilder.append(", but only 0x");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    localStringBuilder.append(" are allowed");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (paramInt1 >= paramInt2)
    {
      if (paramInt1 <= paramInt3) {
        return paramInt1;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static CharSequence a(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      return paramCharSequence;
    }
    throw new IllegalArgumentException();
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      return paramCharSequence;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static Object a(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject;
    }
    throw new NullPointerException();
  }
  
  public static void a(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public static Object[] a(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject != null)
    {
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfObject.length) {
          return paramArrayOfObject;
        }
        if (paramArrayOfObject[i] == null) {
          break;
        }
        i += 1;
      }
      throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[] { paramString, Integer.valueOf(i) }));
    }
    paramArrayOfObject = new NullPointerException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be null"));
    throw paramArrayOfObject;
    return paramArrayOfObject;
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static long copyTo(long paramLong)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static void copyTo(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static float evaluate(float paramFloat, String paramString)
  {
    if (!Float.isNaN(paramFloat))
    {
      if (!Float.isInfinite(paramFloat)) {
        return paramFloat;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be infinite"));
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be NaN"));
  }
  
  public static long getEntry(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 >= paramLong2)
    {
      if (paramLong1 <= paramLong3) {
        return paramLong1;
      }
      throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
    }
    throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[] { paramString, Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
  }
  
  public static Collection getEntry(Collection paramCollection, String paramString)
  {
    if (paramCollection != null)
    {
      long l = 0L;
      Iterator localIterator = paramCollection.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          return paramCollection;
        }
        if (localIterator.next() == null) {
          break;
        }
        l += 1L;
      }
      throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[] { paramString, Long.valueOf(l) }));
    }
    paramCollection = new NullPointerException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be null"));
    throw paramCollection;
    return paramCollection;
  }
  
  public static int getKey(int paramInt)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static int getKey(int paramInt, String paramString)
  {
    if (paramInt >= 0) {
      return paramInt;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static long getKey(long paramLong, String paramString)
  {
    if (paramLong >= 0L) {
      return paramLong;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static Object getKey(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1;
    }
    throw new NullPointerException(String.valueOf(paramObject2));
  }
  
  public static Collection notEmpty(Collection paramCollection, String paramString)
  {
    if (paramCollection != null)
    {
      if (!paramCollection.isEmpty()) {
        return paramCollection;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " is empty"));
    }
    throw new NullPointerException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, " must not be null"));
  }
  
  public static float[] process(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" must not be null");
    getKey(paramArrayOfFloat, localStringBuilder.toString());
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      float f = paramArrayOfFloat[i];
      if (!Float.isNaN(f))
      {
        if (f >= paramFloat1)
        {
          if (f <= paramFloat2) {
            i += 1;
          } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", new Object[] { paramString, Integer.valueOf(i), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
          }
        }
        else {
          throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", new Object[] { paramString, Integer.valueOf(i), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) }));
        }
      }
      else
      {
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(paramString);
        paramArrayOfFloat.append("[");
        paramArrayOfFloat.append(i);
        paramArrayOfFloat.append("] must not be NaN");
        throw new IllegalArgumentException(paramArrayOfFloat.toString());
      }
    }
    return paramArrayOfFloat;
  }
}
