package f.libs.asm.menu;

import java.io.File;
import l.a.a.a.Log;
import l.a.a.a.a.b.D;
import l.a.a.a.a.b.XYPlot;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.e.MathArrays.OrderDirection;
import l.a.a.a.f;

public class PagerSlidingTabStrip
  extends XYPlot
  implements j
{
  public static final String D = "crash_meta_file";
  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
  public static final String d = "binary_images_file";
  public static final String e = "os_meta_file";
  public static final String f = "logs_file";
  public static final String g = "user_meta_file";
  public static final String l = "report_id";
  public static final String p = "minidump_file";
  public static final String s = "session_meta_file";
  public static final String t = "app_meta_file";
  public static final String v = "keys_file";
  public static final String w = "device_meta_file";
  
  public PagerSlidingTabStrip(l.a.a.a.Item paramItem, String paramString1, String paramString2, LayoutManager paramLayoutManager)
  {
    super(paramItem, paramString1, paramString2, paramLayoutManager, MathArrays.OrderDirection.INCREASING);
  }
  
  private l.a.a.a.a.e.Item a(l.a.a.a.a.e.Item paramItem, p paramP)
  {
    paramItem.add("report_id", paramP.next());
    paramP = paramP.getValue();
    int j = paramP.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramP[i];
      if (localFile.getName().equals("minidump")) {
        paramItem.a("minidump_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("metadata")) {
        paramItem.a("crash_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("binaryImages")) {
        paramItem.a("binary_images_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("session")) {
        paramItem.a("session_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("app")) {
        paramItem.a("app_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("device")) {
        paramItem.a("device_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("os")) {
        paramItem.a("os_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("user")) {
        paramItem.a("user_meta_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("logs")) {
        paramItem.a("logs_file", localFile.getName(), "application/octet-stream", localFile);
      } else if (localFile.getName().equals("keys")) {
        paramItem.a("keys_file", localFile.getName(), "application/octet-stream", localFile);
      }
      i += 1;
    }
    return paramItem;
  }
  
  private l.a.a.a.a.e.Item a(l.a.a.a.a.e.Item paramItem, String paramString)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Crashlytics Android SDK/");
    localStringBuilder.append(o.c());
    paramItem.get("User-Agent", localStringBuilder.toString()).get("X-CRASHLYTICS-API-CLIENT-TYPE", "android").get("X-CRASHLYTICS-API-CLIENT-VERSION", o.c()).get("X-CRASHLYTICS-API-KEY", paramString);
    return paramItem;
  }
  
  public boolean a(Handle paramHandle)
  {
    Object localObject = d();
    a((l.a.a.a.a.e.Item)localObject, c);
    a((l.a.a.a.a.e.Item)localObject, b);
    paramHandle = f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Sending report to: ");
    localStringBuilder.append(a());
    paramHandle.d("CrashlyticsCore", localStringBuilder.toString());
    int i = ((l.a.a.a.a.e.Item)localObject).get();
    paramHandle = f.get();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Result was: ");
    ((StringBuilder)localObject).append(i);
    paramHandle.d("CrashlyticsCore", ((StringBuilder)localObject).toString());
    return D.a(i) == 0;
  }
}
