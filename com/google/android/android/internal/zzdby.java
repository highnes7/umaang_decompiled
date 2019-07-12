package com.google.android.android.internal;

import com.google.android.android.tagmanager.zzdj;
import com.google.android.android.tagmanager.zzdk;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zzdby
  implements zzdbz
{
  public HttpURLConnection zzkdu;
  public InputStream zzkdv = null;
  
  public zzdby() {}
  
  public final void close()
  {
    HttpURLConnection localHttpURLConnection = zzkdu;
    if (zzkdv != null)
    {
      Object localObject = zzkdv;
      try
      {
        ((InputStream)localObject).close();
      }
      catch (IOException localIOException)
      {
        localObject = String.valueOf(localIOException.getMessage());
        if (((String)localObject).length() != 0) {
          localObject = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat((String)localObject);
        } else {
          localObject = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: ");
        }
        zzdj.zzjss.e((String)localObject, localIOException);
      }
    }
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
  }
  
  public final InputStream zznb(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setReadTimeout(20000);
    paramString.setConnectTimeout(20000);
    zzkdu = paramString;
    paramString = zzkdu;
    int i = paramString.getResponseCode();
    if (i == 200)
    {
      zzkdv = paramString.getInputStream();
      return zzkdv;
    }
    paramString = StringBuilder.add(25, "Bad response: ", i);
    if (i != 404)
    {
      if (i == 503) {
        throw new zzdcb(paramString);
      }
      throw new IOException(paramString);
    }
    throw new FileNotFoundException(paramString);
  }
}
