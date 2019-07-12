package com.google.android.android.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.android.dynamic.IObjectWrapper;

public abstract interface IMAXSIncomingFileTransferService
  extends IInterface
{
  public abstract XYSeries getChat(IObjectWrapper paramIObjectWrapper, CustomTile paramCustomTile)
    throws RemoteException;
}
