package com.google.android.android.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.google.android.android.internal.zzbl;
import com.google.android.android.internal.zzdbo;
import com.google.android.android.internal.zzdbs;
import com.google.android.android.internal.zzdbw;
import com.google.android.android.internal.zzeym;
import com.google.android.android.internal.zzeyn;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

public final class zzey
  implements zzah
{
  public final Context mContext;
  public final ExecutorService zzisa;
  public final String zzjoz;
  public com.google.android.gms.tagmanager.zzdi<com.google.android.gms.internal.zzdbm> zzjty;
  
  public zzey(Context paramContext, String paramString)
  {
    mContext = paramContext;
    zzjoz = paramString;
    zzisa = Executors.newSingleThreadExecutor();
  }
  
  public static zzdbs readFromStream(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      paramByteArrayOutputStream = zzdb.zzlv(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      for (;;) {}
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
    return null;
    zzdj.zzjss.zzca("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
    return null;
  }
  
  public static zzdbs uncompress(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new zzbl();
      int i = paramArrayOfByte.length;
      zzeyn.decrypt((zzeyn)localObject, paramArrayOfByte, 0, i);
      paramArrayOfByte = zzdbo.getPreferences((zzbl)localObject);
      localObject = zzdj.zzjss;
      ((zzdk)localObject).append("The container was successfully loaded from the resource (using binary file)");
      return paramArrayOfByte;
    }
    catch (zzeym paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (zzdbw paramArrayOfByte)
    {
      for (;;) {}
    }
    zzdj.zzjss.zzcr("The resource file is invalid. The container from the binary file is invalid");
    return null;
    zzdj.zzjss.get("The resource file is corrupted. The container cannot be extracted from the binary file");
    return null;
  }
  
  private final File zzben()
  {
    String str = String.valueOf(zzjoz);
    if (str.length() != 0) {
      str = "resource_".concat(str);
    } else {
      str = new String("resource_");
    }
    return new File(mContext.getDir("google_tagmanager", 0), str);
  }
  
  public final void addPauseListener(zzdi paramZzdi)
  {
    zzjty = paramZzdi;
  }
  
  /* Error */
  public final boolean deleteAccount(com.google.android.android.internal.zzdbm paramZzdbm)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 151	com/google/android/android/tagmanager/zzey:zzben	()Ljava/io/File;
    //   4: astore_3
    //   5: new 153	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 160	com/google/android/android/internal/zzeyn:toByteArray	(Lcom/google/android/android/internal/zzeyn;)[B
    //   19: invokevirtual 164	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 167	java/io/FileOutputStream:close	()V
    //   26: goto +13 -> 39
    //   29: getstatic 59	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   32: ldc -87
    //   34: invokeinterface 67 2 0
    //   39: iconst_1
    //   40: ireturn
    //   41: getstatic 59	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   44: ldc -85
    //   46: invokeinterface 67 2 0
    //   51: aload_3
    //   52: invokevirtual 175	java/io/File:delete	()Z
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual 167	java/io/FileOutputStream:close	()V
    //   60: iconst_0
    //   61: ireturn
    //   62: getstatic 59	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   65: ldc -87
    //   67: invokeinterface 67 2 0
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 167	java/io/FileOutputStream:close	()V
    //   79: goto +13 -> 92
    //   82: getstatic 59	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   85: ldc -87
    //   87: invokeinterface 67 2 0
    //   92: aload_1
    //   93: athrow
    //   94: getstatic 59	com/google/android/android/tagmanager/zzdj:zzjss	Lcom/google/android/android/tagmanager/zzdk;
    //   97: ldc -79
    //   99: invokeinterface 105 2 0
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: goto -13 -> 94
    //   110: astore_1
    //   111: goto -70 -> 41
    //   114: astore_1
    //   115: goto -86 -> 29
    //   118: astore_1
    //   119: goto -57 -> 62
    //   122: astore_2
    //   123: goto -41 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	zzey
    //   0	126	1	paramZzdbm	com.google.android.android.internal.zzdbm
    //   13	63	2	localFileOutputStream	java.io.FileOutputStream
    //   122	1	2	localIOException	IOException
    //   4	48	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   14	22	74	java/lang/Throwable
    //   41	56	74	java/lang/Throwable
    //   5	14	106	java/io/FileNotFoundException
    //   14	22	110	java/io/IOException
    //   22	26	114	java/io/IOException
    //   56	60	118	java/io/IOException
    //   75	79	122	java/io/IOException
  }
  
  public final void loadMapTileAsync(com.google.android.android.internal.zzdbm paramZzdbm)
  {
    zzisa.execute(new zzfa(this, paramZzdbm));
  }
  
  public final void release()
  {
    try
    {
      zzisa.shutdown();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzbcw()
  {
    zzisa.execute(new zzez(this));
  }
  
  public final void zzbem()
  {
    Object localObject2 = zzjty;
    Object localObject1 = this;
    if (localObject2 != null)
    {
      zzdj.zzjss.append("Attempting to load resource from disk");
      if (((zzei.zzbeh().zzbei() != zzei.zza.zzjtn) && (zzei.zzbeh().zzbei() != zzei.zza.zzjto)) || (!zzjoz.equals(zzei.zzbeh().getContainerId()))) {}
    }
    for (;;)
    {
      zzjty.zzed(zzda.zzjsk);
      return;
      try
      {
        localObject2 = new FileInputStream(((zzey)localObject1).zzben());
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        try
        {
          Object localObject3 = new ByteArrayOutputStream();
          zzdbo.copyFile((InputStream)localObject2, (OutputStream)localObject3);
          localObject3 = ((ByteArrayOutputStream)localObject3).toByteArray();
          Object localObject4 = new com.google.android.android.internal.zzdbm();
          zzeyn.sign((zzeyn)localObject4, (byte[])localObject3);
          localObject3 = (com.google.android.android.internal.zzdbm)localObject4;
          localObject4 = zzxx;
          if (localObject4 == null)
          {
            localObject4 = zzkfk;
            if (localObject4 == null)
            {
              localObject1 = new IllegalArgumentException("Resource and SupplementedResource are NULL.");
              throw ((Throwable)localObject1);
            }
          }
          localObject1 = zzjty;
          ((zzdi)localObject1).onSuccess(localObject3);
          for (;;)
          {
            try
            {
              ((FileInputStream)localObject2).close();
            }
            catch (IOException localIOException2)
            {
              IllegalStateException localIllegalStateException;
              continue;
            }
            zzdj.zzjss.zzcr("Error closing stream for reading resource from disk");
            continue;
            zzjty.zzed(zzda.zzjsl);
            zzdj.zzjss.zzcr("Failed to read the resource from disk. The resource is inconsistent");
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            break;
            zzjty.zzed(zzda.zzjsl);
            zzdj.zzjss.zzcr("Failed to read the resource from disk");
            continue;
            zzdj.zzjss.append("The Disk resource was successfully read.");
            return;
          }
          try
          {
            ((FileInputStream)localObject2).close();
          }
          catch (IOException localIOException3)
          {
            for (;;) {}
          }
          zzdj.zzjss.zzcr("Error closing stream for reading resource from disk");
          throw localThrowable;
          for (;;)
          {
            zzdj.zzjss.zzca("Failed to find the resource in the disk");
            break;
            localIllegalStateException = new IllegalStateException("Callback must be set before execute");
            throw localIllegalStateException;
            localFileNotFoundException = localFileNotFoundException;
          }
        }
        catch (IOException localIOException1)
        {
          for (;;) {}
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public final zzdbs zzee(int paramInt)
  {
    Object localObject1 = mContext;
    for (;;)
    {
      try
      {
        localObject1 = ((Context)localObject1).getResources().openRawResource(paramInt);
        localObject2 = mContext.getResources().getResourceName(paramInt);
        StringBuilder localStringBuilder = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject2, 66));
        localStringBuilder.append("Attempting to load a container from the resource ID ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" (");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(")");
        localObject2 = localStringBuilder.toString();
        zzdj.zzjss.append((String)localObject2);
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Object localObject2;
        continue;
      }
      try
      {
        localObject2 = new ByteArrayOutputStream();
        zzdbo.copyFile((InputStream)localObject1, (OutputStream)localObject2);
        localObject1 = readFromStream((ByteArrayOutputStream)localObject2);
        if (localObject1 != null)
        {
          localObject2 = zzdj.zzjss;
          ((zzdk)localObject2).append("The container was successfully loaded from the resource (using JSON file format)");
          return localObject1;
        }
        localObject1 = uncompress(((ByteArrayOutputStream)localObject2).toByteArray());
        return localObject1;
      }
      catch (IOException localIOException) {}
    }
    localObject1 = mContext.getResources().getResourceName(paramInt);
    localObject2 = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject1, 67));
    ((StringBuilder)localObject2).append("Error reading the default container with resource ID ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" (");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    for (localObject1 = ((StringBuilder)localObject2).toString();; localObject1 = f.sufficientlysecure.rootcommands.util.StringBuilder.add(98, "Failed to load the container. No default container resource found with the resource ID ", paramInt))
    {
      zzdj.zzjss.zzcr((String)localObject1);
      return null;
    }
  }
}
