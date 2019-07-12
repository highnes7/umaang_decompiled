package com.google.android.android.internal;

import java.io.IOException;

public class zzeur
  extends zzeuq
{
  public final byte[] bytes;
  
  public zzeur(byte[] paramArrayOfByte)
  {
    bytes = paramArrayOfByte;
  }
  
  public final boolean compareTo(zzeuk paramZzeuk, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramZzeuk.size())
    {
      int i = paramInt1 + paramInt2;
      if (i <= paramZzeuk.size())
      {
        if ((paramZzeuk instanceof zzeur))
        {
          paramZzeuk = (zzeur)paramZzeuk;
          byte[] arrayOfByte1 = bytes;
          byte[] arrayOfByte2 = bytes;
          int j = zzcsk();
          i = zzcsk();
          paramInt1 = paramZzeuk.zzcsk() + paramInt1;
          while (i < j + paramInt2)
          {
            if (arrayOfByte1[i] != arrayOfByte2[paramInt1]) {
              return false;
            }
            i += 1;
            paramInt1 += 1;
          }
          return true;
        }
        return paramZzeuk.multiply(paramInt1, i).equals(multiply(0, paramInt2));
      }
      i = paramZzeuk.size();
      paramZzeuk = new StringBuilder(59);
      paramZzeuk.append("Ran off end of other: ");
      paramZzeuk.append(paramInt1);
      paramZzeuk.append(", ");
      paramZzeuk.append(paramInt2);
      paramZzeuk.append(", ");
      paramZzeuk.append(i);
      throw new IllegalArgumentException(paramZzeuk.toString());
    }
    paramInt1 = size();
    paramZzeuk = new StringBuilder(40);
    paramZzeuk.append("Length too large: ");
    paramZzeuk.append(paramInt2);
    paramZzeuk.append(paramInt1);
    paramZzeuk = new IllegalArgumentException(paramZzeuk.toString());
    throw paramZzeuk;
  }
  
  public final void decrypt(zzeuj paramZzeuj)
    throws IOException
  {
    paramZzeuj.processBytes(bytes, zzcsk(), size());
  }
  
  public void ensureCapacity(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zzeuk)) {
      return false;
    }
    if (size() != ((zzeuk)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof zzeur))
    {
      paramObject = (zzeur)paramObject;
      int i = zzcsj();
      int j = paramObject.zzcsj();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return compareTo(paramObject, 0, size());
    }
    return paramObject.equals(this);
  }
  
  public final int hash(int paramInt1, int paramInt2, int paramInt3)
  {
    return zzevu.hashCode(paramInt1, bytes, zzcsk() + paramInt2, paramInt3);
  }
  
  public final zzeuk multiply(int paramInt1, int paramInt2)
  {
    paramInt2 = zzeuk.add(paramInt1, paramInt2, size());
    if (paramInt2 == 0) {
      return zzeuk.zzomx;
    }
    return new zzeun(bytes, zzcsk() + paramInt1, paramInt2);
  }
  
  public int size()
  {
    return bytes.length;
  }
  
  public final zzeut zzcsg()
  {
    return zzeut.append(bytes, zzcsk(), size(), true);
  }
  
  public int zzcsk()
  {
    return 0;
  }
  
  public byte zzji(int paramInt)
  {
    return bytes[paramInt];
  }
}
