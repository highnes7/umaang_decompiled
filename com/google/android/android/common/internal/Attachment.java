package com.google.android.android.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;

public final class Attachment
  extends zzan
{
  public static Account query(zzam paramZzam)
  {
    long l;
    if (paramZzam != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      paramZzam = paramZzam.getAccount();
      Binder.restoreCallingIdentity(l);
      return paramZzam;
    }
    catch (Throwable paramZzam)
    {
      Binder.restoreCallingIdentity(l);
      throw paramZzam;
      Binder.restoreCallingIdentity(l);
      return null;
    }
    catch (RemoteException paramZzam)
    {
      for (;;) {}
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    throw new NoSuchMethodError();
  }
  
  public final Account getAccount()
  {
    throw new NoSuchMethodError();
  }
}
