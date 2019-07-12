package com.google.android.android.internal;

public final class Response<T>
{
  public final T result;
  public final Cache.Entry zzbe;
  public final zzaa zzbf;
  public boolean zzbg = false;
  
  public Response(zzaa paramZzaa)
  {
    result = null;
    zzbe = null;
    zzbf = paramZzaa;
  }
  
  public Response(Object paramObject, Cache.Entry paramEntry)
  {
    result = paramObject;
    zzbe = paramEntry;
    zzbf = null;
  }
  
  public static Response getResponse(zzaa paramZzaa)
  {
    return new Response(paramZzaa);
  }
  
  public static Response success(Object paramObject, Cache.Entry paramEntry)
  {
    return new Response(paramObject, paramEntry);
  }
}
