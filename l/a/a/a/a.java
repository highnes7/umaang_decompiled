package l.a.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.a.a.a.a.b.ClassWriter;

public class a
  implements Callable<Map<String, p>>
{
  public static final String e = "fabric-version";
  public static final String g = "fabric-build-type";
  public static final String l = "fabric-identifier";
  public static final String t = "fabric/";
  public final String s;
  
  public a(String paramString)
  {
    s = paramString;
  }
  
  private p get(ZipEntry paramZipEntry, ZipFile paramZipFile)
  {
    Object localObject1;
    try
    {
      Object localObject2 = paramZipFile.getInputStream(paramZipEntry);
      localObject1 = localObject2;
      paramZipFile = localObject1;
      try
      {
        Object localObject5 = new Properties();
        paramZipFile = localObject1;
        ((Properties)localObject5).load((InputStream)localObject2);
        paramZipFile = localObject1;
        localObject3 = ((Properties)localObject5).getProperty("fabric-identifier");
        paramZipFile = localObject1;
        localObject4 = ((Properties)localObject5).getProperty("fabric-version");
        paramZipFile = localObject1;
        localObject5 = ((Properties)localObject5).getProperty("fabric-build-type");
        paramZipFile = localObject1;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
        if (!bool)
        {
          paramZipFile = localObject1;
          bool = TextUtils.isEmpty((CharSequence)localObject4);
          if (!bool)
          {
            paramZipFile = localObject1;
            localObject3 = new p((String)localObject3, (String)localObject4, (String)localObject5);
            ClassWriter.close((Closeable)localObject2);
            return localObject3;
          }
        }
        paramZipFile = localObject1;
        localObject2 = new StringBuilder();
        paramZipFile = localObject1;
        ((StringBuilder)localObject2).append("Invalid format of fabric file,");
        paramZipFile = localObject1;
        ((StringBuilder)localObject2).append(paramZipEntry.getName());
        paramZipFile = localObject1;
        localObject2 = new IllegalStateException(((StringBuilder)localObject2).toString());
        paramZipFile = localObject1;
        throw ((Throwable)localObject2);
      }
      catch (Throwable paramZipEntry)
      {
        break label270;
      }
      catch (IOException localIOException1) {}
      paramZipFile = localObject1;
    }
    catch (Throwable paramZipEntry)
    {
      paramZipFile = null;
    }
    catch (IOException localIOException2)
    {
      localObject1 = null;
    }
    Object localObject3 = f.get();
    paramZipFile = localObject1;
    Object localObject4 = new StringBuilder();
    paramZipFile = localObject1;
    ((StringBuilder)localObject4).append("Error when parsing fabric properties ");
    paramZipFile = localObject1;
    ((StringBuilder)localObject4).append(paramZipEntry.getName());
    paramZipFile = localObject1;
    ((Log)localObject3).d("Fabric", ((StringBuilder)localObject4).toString(), localIOException2);
    ClassWriter.close(localObject1);
    return null;
    label270:
    ClassWriter.close(paramZipFile);
    throw paramZipEntry;
  }
  
  private Map getValue()
  {
    HashMap localHashMap = new HashMap();
    try
    {
      Class.forName("com.google.android.gms.ads.AdView");
      p localP = new p("com.google.firebase.firebase-ads", "0.0.0", "binary");
      localHashMap.put(localP.b(), localP);
      f.get().log("Fabric", "Found kit: com.google.firebase.firebase-ads");
      return localHashMap;
    }
    catch (Exception localException) {}
    return localHashMap;
  }
  
  private Map read()
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    ZipFile localZipFile = close();
    Enumeration localEnumeration = localZipFile.entries();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = (ZipEntry)localEnumeration.nextElement();
      if ((((ZipEntry)localObject).getName().startsWith("fabric/")) && (((ZipEntry)localObject).getName().length() > 7))
      {
        localObject = get((ZipEntry)localObject, localZipFile);
        if (localObject != null)
        {
          localHashMap.put(((p)localObject).b(), localObject);
          f.get().log("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[] { ((p)localObject).b(), ((p)localObject).c() }));
        }
      }
    }
    try
    {
      localZipFile.close();
      return localHashMap;
    }
    catch (IOException localIOException) {}
    return localHashMap;
  }
  
  public Map call()
    throws Exception
  {
    HashMap localHashMap = new HashMap();
    long l1 = SystemClock.elapsedRealtime();
    localHashMap.putAll(getValue());
    localHashMap.putAll(read());
    Log localLog = f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("finish scanning in ");
    localStringBuilder.append(SystemClock.elapsedRealtime() - l1);
    localLog.log("Fabric", localStringBuilder.toString());
    return localHashMap;
  }
  
  public ZipFile close()
    throws IOException
  {
    return new ZipFile(s);
  }
}
