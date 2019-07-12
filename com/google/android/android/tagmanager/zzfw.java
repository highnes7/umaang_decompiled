package com.google.android.android.tagmanager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zzfw
  implements zzfy
{
  public zzfw() {}
  
  public final HttpURLConnection createConnection(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
}
