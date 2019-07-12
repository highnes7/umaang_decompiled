package f.libs.asm.menu;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l.a.a.a.Log;
import l.a.a.a.a.b.ClassWriter;
import l.a.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  public static final String PREFS_NAME = "user";
  public static final String a = "userName";
  public static final String b = "userId";
  public static final String c = "keys";
  public static final Charset d = Charset.forName("UTF-8");
  public static final String e = ".meta";
  public static final String g = "userEmail";
  public final File f;
  
  public g(File paramFile)
  {
    f = paramFile;
  }
  
  public static String getId(Item paramItem)
    throws JSONException
  {
    return new GridView(paramItem).toString();
  }
  
  public static String getId(Map paramMap)
    throws JSONException
  {
    return new JSONObject(paramMap).toString();
  }
  
  public static Item getTitle(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    boolean bool = localJSONObject.isNull("userId");
    String str2 = null;
    if (!bool) {
      paramString = localJSONObject.optString("userId", null);
    } else {
      paramString = null;
    }
    String str1;
    if (!localJSONObject.isNull("userName")) {
      str1 = localJSONObject.optString("userName", null);
    } else {
      str1 = null;
    }
    if (!localJSONObject.isNull("userEmail")) {
      str2 = localJSONObject.optString("userEmail", null);
    }
    return new Item(paramString, str1, str2);
  }
  
  public static String optString(JSONObject paramJSONObject, String paramString)
  {
    if (!paramJSONObject.isNull(paramString)) {
      return paramJSONObject.optString(paramString, null);
    }
    return null;
  }
  
  public static Map toString(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      boolean bool = localJSONObject.isNull(str);
      paramString = null;
      if (!bool) {
        paramString = localJSONObject.optString(str, null);
      }
      localHashMap.put(str, paramString);
    }
    return localHashMap;
  }
  
  public Item a(String paramString)
  {
    Object localObject1 = c(paramString);
    if (!((File)localObject1).exists()) {
      return Item.g;
    }
    Object localObject3 = null;
    paramString = null;
    Object localObject2;
    try
    {
      localObject1 = new FileInputStream((File)localObject1);
      try
      {
        paramString = getTitle(ClassWriter.get((InputStream)localObject1));
        ClassWriter.close((Closeable)localObject1, "Failed to close user metadata file.");
        return paramString;
      }
      catch (Throwable localThrowable2)
      {
        paramString = (String)localObject1;
        localObject1 = localThrowable2;
        break label92;
      }
      catch (Exception localException1) {}
      paramString = localObject2;
    }
    catch (Throwable localThrowable1) {}catch (Exception localException2)
    {
      localObject2 = localObject3;
    }
    f.get().d("CrashlyticsCore", "Error deserializing user metadata.", localException2);
    ClassWriter.close(localObject2, "Failed to close user metadata file.");
    return Item.g;
    label92:
    ClassWriter.close(paramString, "Failed to close user metadata file.");
    throw localObject2;
  }
  
  public void a(String paramString, Item paramItem)
  {
    Object localObject3 = c(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    paramString = localObject1;
    try
    {
      String str = getId(paramItem);
      paramString = localObject1;
      paramItem = new FileOutputStream((File)localObject3);
      localObject3 = d;
      paramString = localObject1;
      paramItem = new BufferedWriter(new OutputStreamWriter(paramItem, (Charset)localObject3));
      try
      {
        paramItem.write(str);
        paramItem.flush();
        ClassWriter.close(paramItem, "Failed to close user metadata file.");
        return;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramItem;
        paramItem = localThrowable;
        break label116;
      }
      catch (Exception localException1) {}
      paramString = paramItem;
    }
    catch (Throwable paramItem) {}catch (Exception localException2)
    {
      paramItem = localObject2;
    }
    f.get().d("CrashlyticsCore", "Error serializing user metadata.", localException2);
    ClassWriter.close(paramItem, "Failed to close user metadata file.");
    return;
    label116:
    ClassWriter.close(paramString, "Failed to close user metadata file.");
    throw paramItem;
  }
  
  public void a(String paramString, Map paramMap)
  {
    Object localObject3 = d(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    paramString = localObject1;
    try
    {
      String str = getId(paramMap);
      paramString = localObject1;
      paramMap = new FileOutputStream((File)localObject3);
      localObject3 = d;
      paramString = localObject1;
      paramMap = new BufferedWriter(new OutputStreamWriter(paramMap, (Charset)localObject3));
      try
      {
        paramMap.write(str);
        paramMap.flush();
        ClassWriter.close(paramMap, "Failed to close key/value metadata file.");
        return;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramMap;
        paramMap = localThrowable;
        break label116;
      }
      catch (Exception localException1) {}
      paramString = paramMap;
    }
    catch (Throwable paramMap) {}catch (Exception localException2)
    {
      paramMap = localObject2;
    }
    f.get().d("CrashlyticsCore", "Error serializing key/value metadata.", localException2);
    ClassWriter.close(paramMap, "Failed to close key/value metadata file.");
    return;
    label116:
    ClassWriter.close(paramString, "Failed to close key/value metadata file.");
    throw paramMap;
  }
  
  public Map build(String paramString)
  {
    Object localObject1 = d(paramString);
    if (!((File)localObject1).exists()) {
      return Collections.emptyMap();
    }
    Object localObject3 = null;
    paramString = null;
    Object localObject2;
    try
    {
      localObject1 = new FileInputStream((File)localObject1);
      try
      {
        paramString = toString(ClassWriter.get((InputStream)localObject1));
        ClassWriter.close((Closeable)localObject1, "Failed to close user metadata file.");
        return paramString;
      }
      catch (Throwable localThrowable2)
      {
        paramString = (String)localObject1;
        localObject1 = localThrowable2;
        break label92;
      }
      catch (Exception localException1) {}
      paramString = localObject2;
    }
    catch (Throwable localThrowable1) {}catch (Exception localException2)
    {
      localObject2 = localObject3;
    }
    f.get().d("CrashlyticsCore", "Error deserializing user metadata.", localException2);
    ClassWriter.close(localObject2, "Failed to close user metadata file.");
    return Collections.emptyMap();
    label92:
    ClassWriter.close(paramString, "Failed to close user metadata file.");
    throw localObject2;
  }
  
  public File c(String paramString)
  {
    return new File(f, StringBuilder.append(paramString, "user", ".meta"));
  }
  
  public File d(String paramString)
  {
    return new File(f, StringBuilder.append(paramString, "keys", ".meta"));
  }
}
