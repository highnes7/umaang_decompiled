package com.google.android.android.tagmanager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract interface zzfy
{
  public abstract HttpURLConnection createConnection(URL paramURL)
    throws IOException;
}
