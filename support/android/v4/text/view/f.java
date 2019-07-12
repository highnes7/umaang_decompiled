package support.android.v4.text.view;

public class f
{
  public int b;
  public int c;
  public int d;
  public int v;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    v = paramInt1;
    c = paramInt2;
    b = paramInt3;
    d = paramInt3;
  }
  
  public boolean add(String paramString)
  {
    int i = Integer.parseInt(paramString.substring(0, 2));
    return ((v <= i) && (i <= c)) || (i == b) || (i == d);
  }
}
