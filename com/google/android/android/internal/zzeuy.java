package com.google.android.android.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzeuy
  extends zzeuj
{
  public static final Logger logger = Logger.getLogger(com.google.android.gms.internal.zzeuy.class.getName());
  public static final boolean zzonr = zzexm.zzonr;
  
  public zzeuy() {}
  
  public static int Refresh(int paramInt, long paramLong)
  {
    paramInt = zzkb(paramInt);
    return zzcv(paramLong) + paramInt;
  }
  
  public static int Refresh(int paramInt, String paramString)
  {
    paramInt = zzkb(paramInt);
    return zztk(paramString) + paramInt;
  }
  
  public static int accessFlags(int paramInt, double paramDouble)
  {
    return zzkb(paramInt) + 8;
  }
  
  public static int bitLength(zzewf paramZzewf)
  {
    int i = paramZzewf.zzhi();
    return zzkd(i) + i;
  }
  
  public static int bitLength(zzewl paramZzewl)
  {
    int i = paramZzewl.zzhi();
    return zzkd(i) + i;
  }
  
  public static zzeuy buffer(OutputStream paramOutputStream, int paramInt)
  {
    return new zzd(paramInt);
  }
  
  public static int byteToString(int paramInt, long paramLong)
  {
    paramInt = zzkb(paramInt);
    return zzcv(paramLong) + paramInt;
  }
  
  public static int computeDoubleSizeNoTag(double paramDouble)
  {
    return 8;
  }
  
  public static int getShares(int paramInt, zzeuk paramZzeuk)
  {
    paramInt = zzkb(paramInt);
    int i = paramZzeuk.size();
    return zzkd(i) + i + paramInt;
  }
  
  public static int getShares(int paramInt, zzewl paramZzewl)
  {
    paramInt = zzkb(paramInt);
    int i = paramZzewl.zzhi();
    return paramInt + (zzkd(i) + i);
  }
  
  public static int getWordRangeAtCursor(int paramInt, boolean paramBoolean)
  {
    return zzkb(paramInt) + 1;
  }
  
  public static int goToRow(int paramInt, long paramLong)
  {
    return zzkb(paramInt) + 8;
  }
  
  public static zzeuy sweep(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzb(paramInt1, paramInt2);
  }
  
  public static int write(float paramFloat)
  {
    return 4;
  }
  
  public static int writeValue(zzewl paramZzewl)
  {
    return paramZzewl.zzhi();
  }
  
  public static int zzaa(int paramInt1, int paramInt2)
  {
    paramInt1 = zzkb(paramInt1);
    return zzkc(paramInt2) + paramInt1;
  }
  
  public static int zzab(int paramInt1, int paramInt2)
  {
    paramInt1 = zzkb(paramInt1);
    return zzkd(paramInt2) + paramInt1;
  }
  
  public static int zzac(int paramInt1, int paramInt2)
  {
    return zzkb(paramInt1) + 4;
  }
  
  public static int zzad(int paramInt1, int paramInt2)
  {
    paramInt1 = zzkb(paramInt1);
    return zzkc(paramInt2) + paramInt1;
  }
  
  public static int zzan(zzeuk paramZzeuk)
  {
    int i = paramZzeuk.size();
    return zzkd(i) + i;
  }
  
  public static zzeuy zzbc(byte[] paramArrayOfByte)
  {
    return new zzb(0, paramArrayOfByte.length);
  }
  
  public static int zzbd(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return zzkd(i) + i;
  }
  
  public static int zzcu(long paramLong)
  {
    return zzcv(paramLong);
  }
  
  public static int zzcv(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if (paramLong < 0L) {
      return 10;
    }
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      j = 6;
      paramLong >>>= 28;
    }
    else
    {
      j = 2;
    }
    int i = j;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
    {
      i = j + 2;
      l = paramLong >>> 14;
    }
    int j = i;
    if ((l & 0xFFFFFFFFFFFFC000) != 0L) {
      j = i + 1;
    }
    return j;
  }
  
  public static int zzcw(long paramLong)
  {
    return zzcv(zzcz(paramLong));
  }
  
  public static int zzcx(long paramLong)
  {
    return 8;
  }
  
  public static int zzcy(long paramLong)
  {
    return 8;
  }
  
  public static int zzcy(boolean paramBoolean)
  {
    return 1;
  }
  
  public static long zzcz(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public static int zzjw(int paramInt)
  {
    if (paramInt > 4096) {
      return 4096;
    }
    return paramInt;
  }
  
  public static int zzkb(int paramInt)
  {
    return zzkd(paramInt << 3);
  }
  
  public static int zzkc(int paramInt)
  {
    if (paramInt >= 0) {
      return zzkd(paramInt);
    }
    return 10;
  }
  
  public static int zzkd(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzke(int paramInt)
  {
    return zzkd(zzkj(paramInt));
  }
  
  public static int zzkf(int paramInt)
  {
    return 4;
  }
  
  public static int zzkg(int paramInt)
  {
    return 4;
  }
  
  public static int zzkh(int paramInt)
  {
    return zzkc(paramInt);
  }
  
  public static int zzki(int paramInt)
  {
    return zzkd(paramInt) + paramInt;
  }
  
  public static int zzkj(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public static int zztk(String paramString)
  {
    try
    {
      i = zzexo.decode(paramString);
    }
    catch (zzexr localZzexr)
    {
      int i;
      for (;;) {}
    }
    i = paramString.getBytes(zzevu.UTF_8).length;
    return zzkd(i) + i;
  }
  
  public abstract void Refresh(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract void hybrid(int paramInt1, int paramInt2)
    throws IOException;
  
  public final void warn(String paramString, zzexr paramZzexr)
    throws IOException
  {
    logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramZzexr);
    paramString = paramString.getBytes(zzevu.UTF_8);
    int i = paramString.length;
    try
    {
      zzjy(i);
      i = paramString.length;
      processBytes(paramString, 0, i);
      return;
    }
    catch (zzc paramString)
    {
      throw paramString;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new zzc(paramString);
    }
  }
  
  public abstract void write(byte paramByte)
    throws IOException;
  
  public abstract void write(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public final void writeDouble(int paramInt, double paramDouble)
    throws IOException
  {
    writeInt64(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public abstract void writeField(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void writeInt32(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void writeInt32(int paramInt, zzeuk paramZzeuk)
    throws IOException;
  
  public abstract void writeInt32(int paramInt, String paramString)
    throws IOException;
  
  public abstract void writeInt64(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void writeLong(int paramInt, long paramLong)
    throws IOException;
  
  public abstract void writeMessage(int paramInt, zzewl paramZzewl)
    throws IOException;
  
  public abstract void writeTag(zzewl paramZzewl)
    throws IOException;
  
  public abstract void writeValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void zzam(zzeuk paramZzeuk)
    throws IOException;
  
  public abstract void zzcr(long paramLong)
    throws IOException;
  
  public final void zzcs(long paramLong)
    throws IOException
  {
    zzcr(zzcz(paramLong));
  }
  
  public abstract void zzct(long paramLong)
    throws IOException;
  
  public abstract int zzctm();
  
  public final void zzctn()
  {
    if (zzctm() == 0) {
      return;
    }
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public abstract void zzjx(int paramInt)
    throws IOException;
  
  public abstract void zzjy(int paramInt)
    throws IOException;
  
  public final void zzjz(int paramInt)
    throws IOException
  {
    zzjy(zzkj(paramInt));
  }
  
  public abstract void zzka(int paramInt)
    throws IOException;
  
  public abstract void zztj(String paramString)
    throws IOException;
  
  public abstract class zza
    extends zzeuy
  {
    public final byte[] buffer;
    public final int limit;
    public int position;
    public int zzons;
    
    public zza()
    {
      super();
      if (this$1 >= 0)
      {
        buffer = new byte[Math.max(this$1, 20)];
        limit = buffer.length;
        return;
      }
      throw new IllegalArgumentException("bufferSize must be >= 0");
    }
    
    public final void writeString(byte paramByte)
    {
      byte[] arrayOfByte = buffer;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = paramByte;
      zzons += 1;
    }
    
    public final void zzae(int paramInt1, int paramInt2)
    {
      zzkk(paramInt1 << 3 | paramInt2);
    }
    
    public final int zzctm()
    {
      throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
    
    public final void zzda(long paramLong)
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzeuy.zzonr)
      {
        l = position;
        for (;;)
        {
          if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
          {
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzexm.setBytes(arrayOfByte, i, (byte)(int)paramLong);
            i = (int)(position - l);
            i = zzons + i;
            zzons = i;
            return;
          }
          arrayOfByte = buffer;
          i = position;
          position = (i + 1);
          zzexm.setBytes(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
          paramLong >>>= 7;
        }
      }
      for (;;)
      {
        if ((l & 0xFFFFFFFFFFFFFF80) == 0L)
        {
          arrayOfByte = buffer;
          i = position;
          position = (i + 1);
          arrayOfByte[i] = ((byte)(int)l);
          i = zzons + 1;
          break;
        }
        arrayOfByte = buffer;
        i = position;
        position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
        zzons += 1;
        l >>>= 7;
      }
    }
    
    public final void zzdb(long paramLong)
    {
      byte[] arrayOfByte = buffer;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong >> 24));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 32));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 40));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 48));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 56));
      zzons += 8;
    }
    
    public final void zzkk(int paramInt)
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzeuy.zzonr)
      {
        long l = position;
        for (;;)
        {
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            arrayOfByte = buffer;
            i = position;
            position = (i + 1);
            zzexm.setBytes(arrayOfByte, i, (byte)paramInt);
            paramInt = (int)(position - l);
            zzons += paramInt;
            return;
          }
          arrayOfByte = buffer;
          i = position;
          position = (i + 1);
          zzexm.setBytes(arrayOfByte, i, (byte)(paramInt & 0x7F | 0x80));
          paramInt >>>= 7;
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0)
        {
          arrayOfByte = buffer;
          paramInt = position;
          position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          zzons += 1;
          return;
        }
        arrayOfByte = buffer;
        paramInt = position;
        position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        zzons += 1;
        i >>>= 7;
      }
    }
    
    public final void zzkl(int paramInt)
    {
      byte[] arrayOfByte = buffer;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16));
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 24));
      zzons += 4;
    }
  }
  
  public class zzb
    extends zzeuy
  {
    public final int limit;
    public final int offset;
    public int position;
    
    public zzb(int paramInt1, int paramInt2)
    {
      super();
      if (zzeuy.this != null)
      {
        int i = zzeuy.this.length;
        int j = paramInt1 + paramInt2;
        if ((paramInt1 | paramInt2 | i - j) >= 0)
        {
          offset = paramInt1;
          position = paramInt1;
          limit = j;
          return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(zzeuy.this.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      throw new NullPointerException("buffer");
    }
    
    public final void Refresh(int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramInt1, 0);
      zzjx(paramInt2);
    }
    
    public void flush() {}
    
    public final void hybrid(int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramInt1, 0);
      zzjy(paramInt2);
    }
    
    public final void processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void write(byte paramByte)
      throws IOException
    {
      byte[] arrayOfByte = zzeuy.this;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = paramByte;
    }
    
    public final void write(int paramInt1, int paramInt2)
      throws IOException
    {
      zzjy(paramInt1 << 3 | paramInt2);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      byte[] arrayOfByte = zzeuy.this;
      int i = position;
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, i, paramInt2);
        position += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new zzeuy.zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(position), Integer.valueOf(limit), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void writeField(int paramInt, boolean paramBoolean)
      throws IOException
    {
      write(paramInt, 0);
      write((byte)paramBoolean);
    }
    
    public final void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramInt1, 5);
      zzka(paramInt2);
    }
    
    public final void writeInt32(int paramInt, zzeuk paramZzeuk)
      throws IOException
    {
      write(paramInt, 2);
      zzam(paramZzeuk);
    }
    
    public final void writeInt32(int paramInt, String paramString)
      throws IOException
    {
      write(paramInt, 2);
      zztj(paramString);
    }
    
    public final void writeInt64(int paramInt, long paramLong)
      throws IOException
    {
      write(paramInt, 1);
      zzct(paramLong);
    }
    
    public final void writeLong(int paramInt, long paramLong)
      throws IOException
    {
      write(paramInt, 0);
      zzcr(paramLong);
    }
    
    public final void writeMessage(int paramInt, zzewl paramZzewl)
      throws IOException
    {
      write(paramInt, 2);
      writeTag(paramZzewl);
    }
    
    public final void writeTag(zzewl paramZzewl)
      throws IOException
    {
      zzjy(paramZzewl.zzhi());
      paramZzewl.writeTo(this);
    }
    
    public final void writeValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzjy(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzam(zzeuk paramZzeuk)
      throws IOException
    {
      zzjy(paramZzeuk.size());
      paramZzeuk.decrypt(this);
    }
    
    public final void zzcr(long paramLong)
      throws IOException
    {
      long l = paramLong;
      byte[] arrayOfByte;
      int i;
      if (zzeuy.zzonr)
      {
        l = paramLong;
        if (zzctm() >= 10) {
          for (;;)
          {
            if ((paramLong & 0xFFFFFFFFFFFFFF80) == 0L)
            {
              arrayOfByte = zzeuy.this;
              i = position;
              position = (i + 1);
              zzexm.setBytes(arrayOfByte, i, (byte)(int)paramLong);
              return;
            }
            arrayOfByte = zzeuy.this;
            i = position;
            position = (i + 1);
            zzexm.setBytes(arrayOfByte, i, (byte)((int)paramLong & 0x7F | 0x80));
            paramLong >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((l & 0xFFFFFFFFFFFFFF80) == 0L)
        {
          arrayOfByte = zzeuy.this;
          i = position;
          position = (i + 1);
          arrayOfByte[i] = ((byte)(int)l);
          return;
        }
        arrayOfByte = zzeuy.this;
        i = position;
        position = (i + 1);
        arrayOfByte[i] = ((byte)((int)l & 0x7F | 0x80));
        l >>>= 7;
      }
    }
    
    public final void zzct(long paramLong)
      throws IOException
    {
      byte[] arrayOfByte = zzeuy.this;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)paramLong);
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 8));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 16));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 24));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 32));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 40));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 48));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(int)(paramLong >> 56));
    }
    
    public final int zzctm()
    {
      return limit - position;
    }
    
    public final void zzjx(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzjy(paramInt);
        return;
      }
      zzcr(paramInt);
    }
    
    public final void zzjy(int paramInt)
      throws IOException
    {
      int i = paramInt;
      byte[] arrayOfByte;
      if (zzeuy.zzonr)
      {
        i = paramInt;
        if (zzctm() >= 10) {
          for (;;)
          {
            if ((paramInt & 0xFFFFFF80) == 0)
            {
              arrayOfByte = zzeuy.this;
              i = position;
              position = (i + 1);
              zzexm.setBytes(arrayOfByte, i, (byte)paramInt);
              return;
            }
            arrayOfByte = zzeuy.this;
            i = position;
            position = (i + 1);
            zzexm.setBytes(arrayOfByte, i, (byte)(paramInt & 0x7F | 0x80));
            paramInt >>>= 7;
          }
        }
      }
      for (;;)
      {
        if ((i & 0xFFFFFF80) == 0)
        {
          arrayOfByte = zzeuy.this;
          paramInt = position;
          position = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
          return;
        }
        arrayOfByte = zzeuy.this;
        paramInt = position;
        position = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
        i >>>= 7;
      }
    }
    
    public final void zzka(int paramInt)
      throws IOException
    {
      byte[] arrayOfByte = zzeuy.this;
      int i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 16));
      arrayOfByte = zzeuy.this;
      i = position;
      position = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 24));
    }
    
    public final void zztj(String paramString)
      throws IOException
    {
      int i = position;
      try
      {
        int j = paramString.length();
        int k = zzeuy.zzkd(j * 3);
        j = zzeuy.zzkd(paramString.length());
        if (j == k)
        {
          position = (i + j);
          arrayOfByte = zzeuy.this;
          k = position;
          k = zzexo.decode(paramString, arrayOfByte, k, zzctm());
          position = i;
          zzjy(k - i - j);
          position = k;
          return;
        }
        zzjy(zzexo.decode(paramString));
        byte[] arrayOfByte = zzeuy.this;
        j = position;
        j = zzexo.decode(paramString, arrayOfByte, j, zzctm());
        position = j;
        return;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        throw new zzeuy.zzc(paramString);
      }
      catch (zzexr localZzexr)
      {
        position = i;
        warn(paramString, localZzexr);
      }
    }
  }
  
  public final class zzc
    extends IOException
  {
    public zzc()
    {
      super();
    }
    
    public zzc(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public zzc()
    {
      super(this$1);
    }
  }
  
  public final class zzd
    extends zzeuy.zza
  {
    public zzd(int paramInt)
    {
      super();
      if (zzeuy.this != null) {
        return;
      }
      throw new NullPointerException("out");
    }
    
    private final void doFlush()
      throws IOException
    {
      zzeuy.this.write(buffer, 0, position);
      position = 0;
    }
    
    private final void zzkm(int paramInt)
      throws IOException
    {
      if (limit - position < paramInt) {
        doFlush();
      }
    }
    
    public final void Refresh(int paramInt1, int paramInt2)
      throws IOException
    {
      zzkm(20);
      zzae(paramInt1, 0);
      if (paramInt2 >= 0)
      {
        zzkk(paramInt2);
        return;
      }
      zzda(paramInt2);
    }
    
    public final void flush()
      throws IOException
    {
      if (position > 0) {
        doFlush();
      }
    }
    
    public final void hybrid(int paramInt1, int paramInt2)
      throws IOException
    {
      zzkm(20);
      zzae(paramInt1, 0);
      zzkk(paramInt2);
    }
    
    public final void processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      write(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void write(byte paramByte)
      throws IOException
    {
      if (position == limit) {
        doFlush();
      }
      writeString(paramByte);
    }
    
    public final void write(int paramInt1, int paramInt2)
      throws IOException
    {
      zzjy(paramInt1 << 3 | paramInt2);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = limit;
      int j = position;
      if (i - j >= paramInt2)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, buffer, j, paramInt2);
        position += paramInt2;
      }
      else
      {
        i -= j;
        System.arraycopy(paramArrayOfByte, paramInt1, buffer, j, i);
        paramInt1 += i;
        paramInt2 -= i;
        position = limit;
        zzons += i;
        doFlush();
        if (paramInt2 <= limit)
        {
          System.arraycopy(paramArrayOfByte, paramInt1, buffer, 0, paramInt2);
          position = paramInt2;
        }
        else
        {
          zzeuy.this.write(paramArrayOfByte, paramInt1, paramInt2);
        }
      }
      zzons += paramInt2;
    }
    
    public final void writeField(int paramInt, boolean paramBoolean)
      throws IOException
    {
      zzkm(11);
      zzae(paramInt, 0);
      writeString((byte)paramBoolean);
    }
    
    public final void writeInt32(int paramInt1, int paramInt2)
      throws IOException
    {
      zzkm(14);
      zzae(paramInt1, 5);
      zzkl(paramInt2);
    }
    
    public final void writeInt32(int paramInt, zzeuk paramZzeuk)
      throws IOException
    {
      write(paramInt, 2);
      zzam(paramZzeuk);
    }
    
    public final void writeInt32(int paramInt, String paramString)
      throws IOException
    {
      write(paramInt, 2);
      zztj(paramString);
    }
    
    public final void writeInt64(int paramInt, long paramLong)
      throws IOException
    {
      zzkm(18);
      zzae(paramInt, 1);
      zzdb(paramLong);
    }
    
    public final void writeLong(int paramInt, long paramLong)
      throws IOException
    {
      zzkm(20);
      zzae(paramInt, 0);
      zzda(paramLong);
    }
    
    public final void writeMessage(int paramInt, zzewl paramZzewl)
      throws IOException
    {
      write(paramInt, 2);
      writeTag(paramZzewl);
    }
    
    public final void writeTag(zzewl paramZzewl)
      throws IOException
    {
      zzjy(paramZzewl.zzhi());
      paramZzewl.writeTo(this);
    }
    
    public final void writeValue(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      zzjy(paramInt2);
      write(paramArrayOfByte, 0, paramInt2);
    }
    
    public final void zzam(zzeuk paramZzeuk)
      throws IOException
    {
      zzjy(paramZzeuk.size());
      paramZzeuk.decrypt(this);
    }
    
    public final void zzcr(long paramLong)
      throws IOException
    {
      zzkm(10);
      zzda(paramLong);
    }
    
    public final void zzct(long paramLong)
      throws IOException
    {
      zzkm(8);
      zzdb(paramLong);
    }
    
    public final void zzjx(int paramInt)
      throws IOException
    {
      if (paramInt >= 0)
      {
        zzjy(paramInt);
        return;
      }
      zzcr(paramInt);
    }
    
    public final void zzjy(int paramInt)
      throws IOException
    {
      zzkm(10);
      zzkk(paramInt);
    }
    
    public final void zzka(int paramInt)
      throws IOException
    {
      zzkm(4);
      zzkl(paramInt);
    }
    
    public final void zztj(String paramString)
      throws IOException
    {
      try
      {
        int i = paramString.length();
        i *= 3;
        int j = zzeuy.zzkd(i);
        int k = j + i;
        byte[] arrayOfByte;
        if (k > limit)
        {
          arrayOfByte = new byte[i];
          i = zzexo.decode(paramString, arrayOfByte, 0, i);
          zzjy(i);
          processBytes(arrayOfByte, 0, i);
          return;
        }
        if (k > limit - position) {
          doFlush();
        }
        i = zzeuy.zzkd(paramString.length());
        k = position;
        int m;
        int n;
        if (i == j)
        {
          position = (k + i);
          arrayOfByte = buffer;
          j = position;
          m = limit;
          n = position;
        }
        try
        {
          j = zzexo.decode(paramString, arrayOfByte, j, m - n);
          position = k;
          i = j - k - i;
          zzkk(i);
          position = j;
          break label202;
          j = zzexo.decode(paramString);
          i = j;
          zzkk(j);
          arrayOfByte = buffer;
          m = position;
          j = zzexo.decode(paramString, arrayOfByte, m, j);
          position = j;
          label202:
          zzons += i;
          return;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          zzeuy.zzc localZzc = new zzeuy.zzc(localArrayIndexOutOfBoundsException);
          throw localZzc;
        }
        catch (zzexr localZzexr1)
        {
          zzons -= position - k;
          position = k;
          throw localZzexr1;
        }
        return;
      }
      catch (zzexr localZzexr2)
      {
        warn(paramString, localZzexr2);
      }
    }
  }
}
