package f.g.c.package_10;

public class XYPlot
  extends ua.b
{
  public XYPlot(Label paramLabel, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public int a(int paramInt)
  {
    int j = c.f.length();
    int k = a.length();
    if (paramInt <= k - j)
    {
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label77;
        }
        if (a.charAt(i + paramInt) != c.f.charAt(i))
        {
          paramInt += 1;
          break;
        }
        i += 1;
      }
      label77:
      return paramInt;
    }
    return -1;
  }
  
  public int b(int paramInt)
  {
    return c.f.length() + paramInt;
  }
}
