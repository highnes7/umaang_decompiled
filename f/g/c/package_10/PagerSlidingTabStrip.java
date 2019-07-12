package f.g.c.package_10;

import java.util.regex.Matcher;

public class PagerSlidingTabStrip
  extends ua.b
{
  public PagerSlidingTabStrip(Splitter.3 param3, Splitter paramSplitter, CharSequence paramCharSequence, Matcher paramMatcher)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public int a(int paramInt)
  {
    if (m.find(paramInt)) {
      return m.start();
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    return m.end();
  }
}
