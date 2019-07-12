package com.google.android.android.internal;

import java.util.Map;

public final class NetworkResponse
{
  public final byte[] data;
  public final Map<String, String> headers;
  public final boolean notModified;
  public int statusCode;
  public long zzaa;
  
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map paramMap, boolean paramBoolean, long paramLong)
  {
    statusCode = paramInt;
    data = paramArrayOfByte;
    headers = paramMap;
    notModified = paramBoolean;
    zzaa = paramLong;
  }
  
  public NetworkResponse(byte[] paramArrayOfByte, Map paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}
