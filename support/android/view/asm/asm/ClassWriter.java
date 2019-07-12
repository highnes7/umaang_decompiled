package support.android.view.asm.asm;

public class ClassWriter
{
  public int b;
  public int c;
  public int h;
  public int m;
  
  public ClassWriter() {}
  
  public int a()
  {
    return (m + b) / 2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    h = paramInt1;
    m = paramInt2;
    c = paramInt3;
    b = paramInt4;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i = h;
    if ((paramInt1 >= i) && (paramInt1 < i + c))
    {
      paramInt1 = m;
      if ((paramInt2 >= paramInt1) && (paramInt2 < paramInt1 + b)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    return (h + c) / 2;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    h -= paramInt1;
    m -= paramInt2;
    c = (paramInt1 * 2 + c);
    b = (paramInt2 * 2 + b);
  }
  
  public boolean b(ClassWriter paramClassWriter)
  {
    int i = h;
    int j = h;
    if ((i >= j) && (i < j + c))
    {
      i = m;
      j = m;
      if ((i >= j) && (i < j + b)) {
        return true;
      }
    }
    return false;
  }
}
