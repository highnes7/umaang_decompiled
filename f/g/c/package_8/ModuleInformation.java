package f.g.c.package_8;

import f.g.c.a.b;
import f.g.c.d.mf;
import java.io.Serializable;

@b(serializable=true)
public final class ModuleInformation
  extends mf<Object>
  implements Serializable
{
  public static final long d = 0L;
  public static final ModuleInformation mModulePackage = new ModuleInformation();
  
  public ModuleInformation() {}
  
  private Object getModulePackage()
  {
    return mModulePackage;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString());
  }
  
  public String toString()
  {
    return "Ordering.usingToString()";
  }
}
