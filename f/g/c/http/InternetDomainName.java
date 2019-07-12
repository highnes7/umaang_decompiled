package f.g.c.http;

import f.g.c.a.a;
import f.g.c.a.b;
import f.g.c.d.vb;
import f.g.c.package_10.ClassWriter;
import f.g.c.package_10.Joiner;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Objects.ToStringHelper;
import f.g.c.package_10.Preconditions;
import f.g.c.package_10.Splitter;
import f.g.c.package_10.h;
import f.g.c.package_8.ImmutableCollection;
import f.g.c.package_8.ImmutableList;
import java.util.Collection;
import java.util.List;

@a
@b(emulated=true)
public final class InternetDomainName
{
  public static final h DOTS_MATCHER = h.anyOf(".???");
  public static final Joiner DOT_JOINER;
  public static final String DOT_REGEX = "\\.";
  public static final Splitter DOT_SPLITTER = Splitter.on('.');
  public static final int MAX_DOMAIN_PART_LENGTH = 63;
  public static final int MAX_LENGTH = 253;
  public static final int MAX_PARTS = 127;
  public static final int NO_PUBLIC_SUFFIX_FOUND = -1;
  public static final h b = h.u.or(c);
  public static final h c;
  public final String name;
  public final vb<String> parts;
  public final int publicSuffixIndex;
  
  static
  {
    DOT_JOINER = Joiner.on('.');
    c = h.anyOf("-_");
  }
  
  public InternetDomainName(String paramString)
  {
    String str = ClassWriter.toLowerCase(DOTS_MATCHER.replaceFrom(paramString, '.'));
    paramString = str;
    if (str.endsWith(".")) {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.substring(str, 1, 0);
    }
    boolean bool;
    if (paramString.length() <= 253) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Domain name too long: '%s':", new Object[] { paramString });
    name = paramString;
    parts = ImmutableList.copyOf(DOT_SPLITTER.split(paramString));
    if (parts.size() <= 127) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Domain has too many parts: '%s'", new Object[] { paramString });
    Preconditions.checkArgument(validateSyntax(parts), "Not a valid domain name: '%s'", new Object[] { paramString });
    publicSuffixIndex = findPublicSuffix();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString.length() >= 1)
    {
      if (paramString.length() > 63) {
        return false;
      }
      String str = h.i.f(paramString);
      if (!b.put(str)) {
        return false;
      }
      if (!c.a(paramString.charAt(0)))
      {
        if (c.a(paramString.charAt(paramString.length() - 1))) {
          return false;
        }
        if (paramBoolean)
        {
          if (!h.b.a(paramString.charAt(0))) {
            break label98;
          }
          return false;
        }
        return true;
      }
    }
    return false;
    label98:
    return true;
  }
  
  private InternetDomainName ancestor(int paramInt)
  {
    Joiner localJoiner = DOT_JOINER;
    ImmutableList localImmutableList = parts;
    return from(localJoiner.join(localImmutableList.subList(paramInt, localImmutableList.size())));
  }
  
  private int findPublicSuffix()
  {
    int j = parts.size();
    int i = 0;
    while (i < j)
    {
      String str = DOT_JOINER.join(parts.subList(i, j));
      if (PublicSuffixPatterns.EXACT.contains(str)) {
        return i;
      }
      if (PublicSuffixPatterns.EXCLUDED.contains(str)) {
        return i + 1;
      }
      if (matchesWildcardPublicSuffix(str)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static InternetDomainName from(String paramString)
  {
    if (paramString != null) {
      return new InternetDomainName(paramString);
    }
    throw new NullPointerException();
  }
  
  public static InternetDomainName fromLenient(String paramString)
  {
    return from(paramString);
  }
  
  public static boolean isValid(String paramString)
  {
    try
    {
      from(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean isValidLenient(String paramString)
  {
    return isValid(paramString);
  }
  
  public static boolean matchesWildcardPublicSuffix(String paramString)
  {
    paramString = paramString.split("\\.", 2);
    return (paramString.length == 2) && (PublicSuffixPatterns.UNDER.contains(paramString[1]));
  }
  
  public static boolean validateSyntax(List paramList)
  {
    int j = paramList.size() - 1;
    if (!a((String)paramList.get(j), true)) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (!a((String)paramList.get(i), false)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public InternetDomainName child(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      localStringBuilder.append(name);
      return from(localStringBuilder.toString());
    }
    throw new NullPointerException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof InternetDomainName))
    {
      paramObject = (InternetDomainName)paramObject;
      return name.equals(name);
    }
    return false;
  }
  
  public boolean hasParent()
  {
    return parts.size() > 1;
  }
  
  public boolean hasPublicSuffix()
  {
    return publicSuffixIndex != -1;
  }
  
  public int hashCode()
  {
    return name.hashCode();
  }
  
  public boolean isPublicSuffix()
  {
    return publicSuffixIndex == 0;
  }
  
  public boolean isTopPrivateDomain()
  {
    return publicSuffixIndex == 1;
  }
  
  public boolean isUnderPublicSuffix()
  {
    return publicSuffixIndex > 0;
  }
  
  public String name()
  {
    return name;
  }
  
  public InternetDomainName parent()
  {
    Preconditions.checkState(hasParent(), "Domain '%s' has no parent", new Object[] { name });
    return ancestor(1);
  }
  
  public ImmutableList parts()
  {
    return parts;
  }
  
  public InternetDomainName publicSuffix()
  {
    if (hasPublicSuffix()) {
      return ancestor(publicSuffixIndex);
    }
    return null;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", name).toString();
  }
  
  public InternetDomainName topPrivateDomain()
  {
    if (isTopPrivateDomain()) {
      return this;
    }
    Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", new Object[] { name });
    return ancestor(publicSuffixIndex - 1);
  }
}
