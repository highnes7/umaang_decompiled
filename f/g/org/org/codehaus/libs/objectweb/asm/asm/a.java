package f.g.org.org.codehaus.libs.objectweb.asm.asm;

public class a
  extends f
{
  public a(f paramF1, f paramF2, String paramString)
  {
    super(paramF2, null);
  }
  
  public f a()
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }
  
  public CharSequence a(Object paramObject)
  {
    if (paramObject == null) {
      return a;
    }
    return d.a(paramObject);
  }
  
  public f c(String paramString)
  {
    if (paramString != null) {
      throw new UnsupportedOperationException("already specified useForNull");
    }
    throw new NullPointerException();
  }
}
