package com.google.android.android.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

public abstract interface zzcbo
  extends IInterface
{
  public abstract void addPackage(zzcav paramZzcav)
    throws RemoteException;
  
  public abstract void bindToService(zzcas paramZzcas)
    throws RemoteException;
  
  public abstract void getAbsoluteUrl(zzcas paramZzcas)
    throws RemoteException;
  
  public abstract String getAttachment(zzcas paramZzcas)
    throws RemoteException;
  
  public abstract List getFromLocationName(zzcas paramZzcas, boolean paramBoolean)
    throws RemoteException;
  
  public abstract List getFromLocationName(String paramString1, String paramString2, zzcas paramZzcas)
    throws RemoteException;
  
  public abstract List getFromLocationName(String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract List getFromLocationName(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract List getFromLocationName(String paramString1, String paramString2, boolean paramBoolean, zzcas paramZzcas)
    throws RemoteException;
  
  public abstract void getPackageInfo(zzcav paramZzcav, zzcas paramZzcas)
    throws RemoteException;
  
  public abstract void handleResult(zzcbk paramZzcbk, String paramString1, String paramString2)
    throws RemoteException;
  
  public abstract void onNetworkStateChanged(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException;
  
  public abstract byte[] saveToFile(zzcbk paramZzcbk, String paramString)
    throws RemoteException;
  
  public abstract void trim(zzcbk paramZzcbk, zzcas paramZzcas)
    throws RemoteException;
  
  public abstract void trim(zzcft paramZzcft, zzcas paramZzcas)
    throws RemoteException;
}
