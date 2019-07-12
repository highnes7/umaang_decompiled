package com.google.android.android.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.android.common.internal.zzbf;
import com.google.android.android.common.internal.zzbp;
import java.util.Arrays;

public class Table
{
  public final DataHolder zzflf;
  public int zzfqh;
  public int zzfqi;
  
  public Table(DataHolder paramDataHolder, int paramInt)
  {
    zzbp.append(paramDataHolder);
    zzflf = ((DataHolder)paramDataHolder);
    zzbv(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Table))
    {
      paramObject = (Table)paramObject;
      if ((zzbf.equal(Integer.valueOf(zzfqh), Integer.valueOf(zzfqh))) && (zzbf.equal(Integer.valueOf(zzfqi), Integer.valueOf(zzfqi))) && (zzflf == zzflf)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean getBoolean(String paramString)
  {
    return zzflf.put(paramString, zzfqh, zzfqi);
  }
  
  public final byte[] getByteArray(String paramString)
  {
    return zzflf.get(paramString, zzfqh, zzfqi);
  }
  
  public final float getFloat(String paramString)
  {
    return zzflf.getFloat(paramString, zzfqh, zzfqi);
  }
  
  public final int getInteger(String paramString)
  {
    return zzflf.getInt(paramString, zzfqh, zzfqi);
  }
  
  public final long getLong(String paramString)
  {
    return zzflf.getLong(paramString, zzfqh, zzfqi);
  }
  
  public final String getString(String paramString)
  {
    return zzflf.getData(paramString, zzfqh, zzfqi);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(zzfqh), Integer.valueOf(zzfqi), zzflf });
  }
  
  public boolean isDataValid()
  {
    return !zzflf.isClosed();
  }
  
  public final void parse(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    zzflf.getData(paramString, zzfqh, zzfqi, paramCharArrayBuffer);
  }
  
  public final void zzbv(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < zzflf.zzfqq)) {
      bool = true;
    } else {
      bool = false;
    }
    zzbp.zzbg(bool);
    zzfqh = paramInt;
    zzfqi = zzflf.zzbx(zzfqh);
  }
  
  public final boolean zzfu(String paramString)
  {
    return zzflf.zzfu(paramString);
  }
  
  public final Uri zzfv(String paramString)
  {
    paramString = zzflf.getData(paramString, zzfqh, zzfqi);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  public final boolean zzfw(String paramString)
  {
    return zzflf.isNull(paramString, zzfqh, zzfqi);
  }
}
