package support.android.view.asm.asm;

public class e
{
  public Label a;
  public Label b;
  public int c;
  public XLayoutStyle d;
  public int e;
  
  public e(Label paramLabel)
  {
    a = paramLabel;
    b = paramLabel.length();
    c = paramLabel.a();
    d = paramLabel.e();
    e = paramLabel.f();
  }
  
  public void a(i paramI)
  {
    paramI.a(a.d()).a(b, c, d, e);
  }
  
  public void b(i paramI)
  {
    a = paramI.a(a.d());
    paramI = a;
    if (paramI != null)
    {
      b = paramI.length();
      c = a.a();
      d = a.e();
      e = a.f();
      return;
    }
    b = null;
    c = 0;
    d = XLayoutStyle.b;
    e = 0;
  }
}
