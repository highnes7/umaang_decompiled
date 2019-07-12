package com.google.android.android.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public abstract interface Array
  extends IInterface
{
  public abstract IObjectWrapper getAbsoluteUrl(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
    throws RemoteException;
  
  public abstract int insert(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
    throws RemoteException;
}
