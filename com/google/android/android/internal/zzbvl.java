package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public abstract interface zzbvl
  extends IInterface
{
  public abstract boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
    throws RemoteException;
  
  public abstract int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract long getLongFlagValue(String paramString, long paramLong, int paramInt)
    throws RemoteException;
  
  public abstract String getStringFlagValue(String paramString1, String paramString2, int paramInt)
    throws RemoteException;
  
  public abstract void init(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}
