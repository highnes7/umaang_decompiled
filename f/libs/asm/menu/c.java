package f.libs.asm.menu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import l.a.a.a.Log;
import l.a.a.a.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  public static final String a = "/data";
  public final Context c;
  public final aa d;
  
  public c(Context paramContext, aa paramAa)
  {
    c = paramContext;
    d = paramAa;
  }
  
  private File a(File paramFile)
  {
    int i = Build.VERSION.SDK_INT;
    if (paramFile.getAbsolutePath().startsWith("/data"))
    {
      Object localObject = c;
      try
      {
        localObject = ((Context)localObject).getPackageManager();
        Context localContext = c;
        localObject = ((PackageManager)localObject).getApplicationInfo(localContext.getPackageName(), 0);
        localObject = nativeLibraryDir;
        localObject = new File((String)localObject, paramFile.getName());
        return localObject;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        f.get().d("CrashlyticsCore", "Error getting ApplicationInfo", localNameNotFoundException);
      }
    }
    return paramFile;
  }
  
  private JSONArray a(BufferedReader paramBufferedReader)
    throws IOException
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      Object localObject = paramBufferedReader.readLine();
      if (localObject == null) {
        break;
      }
      localObject = a((String)localObject);
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  private JSONObject a(String paramString)
  {
    paramString = BarRenderer.a(paramString);
    if (paramString != null)
    {
      if (!a(paramString)) {
        return null;
      }
      Object localObject1 = b(b);
      Object localObject2 = d;
      try
      {
        localObject1 = ((aa)localObject2).a((File)localObject1);
        try
        {
          paramString = a((String)localObject1, paramString);
          return paramString;
        }
        catch (JSONException paramString)
        {
          f.get().log("CrashlyticsCore", "Could not create a binary image json string", paramString);
          return null;
        }
        StringBuilder localStringBuilder;
        return null;
      }
      catch (IOException localIOException)
      {
        localObject2 = f.get();
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Could not generate ID for file ");
        localStringBuilder.append(b);
        ((Log)localObject2).log("CrashlyticsCore", localStringBuilder.toString(), localIOException);
      }
    }
  }
  
  public static JSONObject a(String paramString, AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.get("base_address", i);
    localJSONObject.get("size", g);
    localJSONObject.put("name", b);
    localJSONObject.put("uuid", paramString);
    return localJSONObject;
  }
  
  public static boolean a(AppCompatDelegateImplV7.PanelFeatureState paramPanelFeatureState)
  {
    return (a.indexOf('x') != -1) && (b.indexOf('/') != -1);
  }
  
  public static byte[] add(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("binary_images", paramJSONArray);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException paramJSONArray)
    {
      f.get().w("CrashlyticsCore", "Binary images string is null", paramJSONArray);
    }
    return new byte[0];
  }
  
  private File b(String paramString)
  {
    File localFile = new File(paramString);
    paramString = localFile;
    if (!localFile.exists()) {
      paramString = a(localFile);
    }
    return paramString;
  }
  
  public static String normalize(JSONArray paramJSONArray)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localStringBuilder.append(paramJSONArray.getString(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private JSONArray parse(String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramString = normalize(new JSONObject(paramString).getJSONArray("maps"));
      paramString = paramString.split("\\|");
      int i = 0;
      while (i < paramString.length)
      {
        JSONObject localJSONObject = a(paramString[i]);
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
        i += 1;
      }
      return localJSONArray;
    }
    catch (JSONException paramString)
    {
      f.get().w("CrashlyticsCore", "Unable to parse proc maps string", paramString);
    }
    return localJSONArray;
  }
  
  public byte[] read(BufferedReader paramBufferedReader)
    throws IOException
  {
    return add(a(paramBufferedReader));
  }
  
  public byte[] read(String paramString)
    throws IOException
  {
    return add(parse(paramString));
  }
}
