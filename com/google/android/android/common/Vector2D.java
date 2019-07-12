package com.google.android.android.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.android.common.internal.zzas;
import com.google.android.android.common.internal.zzat;
import com.google.android.android.common.internal.zzbp;
import com.google.android.android.common.util.UriComponents;
import com.google.android.android.dynamic.IObjectWrapper;
import com.google.android.android.dynamic.Integer;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class Vector2D
  extends zzat
{
  public int zzffo;
  
  public Vector2D(byte[] paramArrayOfByte)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte.length != 25)
    {
      int i = paramArrayOfByte.length;
      int j = paramArrayOfByte.length;
      boolean bool = false;
      localObject = UriComponents.encode(paramArrayOfByte, 0, j, false);
      StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 51));
      localStringBuilder.append("Cert hash data has incorrect length (");
      localStringBuilder.append(i);
      localStringBuilder.append("):\n");
      localStringBuilder.append((String)localObject);
      Log.wtf("GoogleCertificates", localStringBuilder.toString(), new Exception());
      localObject = Arrays.copyOfRange(paramArrayOfByte, 0, 25);
      paramArrayOfByte = (byte[])localObject;
      if (localObject.length == 25) {
        bool = true;
      }
      i = localObject.length;
      localObject = new StringBuilder(55);
      ((StringBuilder)localObject).append("cert hash data has incorrect length. length=");
      ((StringBuilder)localObject).append(i);
      zzbp.get(bool, ((StringBuilder)localObject).toString());
      localObject = paramArrayOfByte;
    }
    zzffo = Arrays.hashCode((byte[])localObject);
  }
  
  public static byte[] zzfr(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof zzas)) {
        return false;
      }
      paramObject = (zzas)paramObject;
    }
    try
    {
      int i = paramObject.zzafa();
      int j = hashCode();
      if (i != j) {
        return false;
      }
      paramObject = paramObject.zzaez();
      if (paramObject == null) {
        return false;
      }
      paramObject = Integer.get(paramObject);
      paramObject = (byte[])paramObject;
      boolean bool = Arrays.equals(getBytes(), paramObject);
      return bool;
    }
    catch (RemoteException paramObject) {}
    return false;
    return false;
  }
  
  public abstract byte[] getBytes();
  
  public int hashCode()
  {
    return zzffo;
  }
  
  public final IObjectWrapper zzaez()
  {
    return new Integer(getBytes());
  }
  
  public final int zzafa()
  {
    return hashCode();
  }
}
