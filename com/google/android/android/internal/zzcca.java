package com.google.android.android.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public final class zzcca
  extends zzcdu
{
  public zzcca(zzccw paramZzccw)
  {
    super(paramZzccw);
  }
  
  public static byte[] sendRequest(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    InputStream localInputStream = null;
    Object localObject = localInputStream;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = localInputStream;
      localInputStream = paramHttpURLConnection.getInputStream();
      paramHttpURLConnection = localInputStream;
      localObject = paramHttpURLConnection;
      byte[] arrayOfByte = new byte['?'];
      for (;;)
      {
        localObject = paramHttpURLConnection;
        int i = localInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = paramHttpURLConnection;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localObject = paramHttpURLConnection;
      paramHttpURLConnection = localByteArrayOutputStream.toByteArray();
      localInputStream.close();
      return paramHttpURLConnection;
    }
    catch (Throwable paramHttpURLConnection)
    {
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
      throw paramHttpURLConnection;
    }
  }
  
  public final void zzatu()
  {
    zzccw.zzatu();
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public final void zzatv()
  {
    zzcax.zzawk();
  }
  
  public final void zzuk() {}
  
  public final boolean zzyx()
  {
    zzwk();
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    localObject = null;
    return (localObject != null) && (((NetworkInfo)localObject).isConnected());
  }
}
