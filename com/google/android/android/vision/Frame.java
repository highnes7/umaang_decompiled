package com.google.android.android.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.nio.ByteBuffer;

public class Frame
{
  public static final int ROTATION_0 = 0;
  public static final int ROTATION_180 = 2;
  public static final int ROTATION_270 = 3;
  public static final int ROTATION_90 = 1;
  public Bitmap mBitmap = null;
  public Metadata zzkhy = new Metadata();
  public ByteBuffer zzkhz = null;
  
  public Frame() {}
  
  public Bitmap getBitmap()
  {
    return mBitmap;
  }
  
  public ByteBuffer getGrayscaleImageData()
  {
    Object localObject = mBitmap;
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = mBitmap.getHeight();
      int k = i * j;
      localObject = new int[k];
      mBitmap.getPixels((int[])localObject, 0, i, 0, 0, i, j);
      byte[] arrayOfByte = new byte[k];
      i = 0;
      while (i < localObject.length)
      {
        float f1 = Color.red(localObject[i]);
        float f2 = Color.green(localObject[i]);
        arrayOfByte[i] = ((byte)(int)(Color.blue(localObject[i]) * 0.114F + (f2 * 0.587F + f1 * 0.299F)));
        i += 1;
      }
      return ByteBuffer.wrap(arrayOfByte);
    }
    return zzkhz;
  }
  
  public Metadata getMetadata()
  {
    return zzkhy;
  }
  
  public class Builder
  {
    public Frame zzkia = new Frame();
    
    public Builder() {}
    
    public Frame build()
    {
      Frame localFrame = zzkia;
      if ((zzkhz == null) && (mBitmap == null)) {
        throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
      }
      return zzkia;
    }
    
    public Builder setBitmap(Bitmap paramBitmap)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Frame localFrame = zzkia;
      mBitmap = paramBitmap;
      paramBitmap = localFrame.getMetadata();
      zzakq = i;
      zzakr = j;
      return this;
    }
    
    public Builder setId(int paramInt)
    {
      zzkia.getMetadata().mId = paramInt;
      return this;
    }
    
    public Builder setImageData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramByteBuffer != null)
      {
        if (paramByteBuffer.capacity() >= paramInt1 * paramInt2)
        {
          if ((paramInt3 != 16) && (paramInt3 != 17) && (paramInt3 != 842094169)) {
            throw new IllegalArgumentException(StringBuilder.add(37, "Unsupported image format: ", paramInt3));
          }
          Frame localFrame = zzkia;
          zzkhz = paramByteBuffer;
          paramByteBuffer = localFrame.getMetadata();
          zzakq = paramInt1;
          zzakr = paramInt2;
          format = paramInt3;
          return this;
        }
        throw new IllegalArgumentException("Invalid image data size.");
      }
      throw new IllegalArgumentException("Null image data supplied.");
    }
    
    public Builder setRotation(int paramInt)
    {
      zzkia.getMetadata().zzcew = paramInt;
      return this;
    }
    
    public Builder setTimestampMillis(long paramLong)
    {
      zzkia.getMetadata().zzhln = paramLong;
      return this;
    }
  }
  
  public class Metadata
  {
    public int format = -1;
    public int mId;
    public int zzakq;
    public int zzakr;
    public int zzcew;
    public long zzhln;
    
    public Metadata() {}
    
    public Metadata()
    {
      zzakq = this$1.getWidth();
      zzakr = this$1.getHeight();
      mId = this$1.getId();
      zzhln = this$1.getTimestampMillis();
      zzcew = this$1.getRotation();
    }
    
    public int getFormat()
    {
      return format;
    }
    
    public int getHeight()
    {
      return zzakr;
    }
    
    public int getId()
    {
      return mId;
    }
    
    public int getRotation()
    {
      return zzcew;
    }
    
    public long getTimestampMillis()
    {
      return zzhln;
    }
    
    public int getWidth()
    {
      return zzakq;
    }
    
    public final void zzbil()
    {
      if (zzcew % 2 != 0)
      {
        int i = zzakq;
        zzakq = zzakr;
        zzakr = i;
      }
      zzcew = 0;
    }
  }
}
