package com.google.android.android.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzai
{
  public String etag;
  public String key;
  public long lastModified;
  public Map<String, String> responseHeaders;
  public long serverDate;
  public long softTtl;
  public long ttl;
  public long zzbz;
  
  public zzai() {}
  
  public zzai(String paramString, Cache.Entry paramEntry)
  {
    key = paramString;
    zzbz = data.length;
    etag = etag;
    serverDate = serverDate;
    lastModified = lastModified;
    ttl = ttl;
    softTtl = softTtl;
    responseHeaders = responseHeaders;
  }
  
  public static zzai readHeader(InputStream paramInputStream)
    throws IOException
  {
    zzai localZzai = new zzai();
    if (zzag.readInt(paramInputStream) == 538247942)
    {
      key = zzag.readString(paramInputStream);
      etag = zzag.readString(paramInputStream);
      if (etag.equals("")) {
        etag = null;
      }
      serverDate = zzag.readLong(paramInputStream);
      lastModified = zzag.readLong(paramInputStream);
      ttl = zzag.readLong(paramInputStream);
      softTtl = zzag.readLong(paramInputStream);
      responseHeaders = zzag.readStringStringMap(paramInputStream);
      return localZzai;
    }
    throw new IOException();
  }
  
  public final boolean write(OutputStream paramOutputStream)
  {
    try
    {
      zzag.writeInt(paramOutputStream, 538247942);
      localObject1 = key;
      zzag.writeString(paramOutputStream, (String)localObject1);
      if (etag == null) {
        localObject1 = "";
      } else {
        localObject1 = etag;
      }
      zzag.writeString(paramOutputStream, (String)localObject1);
      long l = serverDate;
      zzag.writeLong(paramOutputStream, l);
      l = lastModified;
      zzag.writeLong(paramOutputStream, l);
      l = ttl;
      zzag.writeLong(paramOutputStream, l);
      l = softTtl;
      zzag.writeLong(paramOutputStream, l);
      localObject1 = responseHeaders;
      if (localObject1 != null)
      {
        zzag.writeInt(paramOutputStream, ((Map)localObject1).size());
        localObject1 = ((Map)localObject1).entrySet().iterator();
        for (;;)
        {
          boolean bool = ((Iterator)localObject1).hasNext();
          if (!bool) {
            break;
          }
          Object localObject2 = ((Iterator)localObject1).next();
          localObject2 = (Map.Entry)localObject2;
          Object localObject3 = ((Map.Entry)localObject2).getKey();
          localObject3 = (String)localObject3;
          zzag.writeString(paramOutputStream, (String)localObject3);
          localObject2 = ((Map.Entry)localObject2).getValue();
          localObject2 = (String)localObject2;
          zzag.writeString(paramOutputStream, (String)localObject2);
        }
      }
      zzag.writeInt(paramOutputStream, 0);
      paramOutputStream.flush();
      return true;
    }
    catch (IOException paramOutputStream)
    {
      paramOutputStream = paramOutputStream.toString();
      Object localObject1 = zzab.data;
      zzab.get("%s", new Object[] { paramOutputStream });
    }
    return false;
  }
}
