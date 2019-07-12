package f.libs.asm.menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l.a.a.a.Log;
import l.a.a.a.f;

public final class BarRenderer
{
  public static final Pattern b = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");
  
  public BarRenderer() {}
  
  public static AppCompatDelegateImplV7.PanelFeatureState a(String paramString)
  {
    Object localObject2 = b.matcher(paramString);
    if (!((Matcher)localObject2).matches()) {
      return null;
    }
    try
    {
      long l1 = Long.valueOf(((Matcher)localObject2).group(1), 16).longValue();
      long l2 = Long.valueOf(((Matcher)localObject2).group(2), 16).longValue();
      localObject1 = ((Matcher)localObject2).group(3);
      localObject2 = ((Matcher)localObject2).group(4);
      localObject1 = new AppCompatDelegateImplV7.PanelFeatureState(l1, l2 - l1, (String)localObject1, (String)localObject2);
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject1;
      for (;;) {}
    }
    localObject1 = f.get();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Could not parse map entry: ");
    ((StringBuilder)localObject2).append(paramString);
    ((Log)localObject1).d("CrashlyticsCore", ((StringBuilder)localObject2).toString());
    return null;
  }
}
