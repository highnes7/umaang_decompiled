package f.libs.asm.menu;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l.a.a.a.Log;
import l.a.a.a.a.b.D;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.e.MathArrays.OrderDirection;
import l.a.a.a.f;

public class XYPlot
  extends l.a.a.a.a.b.XYPlot
  implements j
{
  public static final String A = "report[file]";
  public static final String F = "report[identifier]";
  public static final String e = "report[file";
  public static final String i = "application/octet-stream";
  
  public XYPlot(l.a.a.a.Item paramItem, String paramString1, String paramString2, LayoutManager paramLayoutManager)
  {
    super(paramItem, paramString1, paramString2, paramLayoutManager, MathArrays.OrderDirection.INCREASING);
  }
  
  public XYPlot(l.a.a.a.Item paramItem, String paramString1, String paramString2, LayoutManager paramLayoutManager, MathArrays.OrderDirection paramOrderDirection)
  {
    super(paramItem, paramString1, paramString2, paramLayoutManager, paramOrderDirection);
  }
  
  private l.a.a.a.a.e.Item a(l.a.a.a.a.e.Item paramItem, Handle paramHandle)
  {
    paramItem = paramItem.get("X-CRASHLYTICS-API-KEY", c).get("X-CRASHLYTICS-API-CLIENT-TYPE", "android").get("X-CRASHLYTICS-API-CLIENT-VERSION", o.c());
    paramHandle = b.split().entrySet().iterator();
    while (paramHandle.hasNext()) {
      paramItem = paramItem.get((Map.Entry)paramHandle.next());
    }
    return paramItem;
  }
  
  private l.a.a.a.a.e.Item a(l.a.a.a.a.e.Item paramItem, p paramP)
  {
    paramItem.add("report[identifier]", paramP.next());
    StringBuilder localStringBuilder1;
    if (paramP.getValue().length == 1)
    {
      localObject1 = f.get();
      localStringBuilder1 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Adding single file ");
      localStringBuilder1.append(paramP.getFileName());
      localStringBuilder1.append(" to report ");
      localStringBuilder1.append(paramP.next());
      ((Log)localObject1).d("CrashlyticsCore", localStringBuilder1.toString());
      return paramItem.a("report[file]", paramP.getFileName(), "application/octet-stream", paramP.a());
    }
    Object localObject1 = paramP.getValue();
    int m = localObject1.length;
    int j = 0;
    int k = 0;
    while (j < m)
    {
      localStringBuilder1 = localObject1[j];
      Object localObject2 = f.get();
      StringBuilder localStringBuilder2 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Adding file ");
      localStringBuilder2.append(localStringBuilder1.getName());
      localStringBuilder2.append(" to report ");
      localStringBuilder2.append(paramP.next());
      ((Log)localObject2).d("CrashlyticsCore", localStringBuilder2.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report[file");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("]");
      paramItem.a(((StringBuilder)localObject2).toString(), localStringBuilder1.getName(), "application/octet-stream", localStringBuilder1);
      k += 1;
      j += 1;
    }
    return paramItem;
  }
  
  public boolean a(Handle paramHandle)
  {
    paramHandle = a(a(d(), paramHandle), b);
    Object localObject = f.get();
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Sending report to: ");
    localStringBuilder.append(a());
    ((Log)localObject).d("CrashlyticsCore", localStringBuilder.toString());
    int j = paramHandle.get();
    localObject = f.get();
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Create report request ID: ");
    localStringBuilder.append(paramHandle.header("X-REQUEST-ID"));
    ((Log)localObject).d("CrashlyticsCore", localStringBuilder.toString());
    paramHandle = f.get();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Result was: ");
    ((StringBuilder)localObject).append(j);
    paramHandle.d("CrashlyticsCore", ((StringBuilder)localObject).toString());
    return D.a(j) == 0;
  }
}
