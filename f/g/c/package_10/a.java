package f.g.c.package_10;

public final class a
  extends h
{
  public a(String paramString, char paramChar1, char paramChar2)
  {
    super(paramString);
  }
  
  public h a()
  {
    return this;
  }
  
  public void a(g paramG)
  {
    for (char c = g;; c = (char)(c + '\001'))
    {
      paramG.append(c);
      if (c == h) {
        return;
      }
    }
  }
  
  public boolean a(char paramChar)
  {
    return (g <= paramChar) && (paramChar <= h);
  }
}
