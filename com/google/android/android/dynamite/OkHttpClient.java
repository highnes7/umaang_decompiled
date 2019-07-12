package com.google.android.android.dynamite;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public abstract interface OkHttpClient
  extends IInterface
{
  public abstract IObjectWrapper getAbsoluteUrl(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
    throws RemoteException;
}
