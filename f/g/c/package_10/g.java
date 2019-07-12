package f.g.c.package_10;

public final class g
{
  public int[] i = new int['?'];
  
  public g() {}
  
  public boolean a(char paramChar)
  {
    return ('\001' << paramChar & i[(paramChar >> '\005')]) != 0;
  }
  
  public void append(char paramChar)
  {
    int[] arrayOfInt = i;
    int j = paramChar >> '\005';
    arrayOfInt[j] = ('\001' << paramChar | arrayOfInt[j]);
  }
}
