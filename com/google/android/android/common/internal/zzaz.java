package com.google.android.android.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.common.Element;
import com.google.android.android.dynamic.IObjectWrapper;

public abstract interface zzaz
  extends IInterface
{
  public abstract boolean getValue(Element paramElement, IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
}
