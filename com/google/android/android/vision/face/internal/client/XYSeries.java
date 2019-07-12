package com.google.android.android.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.internal.zzdck;

public abstract interface XYSeries
  extends IInterface
{
  public abstract FaceParcel[] get(IObjectWrapper paramIObjectWrapper, zzdck paramZzdck)
    throws RemoteException;
  
  public abstract void zzbin()
    throws RemoteException;
  
  public abstract boolean zzeu(int paramInt)
    throws RemoteException;
}
