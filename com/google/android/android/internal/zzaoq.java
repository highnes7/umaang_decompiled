package com.google.android.android.internal;

import com.google.android.android.common.internal.zzbp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzaoq
{
  public int zzdtn;
  public ByteArrayOutputStream zzdto = new ByteArrayOutputStream();
  
  public zzaoq(zzaop paramZzaop) {}
  
  public final byte[] getPayload()
  {
    return zzdto.toByteArray();
  }
  
  public final boolean multiply(zzaoi paramZzaoi)
  {
    zzbp.append(paramZzaoi);
    if (zzdtn + 1 > zzanv.zzya()) {
      return false;
    }
    Object localObject = zzdtp.create(paramZzaoi, false);
    if (localObject == null)
    {
      zzdtp.zzvy().append(paramZzaoi, "Error formatting hit");
      return true;
    }
    localObject = ((String)localObject).getBytes();
    int j = localObject.length;
    if (j > zzanv.zzxw())
    {
      zzdtp.zzvy().append(paramZzaoi, "Hit size exceeds the maximum size limit");
      return true;
    }
    int i = j;
    if (zzdto.size() > 0) {
      i = j + 1;
    }
    if (zzdto.size() + i > ((Integer)zzaod.zzdrz.setDoOutput()).intValue()) {
      return false;
    }
    paramZzaoi = zzdto;
    try
    {
      i = paramZzaoi.size();
      if (i > 0)
      {
        paramZzaoi = zzdto;
        byte[] arrayOfByte = zzaop.zzdtm;
        paramZzaoi.write(arrayOfByte);
      }
      paramZzaoi = zzdto;
      paramZzaoi.write((byte[])localObject);
      zzdtn += 1;
      return true;
    }
    catch (IOException paramZzaoi)
    {
      zzdtp.toString("Failed to write payload when batching hits", paramZzaoi);
    }
    return true;
  }
  
  public final int zzza()
  {
    return zzdtn;
  }
}
