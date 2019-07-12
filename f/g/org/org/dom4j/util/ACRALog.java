package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import java.security.GeneralSecurityException;

@h
public abstract interface ACRALog
{
  public abstract String computeSignature(String paramString)
    throws GeneralSecurityException;
  
  public abstract String getSignatureMethod();
}
