package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.Pb;

@b(serializable=true)
public class EmptyImmutableSetMultimap
  extends Pb<Object, Object>
{
  public static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableSetMultimap()
  {
    super(ImmutableMap.of(), 0, null);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}
