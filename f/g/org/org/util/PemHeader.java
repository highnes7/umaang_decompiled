package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Cache;

public final class PemHeader
{
  public PemHeader() {}
  
  public static boolean isEqual(String paramString)
  {
    return Cache.isEmpty(paramString);
  }
}
