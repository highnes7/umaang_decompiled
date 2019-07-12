package f.g.c.package_8;

import f.g.c.a.b;

@b
public abstract class ForwardingObject
{
  public ForwardingObject() {}
  
  public abstract Object delegate();
  
  public String toString()
  {
    return delegate().toString();
  }
}
