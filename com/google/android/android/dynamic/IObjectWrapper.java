package com.google.android.android.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.android.internal.zzec;

public abstract interface IObjectWrapper
  extends IInterface
{
  public class zza
    extends zzec
    implements IObjectWrapper
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
    }
    
    public static IObjectWrapper zzao(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
      if ((localIInterface instanceof IObjectWrapper)) {
        return (IObjectWrapper)localIInterface;
      }
      return new Profile(paramIBinder);
    }
  }
}
