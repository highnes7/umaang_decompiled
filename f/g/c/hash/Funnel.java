package f.g.c.hash;

import f.g.c.a.a;
import java.io.Serializable;

@a
public abstract interface Funnel<T>
  extends Serializable
{
  public abstract void funnel(Object paramObject, PrimitiveSink paramPrimitiveSink);
}
