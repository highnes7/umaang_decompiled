package com.google.android.android.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.android.dynamic.Integer;

public final class zzdcy
  extends com.google.android.gms.internal.zzdcj<com.google.android.gms.internal.zzdco>
{
  public final zzdcz zzkjy;
  
  public zzdcy(Context paramContext, zzdcz paramZzdcz)
  {
    super(paramContext, "TextNativeHandle");
    zzkjy = paramZzdcz;
    zzbip();
  }
  
  public final zzdcs[] generateKey(Bitmap paramBitmap, zzdck paramZzdck, zzdcu paramZzdcu)
  {
    if (!isOperational()) {
      return new zzdcs[0];
    }
    try
    {
      paramBitmap = new Integer(paramBitmap);
      Object localObject = zzbip();
      localObject = (zzdco)localObject;
      paramBitmap = ((zzdco)localObject).readFromParcel(paramBitmap, paramZzdck, paramZzdcu);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      for (;;) {}
    }
    return new zzdcs[0];
  }
  
  public final void zzbim()
    throws RemoteException
  {
    ((zzdco)zzbip()).zzbiq();
  }
}
