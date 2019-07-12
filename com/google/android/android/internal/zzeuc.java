package com.google.android.android.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public abstract class zzeuc<MessageType extends com.google.android.gms.internal.zzeuc<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.zzeud<MessageType, BuilderType>>
  implements com.google.android.gms.internal.zzewl
{
  public static boolean zzoms;
  public int zzomr = 0;
  
  public zzeuc() {}
  
  public static void populateMap(Iterable paramIterable, List paramList)
  {
    zzeud.transform(paramIterable, paramList);
  }
  
  public final byte[] toByteArray()
  {
    try
    {
      i = zzhi();
      byte[] arrayOfByte = new byte[i];
      localObject = zzeuy.zzbc(arrayOfByte);
      writeTo((zzeuy)localObject);
      ((zzeuy)localObject).zzctn();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      Object localObject = getClass().getName();
      int i = ((String)localObject).length();
      StringBuilder localStringBuilder = new StringBuilder("byte array".length() + (i + 62));
      localStringBuilder.append("Serializing ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("byte array");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public final zzeuk toByteString()
  {
    try
    {
      Object localObject = zzeuk.zzjj(zzhi());
      writeTo(((zzeup)localObject).zzcsm());
      localObject = ((zzeup)localObject).zzcsl();
      return localObject;
    }
    catch (IOException localIOException)
    {
      String str = getClass().getName();
      int i = str.length();
      StringBuilder localStringBuilder = new StringBuilder("ByteString".length() + (i + 62));
      localStringBuilder.append("Serializing ");
      localStringBuilder.append(str);
      localStringBuilder.append(" to a ");
      localStringBuilder.append("ByteString");
      localStringBuilder.append(" threw an IOException (should never happen).");
      throw new RuntimeException(localStringBuilder.toString(), localIOException);
    }
  }
  
  public final void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = zzeuy.buffer(paramOutputStream, zzeuy.zzjw(zzhi()));
    writeTo(paramOutputStream);
    paramOutputStream.flush();
  }
}
