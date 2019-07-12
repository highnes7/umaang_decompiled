package f.libs.asm.asm;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import l.a.a.a.Log;
import l.a.a.a.a.b.D;
import l.a.a.a.a.b.XYPlot;
import l.a.a.a.a.d.p;
import l.a.a.a.a.e.LayoutManager;
import l.a.a.a.a.e.MathArrays.OrderDirection;
import l.a.a.a.f;

public class XYPlotZoomPan
  extends XYPlot
  implements p
{
  public static final String l = "application/vnd.crashlytics.android.events";
  public static final String t = "session_analytics_file_";
  public final String p;
  
  public XYPlotZoomPan(l.a.a.a.Item paramItem, String paramString1, String paramString2, LayoutManager paramLayoutManager, String paramString3)
  {
    super(paramItem, paramString1, paramString2, paramLayoutManager, MathArrays.OrderDirection.INCREASING);
    p = paramString3;
  }
  
  public boolean a(List paramList)
  {
    Object localObject1 = d().get("X-CRASHLYTICS-API-CLIENT-TYPE", "android").get("X-CRASHLYTICS-API-CLIENT-VERSION", o.c()).get("X-CRASHLYTICS-API-KEY", p);
    Object localObject2 = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (File)((Iterator)localObject2).next();
      ((l.a.a.a.a.e.Item)localObject1).a(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("session_analytics_file_", i), ((File)localObject3).getName(), "application/vnd.crashlytics.android.events", (File)localObject3);
      i += 1;
    }
    localObject2 = f.get();
    Object localObject3 = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Sending ");
    ((StringBuilder)localObject3).append(paramList.size());
    ((StringBuilder)localObject3).append(" analytics files to ");
    ((StringBuilder)localObject3).append(a());
    ((Log)localObject2).d("Answers", ((StringBuilder)localObject3).toString());
    i = ((l.a.a.a.a.e.Item)localObject1).get();
    paramList = f.get();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Response code for analytics file send is ");
    ((StringBuilder)localObject1).append(i);
    paramList.d("Answers", ((StringBuilder)localObject1).toString());
    return D.a(i) == 0;
  }
}
