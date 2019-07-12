package f.g.c.http;

import f.g.c.a.a;
import f.g.c.package_10.Preconditions;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.net.InetAddress;
import java.text.ParseException;

@a
public final class HostSpecifier
{
  public final String canonicalForm;
  
  public HostSpecifier(String paramString)
  {
    canonicalForm = paramString;
  }
  
  public static HostSpecifier from(String paramString)
    throws ParseException
  {
    try
    {
      HostSpecifier localHostSpecifier = fromValid(paramString);
      return localHostSpecifier;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramString = new ParseException(StringBuilder.toString("Invalid host specifier: ", paramString), 0);
      paramString.initCause(localIllegalArgumentException);
      throw paramString;
    }
  }
  
  public static HostSpecifier fromValid(String paramString)
  {
    paramString = HostAndPort.fromString(paramString);
    Preconditions.checkArgument(paramString.hasPort() ^ true);
    String str = paramString.getHostText();
    paramString = null;
    try
    {
      InetAddress localInetAddress = InetAddresses.forString(str);
      paramString = localInetAddress;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    if (paramString != null) {
      return new HostSpecifier(InetAddresses.toUriString(paramString));
    }
    paramString = InternetDomainName.from(str);
    if (paramString.hasPublicSuffix()) {
      return new HostSpecifier(paramString.name());
    }
    throw new IllegalArgumentException(StringBuilder.toString("Domain name does not have a recognized public suffix: ", str));
  }
  
  public static boolean isValid(String paramString)
  {
    try
    {
      fromValid(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HostSpecifier))
    {
      paramObject = (HostSpecifier)paramObject;
      return canonicalForm.equals(canonicalForm);
    }
    return false;
  }
  
  public int hashCode()
  {
    return canonicalForm.hashCode();
  }
  
  public String toString()
  {
    return canonicalForm;
  }
}
