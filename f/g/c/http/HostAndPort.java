package f.g.c.http;

import f.g.c.a.a;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m.a.a.b;

@a
@b
public final class HostAndPort
  implements Serializable
{
  public static final Pattern BRACKET_PATTERN = Pattern.compile("^\\[(.*:.*)\\](?::(\\d*))?$");
  public static final int NO_PORT = -1;
  public static final long serialVersionUID = 0L;
  public final boolean hasBracketlessColons;
  public final String host;
  public final int port;
  
  public HostAndPort(String paramString, int paramInt, boolean paramBoolean)
  {
    host = paramString;
    port = paramInt;
    hasBracketlessColons = paramBoolean;
  }
  
  public static HostAndPort fromParts(String paramString, int paramInt)
  {
    Preconditions.checkArgument(isValidPort(paramInt));
    paramString = fromString(paramString);
    Preconditions.checkArgument(paramString.hasPort() ^ true);
    return new HostAndPort(host, paramInt, hasBracketlessColons);
  }
  
  public static HostAndPort fromString(String paramString)
  {
    Object localObject;
    boolean bool;
    int i;
    String str;
    int j;
    if (paramString != null)
    {
      localObject = null;
      bool = paramString.startsWith("[");
      i = -1;
      if (bool)
      {
        localObject = BRACKET_PATTERN.matcher(paramString);
        Preconditions.checkArgument(((Matcher)localObject).matches(), "Invalid bracketed host/port: %s", new Object[] { paramString });
        str = ((Matcher)localObject).group(1);
        localObject = ((Matcher)localObject).group(2);
        bool = false;
      }
      else
      {
        j = paramString.indexOf(':');
        if (j >= 0)
        {
          int k = j + 1;
          if (paramString.indexOf(':', k) == -1)
          {
            bool = false;
            str = paramString.substring(0, j);
            localObject = paramString.substring(k);
            break label134;
          }
        }
        if (j >= 0) {
          bool = true;
        } else {
          bool = false;
        }
        str = paramString;
      }
      label134:
      if (localObject != null) {
        Preconditions.checkArgument(((String)localObject).startsWith("+") ^ true, "Unparseable port number: %s", new Object[] { paramString });
      }
    }
    try
    {
      j = Integer.parseInt((String)localObject);
      i = j;
      Preconditions.checkArgument(isValidPort(j), "Port number out of range: %s", new Object[] { paramString });
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Unparseable port number: ", paramString));
    return new HostAndPort(str, i, bool);
    throw new NullPointerException();
  }
  
  public static boolean isValidPort(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 65535);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HostAndPort))
    {
      paramObject = (HostAndPort)paramObject;
      return (Objects.equal(host, host)) && (port == port) && (hasBracketlessColons == hasBracketlessColons);
    }
    return false;
  }
  
  public String getHostText()
  {
    return host;
  }
  
  public int getPort()
  {
    Preconditions.checkState(hasPort());
    return port;
  }
  
  public int getPortOrDefault(int paramInt)
  {
    if (hasPort()) {
      paramInt = port;
    }
    return paramInt;
  }
  
  public boolean hasPort()
  {
    return port >= 0;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { host, Integer.valueOf(port), Boolean.valueOf(hasBracketlessColons) });
  }
  
  public HostAndPort requireBracketsForIPv6()
  {
    Preconditions.checkArgument(hasBracketlessColons ^ true, "Possible bracketless IPv6 literal: %s", new Object[] { host });
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(host.length() + 7);
    if (host.indexOf(':') >= 0)
    {
      localStringBuilder.append('[');
      localStringBuilder.append(host);
      localStringBuilder.append(']');
    }
    else
    {
      localStringBuilder.append(host);
    }
    if (hasPort())
    {
      localStringBuilder.append(':');
      localStringBuilder.append(port);
    }
    return localStringBuilder.toString();
  }
  
  public HostAndPort withDefaultPort(int paramInt)
  {
    Preconditions.checkArgument(isValidPort(paramInt));
    if (!hasPort())
    {
      if (port == paramInt) {
        return this;
      }
      return new HostAndPort(host, paramInt, hasBracketlessColons);
    }
    return this;
  }
}
