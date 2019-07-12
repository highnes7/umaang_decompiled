package f.libs.asm.asm;

import android.os.Build.VERSION;
import f.c.a.a.X;
import java.io.IOException;
import java.util.Map;
import l.a.a.a.a.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  implements c<X>
{
  public static final String A = "predefinedType";
  public static final String DETAIL_ENTRY = "details";
  public static final String F = "appBundleId";
  public static final String I = "customAttributes";
  public static final String KEY_TIMESTAMP = "timestamp";
  public static final String a = "deviceModel";
  public static final String b = "predefinedAttributes";
  public static final String c = "appVersionName";
  public static final String d = "appVersionCode";
  public static final String e = "betaDeviceToken";
  public static final String f = "osVersion";
  public static final String g = "limitAdTrackingEnabled";
  public static final String i = "buildId";
  public static final String l = "installationId";
  public static final String mail = "type";
  public static final String t = "executionId";
  public static final String w = "customType";
  
  public h() {}
  
  public byte[] a(Label paramLabel)
    throws IOException
  {
    return export(paramLabel).toString().getBytes("UTF-8");
  }
  
  public JSONObject export(Label paramLabel)
    throws IOException
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      Object localObject1 = e;
      Object localObject2 = c;
      localJSONObject.put("appBundleId", localObject2);
      localObject2 = b;
      localJSONObject.put("executionId", localObject2);
      localObject2 = d;
      localJSONObject.put("installationId", localObject2);
      localObject2 = e;
      localJSONObject.put("limitAdTrackingEnabled", localObject2);
      localObject2 = a;
      localJSONObject.put("betaDeviceToken", localObject2);
      localObject2 = f;
      localJSONObject.put("buildId", localObject2);
      localObject2 = g;
      localJSONObject.put("osVersion", localObject2);
      localObject2 = h;
      localJSONObject.put("deviceModel", localObject2);
      localObject2 = k;
      localJSONObject.put("appVersionCode", localObject2);
      localObject1 = i;
      localJSONObject.put("appVersionName", localObject1);
      long l1 = g;
      localJSONObject.get("timestamp", l1);
      localObject1 = b;
      localJSONObject.put("type", ((Enum)localObject1).toString());
      localObject1 = d;
      if (localObject1 != null) {
        localJSONObject.put("details", new JSONObject((Map)localObject1));
      }
      localObject1 = f;
      localJSONObject.put("customType", localObject1);
      localObject1 = k;
      if (localObject1 != null) {
        localJSONObject.put("customAttributes", new JSONObject((Map)localObject1));
      }
      localObject1 = a;
      localJSONObject.put("predefinedType", localObject1);
      paramLabel = c;
      if (paramLabel != null)
      {
        localJSONObject.put("predefinedAttributes", new JSONObject(paramLabel));
        return localJSONObject;
      }
    }
    catch (JSONException paramLabel)
    {
      int j = Build.VERSION.SDK_INT;
      throw new IOException(paramLabel.getMessage(), paramLabel);
    }
    return localJSONObject;
  }
}
