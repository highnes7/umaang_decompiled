package f.g.org.org.org.asm;

import java.util.UUID;

public final class ECDomainParameters
{
  public ECDomainParameters() {}
  
  public static String getSeed()
  {
    return UUID.randomUUID().toString();
  }
}
