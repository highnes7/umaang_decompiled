package com.google.android.android.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public final class zzad
  implements Network
{
  public static boolean DEBUG = zzab.DEBUG;
  public static int zzbm = 3000;
  public static int zzbn = 4096;
  public zzan zzbo;
  public zzae zzbp;
  
  public zzad(zzan paramZzan)
  {
    zzbo = paramZzan;
    zzbp = localZzae;
  }
  
  public zzad(zzan paramZzan, zzae paramZzae)
  {
    zzbo = paramZzan;
    zzbp = paramZzae;
  }
  
  public static void attemptRetryOnException(String paramString, Request paramRequest, zzaa paramZzaa)
    throws zzaa
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramZzaa);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (zzaa paramZzaa)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramZzaa;
    }
  }
  
  public static Map convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private final byte[] entityToBytes(HttpEntity paramHttpEntity)
    throws IOException, ByteArrayOutputStream
  {
    zzaq localZzaq = new zzaq(zzbp, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      byte[] arrayOfByte;
      try
      {
        InputStream localInputStream = paramHttpEntity.getContent();
        if (localInputStream != null)
        {
          localObject1 = localObject2;
          arrayOfByte = zzbp.getBuf(1024);
          localObject2 = arrayOfByte;
          localObject1 = localObject2;
          int i = localInputStream.read(arrayOfByte);
          if (i != -1)
          {
            localObject1 = localObject2;
            localZzaq.write(arrayOfByte, 0, i);
            continue;
          }
          localObject1 = localObject2;
          localObject2 = localZzaq.toByteArray();
        }
      }
      catch (Throwable localThrowable) {}
      try
      {
        paramHttpEntity.consumeContent();
      }
      catch (IOException paramHttpEntity) {}
    }
    zzab.v("Error occured when calling consumingContent", new Object[0]);
    zzbp.returnBuf(arrayOfByte);
    localZzaq.close();
    return localObject2;
    localObject1 = localObject2;
    throw new ByteArrayOutputStream();
    try
    {
      paramHttpEntity.consumeContent();
    }
    catch (IOException paramHttpEntity)
    {
      for (;;) {}
    }
    zzab.v("Error occured when calling consumingContent", new Object[0]);
    zzbp.returnBuf(localObject1);
    localZzaq.close();
    throw localThrowable;
  }
  
  public final NetworkResponse performRequest(Request paramRequest)
    throws zzaa
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a86 = a85\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
}
