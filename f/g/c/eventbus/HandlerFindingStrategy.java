package f.g.c.eventbus;

import f.g.c.package_8.Multimap;

public abstract interface HandlerFindingStrategy
{
  public abstract Multimap findAllHandlers(Object paramObject);
}
