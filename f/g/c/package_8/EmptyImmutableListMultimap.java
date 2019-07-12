package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.xb;

@b(serializable=true)
public class EmptyImmutableListMultimap
  extends xb<Object, Object>
{
  public static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
  public static final long serialVersionUID = 0L;
  
  public EmptyImmutableListMultimap()
  {
    super(ImmutableMap.of(), 0);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}
