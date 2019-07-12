package com.google.android.android.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zzdce
  extends com.google.android.gms.internal.zzdcj<com.google.android.gms.internal.zzdcf>
{
  public final zzdcc zzkik;
  
  public zzdce(Context paramContext, zzdcc paramZzdcc)
  {
    super(paramContext, "BarcodeNativeHandle");
    zzkik = paramZzdcc;
    zzbip();
  }
  
  public final Barcode[] generateKey(Bitmap paramBitmap, zzdck paramZzdck)
  {
    if (!isOperational()) {
      return new Barcode[0];
    }
    try
    {
      paramBitmap = new Integer(paramBitmap);
      Object localObject = zzbip();
      localObject = (zzdcf)localObject;
      paramBitmap = ((zzdcf)localObject).readFromParcel(paramBitmap, paramZzdck);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      for (;;) {}
    }
    return new Barcode[0];
  }
  
  public final Barcode[] max(ByteBuffer paramByteBuffer, zzdck paramZzdck)
  {
    if (!isOperational()) {
      return new Barcode[0];
    }
    try
    {
      paramByteBuffer = new Integer(paramByteBuffer);
      Object localObject = zzbip();
      localObject = (zzdcf)localObject;
      paramByteBuffer = ((zzdcf)localObject).getSuggestions(paramByteBuffer, paramZzdck);
      return paramByteBuffer;
    }
    catch (RemoteException paramByteBuffer)
    {
      for (;;) {}
    }
    return new Barcode[0];
  }
  
  public final void zzbim()
    throws RemoteException
  {
    if (isOperational()) {
      ((zzdcf)zzbip()).zzbin();
    }
  }
}
