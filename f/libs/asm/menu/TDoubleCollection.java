package f.libs.asm.menu;

import java.io.InputStream;

public abstract interface TDoubleCollection
{
  public abstract String remove();
  
  public abstract InputStream retainAll();
  
  public abstract String[] toArray();
}
