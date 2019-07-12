package f.g.c.cache;

import f.g.c.a.a;

@a
public abstract interface RemovalListener<K, V>
{
  public abstract void onRemoval(RemovalNotification paramRemovalNotification);
}
