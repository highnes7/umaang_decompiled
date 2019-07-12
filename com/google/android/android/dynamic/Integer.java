package com.google.android.android.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.reflect.Field;

public final class Integer<T>
  extends IObjectWrapper.zza
{
  public final T mWrappedObject;
  
  public Integer(Object paramObject)
  {
    mWrappedObject = paramObject;
  }
  
  public static IObjectWrapper compareTo(Object paramObject)
  {
    return new Integer(paramObject);
  }
  
  public static Object get(IObjectWrapper paramIObjectWrapper)
  {
    if ((paramIObjectWrapper instanceof Integer)) {
      return mWrappedObject;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramIObjectWrapper = null;
    int m = arrayOfField.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Field localField = arrayOfField[i];
      k = j;
      if (!localField.isSynthetic())
      {
        k = j + 1;
        paramIObjectWrapper = localField;
      }
      i += 1;
    }
    if (j == 1)
    {
      if (!paramIObjectWrapper.isAccessible())
      {
        paramIObjectWrapper.setAccessible(true);
        try
        {
          paramIObjectWrapper = paramIObjectWrapper.get(localIBinder);
          return paramIObjectWrapper;
        }
        catch (IllegalAccessException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
        }
        catch (NullPointerException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
        }
      }
      throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    }
    paramIObjectWrapper = new IllegalArgumentException(StringBuilder.add(64, "Unexpected number of IObjectWrapper declared fields: ", arrayOfField.length));
    throw paramIObjectWrapper;
  }
}
