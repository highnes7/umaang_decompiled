package com.google.android.android.internal;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;

public final class zzal
  extends HttpEntityEnclosingRequestBase
{
  public zzal() {}
  
  public zzal(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public final String getMethod()
  {
    return "PATCH";
  }
}
