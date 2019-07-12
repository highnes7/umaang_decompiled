package com.google.android.android.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import com.google.android.android.dynamic.Integer;
import com.google.android.android.internal.zzdck;
import com.google.android.android.vision.face.Face;
import com.google.android.android.vision.face.Landmark;
import com.google.android.gms.vision.face.internal.client.zze;
import java.nio.ByteBuffer;

public final class PieRenderer
  extends com.google.android.gms.internal.zzdcj<zze>
{
  public final CustomTile zzkjc;
  
  public PieRenderer(Context paramContext, CustomTile paramCustomTile)
  {
    super(paramContext, "FaceNativeHandle");
    zzkjc = paramCustomTile;
    zzbip();
  }
  
  public static Landmark[] a(FaceParcel paramFaceParcel)
  {
    paramFaceParcel = zzkjf;
    int i = 0;
    if (paramFaceParcel == null) {
      return new Landmark[0];
    }
    Landmark[] arrayOfLandmark = new Landmark[paramFaceParcel.length];
    while (i < paramFaceParcel.length)
    {
      Object localObject = paramFaceParcel[i];
      arrayOfLandmark[i] = new Landmark(new PointF(width, height), type);
      i += 1;
    }
    return arrayOfLandmark;
  }
  
  public final Face[] onRender(ByteBuffer paramByteBuffer, zzdck paramZzdck)
  {
    boolean bool = isOperational();
    int i = 0;
    if (!bool) {
      return new Face[0];
    }
    try
    {
      paramByteBuffer = new Integer(paramByteBuffer);
      Object localObject = zzbip();
      localObject = (XYSeries)localObject;
      paramByteBuffer = ((XYSeries)localObject).get(paramByteBuffer, paramZzdck);
      paramZzdck = new Face[paramByteBuffer.length];
      while (i < paramByteBuffer.length)
      {
        localObject = paramByteBuffer[i];
        paramZzdck[i] = new Face(x, new PointF(centerX, centerY), width, height, zzkjd, zzkje, a((FaceParcel)localObject), zzkjg, zzkjh, zzkji);
        i += 1;
      }
      return paramZzdck;
    }
    catch (RemoteException paramByteBuffer)
    {
      for (;;) {}
    }
    return new Face[0];
  }
  
  public final void zzbim()
    throws RemoteException
  {
    ((XYSeries)zzbip()).zzbin();
  }
  
  public final boolean zzeu(int paramInt)
  {
    if (!isOperational()) {
      return false;
    }
    try
    {
      Object localObject = zzbip();
      localObject = (XYSeries)localObject;
      boolean bool = ((XYSeries)localObject).zzeu(paramInt);
      return bool;
    }
    catch (RemoteException localRemoteException) {}
    return false;
  }
}
