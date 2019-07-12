package com.google.android.android.internal;

import com.google.android.gms.internal.zzp;
import com.google.android.gms.internal.zzv;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class zzar
  extends zzp<String>
{
  public final zzv<String> zzce;
  
  public zzar(int paramInt, String paramString, Response.Listener paramListener, Marker paramMarker)
  {
    super(paramInt, paramString, paramMarker);
    zzce = paramListener;
  }
  
  public final Response parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    Object localObject = data;
    Map localMap = headers;
    try
    {
      localObject = new String((byte[])localObject, zzam.parseCharset(localMap));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
    localObject = new String(data);
    return new Response(localObject, zzam.parseCacheHeaders(paramNetworkResponse));
  }
}
