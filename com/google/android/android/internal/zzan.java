package com.google.android.android.internal;

import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

public abstract interface zzan
{
  public abstract HttpResponse performRequest(Request paramRequest, Map paramMap)
    throws IOException, AtomicBoolean;
}
