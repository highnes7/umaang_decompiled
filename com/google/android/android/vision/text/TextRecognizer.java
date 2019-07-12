package com.google.android.android.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.android.internal.zzdcj;
import com.google.android.android.internal.zzdck;
import com.google.android.android.internal.zzdcs;
import com.google.android.android.internal.zzdcu;
import com.google.android.android.internal.zzdcy;
import com.google.android.android.internal.zzdcz;
import com.google.android.android.vision.Frame;
import com.google.android.android.vision.Frame.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class TextRecognizer
  extends com.google.android.gms.vision.Detector<com.google.android.gms.vision.text.TextBlock>
{
  public final zzdcy zzkjx;
  
  public TextRecognizer()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  public TextRecognizer(zzdcy paramZzdcy)
  {
    zzkjx = paramZzdcy;
  }
  
  public static SparseArray clone(zzdcs[] paramArrayOfZzdcs)
  {
    SparseArray localSparseArray3 = new SparseArray();
    int k = paramArrayOfZzdcs.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      zzdcs localZzdcs = paramArrayOfZzdcs[i];
      SparseArray localSparseArray2 = (SparseArray)localSparseArray3.get(zzkki);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        localSparseArray3.append(zzkki, localSparseArray1);
      }
      localSparseArray1.append(zzkkj, localZzdcs);
      i += 1;
    }
    paramArrayOfZzdcs = new SparseArray(localSparseArray3.size());
    i = j;
    while (i < localSparseArray3.size())
    {
      paramArrayOfZzdcs.append(localSparseArray3.keyAt(i), new TextBlock((SparseArray)localSparseArray3.valueAt(i)));
      i += 1;
    }
    return paramArrayOfZzdcs;
  }
  
  public final SparseArray detect(Frame paramFrame)
  {
    zzdcu localZzdcu = new zzdcu(new Rect());
    if (paramFrame != null)
    {
      zzdck localZzdck = zzdck.get(paramFrame);
      if (paramFrame.getBitmap() != null) {}
      Object localObject2;
      for (Object localObject1 = paramFrame.getBitmap();; localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length))
      {
        localObject2 = localObject1;
        break;
        localObject1 = paramFrame.getMetadata();
        ByteBuffer localByteBuffer = paramFrame.getGrayscaleImageData();
        i = ((Frame.Metadata)localObject1).getFormat();
        j = width;
        k = height;
        if ((localByteBuffer.hasArray()) && (localByteBuffer.arrayOffset() == 0))
        {
          localObject1 = localByteBuffer.array();
        }
        else
        {
          localObject2 = new byte[localByteBuffer.capacity()];
          localObject1 = localObject2;
          localByteBuffer.get((byte[])localObject2);
        }
        localObject2 = new ByteArrayOutputStream();
        new YuvImage((byte[])localObject1, i, j, k, null).compressToJpeg(new Rect(0, 0, j, k), 100, (OutputStream)localObject2);
        localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
      }
      int j = ((Bitmap)localObject1).getWidth();
      int k = ((Bitmap)localObject1).getHeight();
      localObject1 = localObject2;
      if (rotation != 0)
      {
        localObject1 = new Matrix();
        i = rotation;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3) {
                i = 270;
              } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
              }
            }
            else {
              i = 180;
            }
          }
          else {
            i = 90;
          }
        }
        else {
          i = 0;
        }
        ((Matrix)localObject1).postRotate(i);
        localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, j, k, (Matrix)localObject1, false);
      }
      int i = rotation;
      if ((i == 1) || (i == 3))
      {
        width = k;
        height = j;
      }
      if (!zzkkk.isEmpty())
      {
        localObject2 = zzkkk;
        i = paramFrame.getMetadata().getWidth();
        j = paramFrame.getMetadata().getHeight();
        k = rotation;
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3) {
              paramFrame = (Frame)localObject2;
            } else {
              paramFrame = new Rect(top, i - right, bottom, i - left);
            }
          }
          else {
            paramFrame = new Rect(i - right, j - bottom, i - left, j - top);
          }
        }
        else {
          paramFrame = new Rect(j - bottom, left, j - top, right);
        }
        zzkkk.set(paramFrame);
      }
      rotation = 0;
      return clone(zzkjx.generateKey((Bitmap)localObject1, localZzdck, localZzdcu));
    }
    paramFrame = new IllegalArgumentException("No frame supplied.");
    throw paramFrame;
  }
  
  public final boolean isOperational()
  {
    return zzkjx.isOperational();
  }
  
  public final void release()
  {
    super.release();
    zzkjx.zzbio();
  }
  
  public class Builder
  {
    public zzdcz zzkjy = new zzdcz();
    
    public Builder() {}
    
    public TextRecognizer build()
    {
      return new TextRecognizer(new zzdcy(TextRecognizer.this, zzkjy), null);
    }
  }
}
