package com.google.android.android.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.android.wifi.identifier.AdvertisingIdClient;
import com.google.android.android.wifi.identifier.AdvertisingIdClient.Info;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public final class zzami
  extends zzams
{
  public static boolean zzdnp;
  public AdvertisingIdClient.Info zzdnq;
  public final zzaoz zzdnr;
  public String zzdns;
  public boolean zzdnt = false;
  public final Object zzdnu = new Object();
  
  public zzami(zzamu paramZzamu)
  {
    super(paramZzamu);
    zzdnr = new zzaoz(paramZzamu.zzvx());
  }
  
  private final boolean calculate(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    String str3 = null;
    if (paramInfo2 == null) {
      paramInfo2 = null;
    } else {
      paramInfo2 = paramInfo2.getId();
    }
    if (TextUtils.isEmpty(paramInfo2)) {
      return true;
    }
    String str2 = zzwg().zzxp();
    String str1 = str2;
    Object localObject = zzdnu;
    try
    {
      if (!zzdnt)
      {
        zzdns = zzvq();
        zzdnt = true;
      }
      else if (TextUtils.isEmpty(zzdns))
      {
        if (paramInfo1 == null) {
          paramInfo1 = str3;
        } else {
          paramInfo1 = paramInfo1.getId();
        }
        if (paramInfo1 == null)
        {
          paramInfo1 = String.valueOf(paramInfo2);
          paramInfo2 = String.valueOf(str2);
          if (paramInfo2.length() != 0) {
            paramInfo1 = paramInfo1.concat(paramInfo2);
          } else {
            paramInfo1 = new String(paramInfo1);
          }
          bool = zzdl(paramInfo1);
          return bool;
        }
        str3 = String.valueOf(str2);
        if (str3.length() != 0) {
          paramInfo1 = paramInfo1.concat(str3);
        } else {
          paramInfo1 = new String(paramInfo1);
        }
        zzdns = zzdk(paramInfo1);
      }
      paramInfo1 = String.valueOf(paramInfo2);
      str2 = String.valueOf(str2);
      if (str2.length() != 0) {
        paramInfo1 = paramInfo1.concat(str2);
      } else {
        paramInfo1 = new String(paramInfo1);
      }
      paramInfo1 = zzdk(paramInfo1);
      if (TextUtils.isEmpty(paramInfo1)) {
        return false;
      }
      if (paramInfo1.equals(zzdns)) {
        return true;
      }
      paramInfo1 = str1;
      if (!TextUtils.isEmpty(zzdns))
      {
        zzdm("Resetting the client id because Advertising Id changed.");
        str1 = zzwg().zzxq();
        paramInfo1 = str1;
        d("New client Id", str1);
      }
      paramInfo2 = String.valueOf(paramInfo2);
      paramInfo1 = String.valueOf(paramInfo1);
      if (paramInfo1.length() != 0) {
        paramInfo1 = paramInfo2.concat(paramInfo1);
      } else {
        paramInfo1 = new String(paramInfo2);
      }
      boolean bool = zzdl(paramInfo1);
      return bool;
    }
    catch (Throwable paramInfo1)
    {
      throw paramInfo1;
    }
  }
  
  public static String zzdk(String paramString)
  {
    MessageDigest localMessageDigest = zzapd.zzec("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
  
  private final boolean zzdl(String paramString)
  {
    try
    {
      paramString = zzdk(paramString);
      zzdm("Storing hashed adid.");
      FileOutputStream localFileOutputStream = getContext().openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      zzdns = paramString;
      return true;
    }
    catch (IOException paramString)
    {
      toString("Error creating hash file", paramString);
    }
    return false;
  }
  
  private final AdvertisingIdClient.Info zzvo()
  {
    try
    {
      if (zzdnr.calculate(1000L))
      {
        zzdnr.start();
        AdvertisingIdClient.Info localInfo2 = zzvp();
        localInfo1 = localInfo2;
        if (calculate(zzdnq, localInfo2)) {}
        for (;;)
        {
          zzdnq = localInfo1;
          break;
          zzdq("Failed to reset client id on adid change. Not using adid");
          localInfo1 = new AdvertisingIdClient.Info("", false);
        }
      }
      AdvertisingIdClient.Info localInfo1 = zzdnq;
      return localInfo1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  private final AdvertisingIdClient.Info zzvp()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      return localInfo;
    }
    catch (Throwable localThrowable)
    {
      if (!zzdnp)
      {
        zzdnp = true;
        append("Error getting advertiser id", localThrowable);
        break label37;
        zzdp("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      }
      return null;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label37:
      for (;;) {}
    }
  }
  
  /* Error */
  private final String zzvq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 159	com/google/android/android/internal/zzamr:getContext	()Landroid/content/Context;
    //   6: ldc -95
    //   8: invokevirtual 234	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore 5
    //   13: sipush 128
    //   16: newarray byte
    //   18: astore 4
    //   20: aload 5
    //   22: aload 4
    //   24: iconst_0
    //   25: sipush 128
    //   28: invokevirtual 240	java/io/FileInputStream:read	([BII)I
    //   31: istore_1
    //   32: aload 5
    //   34: invokevirtual 243	java/io/FileInputStream:available	()I
    //   37: istore_2
    //   38: iload_2
    //   39: ifle +26 -> 65
    //   42: aload_0
    //   43: ldc -11
    //   45: invokevirtual 228	com/google/android/android/internal/zzamr:zzdp	(Ljava/lang/String;)V
    //   48: aload 5
    //   50: invokevirtual 246	java/io/FileInputStream:close	()V
    //   53: aload_0
    //   54: invokevirtual 159	com/google/android/android/internal/zzamr:getContext	()Landroid/content/Context;
    //   57: ldc -95
    //   59: invokevirtual 249	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   62: pop
    //   63: aconst_null
    //   64: areturn
    //   65: iload_1
    //   66: ifgt +16 -> 82
    //   69: aload_0
    //   70: ldc -5
    //   72: invokevirtual 107	com/google/android/android/internal/zzamr:zzdm	(Ljava/lang/String;)V
    //   75: aload 5
    //   77: invokevirtual 246	java/io/FileInputStream:close	()V
    //   80: aconst_null
    //   81: areturn
    //   82: new 76	java/lang/String
    //   85: dup
    //   86: aload 4
    //   88: iconst_0
    //   89: iload_1
    //   90: invokespecial 254	java/lang/String:<init>	([BII)V
    //   93: astore 4
    //   95: aload 5
    //   97: invokevirtual 246	java/io/FileInputStream:close	()V
    //   100: aload 4
    //   102: areturn
    //   103: astore 5
    //   105: aload 4
    //   107: astore_3
    //   108: aload 5
    //   110: astore 4
    //   112: goto +5 -> 117
    //   115: astore 4
    //   117: aload_0
    //   118: ldc_w 256
    //   121: aload 4
    //   123: invokevirtual 223	com/google/android/android/internal/zzamr:append	(Ljava/lang/String;Ljava/lang/Object;)V
    //   126: aload_0
    //   127: invokevirtual 159	com/google/android/android/internal/zzamr:getContext	()Landroid/content/Context;
    //   130: ldc -95
    //   132: invokevirtual 249	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   135: pop
    //   136: aload_3
    //   137: areturn
    //   138: astore_3
    //   139: aconst_null
    //   140: areturn
    //   141: astore_3
    //   142: aload 4
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	zzami
    //   31	59	1	i	int
    //   37	2	2	j	int
    //   1	136	3	localObject1	Object
    //   138	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   141	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   18	93	4	localObject2	Object
    //   115	28	4	localIOException1	IOException
    //   11	85	5	localFileInputStream	java.io.FileInputStream
    //   103	6	5	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   95	100	103	java/io/IOException
    //   2	13	115	java/io/IOException
    //   20	38	115	java/io/IOException
    //   42	63	115	java/io/IOException
    //   69	80	115	java/io/IOException
    //   82	95	115	java/io/IOException
    //   2	13	138	java/io/FileNotFoundException
    //   20	38	138	java/io/FileNotFoundException
    //   42	63	138	java/io/FileNotFoundException
    //   69	80	138	java/io/FileNotFoundException
    //   82	95	138	java/io/FileNotFoundException
    //   95	100	141	java/io/FileNotFoundException
  }
  
  public final void zzuk() {}
  
  public final boolean zzvg()
  {
    zzwk();
    AdvertisingIdClient.Info localInfo = zzvo();
    return (localInfo != null) && (!localInfo.isLimitAdTrackingEnabled());
  }
  
  public final String zzvn()
  {
    zzwk();
    Object localObject = zzvo();
    if (localObject != null) {
      localObject = ((AdvertisingIdClient.Info)localObject).getId();
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    return localObject;
  }
}
