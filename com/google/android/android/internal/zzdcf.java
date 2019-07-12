package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.vision.barcode.Barcode;

public abstract interface zzdcf
  extends IInterface
{
  public abstract Barcode[] getSuggestions(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException;
  
  public abstract Barcode[] readFromParcel(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException;
  
  public abstract void zzbin()
    throws RemoteException;
}
