package f.g.org.org.http;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HttpMediaType
{
  public static final Pattern FULL_MEDIA_TYPE_REGEX;
  public static final Pattern PARAMETER_REGEX;
  public static final Pattern TOKEN_REGEX;
  public static final Pattern TYPE_REGEX = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
  public String cachedBuildResult;
  public final SortedMap<String, String> parameters = new TreeMap();
  public String subType = "octet-stream";
  public String type = "application";
  
  static
  {
    TOKEN_REGEX = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    int i = "[^\\s/=;\"]+".length();
    int j = "[^\\s/=;\"]+".length();
    Object localObject = new StringBuilder(";.*".length() + (j + (i + 14)));
    f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, "\\s*(", "[^\\s/=;\"]+", ")/(", "[^\\s/=;\"]+");
    FULL_MEDIA_TYPE_REGEX = Pattern.compile(f.sufficientlysecure.rootcommands.util.StringBuilder.replace((StringBuilder)localObject, ")", "\\s*(", ";.*", ")?"), 32);
    i = "\"([^\"]*)\"".length();
    localObject = new StringBuilder("[^\\s;\"]*".length() + (i + 1));
    ((StringBuilder)localObject).append("\"([^\"]*)\"");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("[^\\s;\"]*");
    localObject = String.valueOf(((StringBuilder)localObject).toString());
    i = "[^\\s/=;\"]+".length();
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + (i + 12));
    f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, "\\s*;\\s*(", "[^\\s/=;\"]+", ")", "=(");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(")");
    PARAMETER_REGEX = Pattern.compile(localStringBuilder.toString());
  }
  
  public HttpMediaType(String paramString)
  {
    fromString(paramString);
  }
  
  public HttpMediaType(String paramString1, String paramString2)
  {
    setType(paramString1);
    setSubType(paramString2);
  }
  
  public static boolean equalsIgnoreParameters(String paramString1, String paramString2)
  {
    return ((paramString1 == null) && (paramString2 == null)) || ((paramString1 != null) && (paramString2 != null) && (new HttpMediaType(paramString1).equalsIgnoreParameters(new HttpMediaType(paramString2))));
  }
  
  private HttpMediaType fromString(String paramString)
  {
    paramString = FULL_MEDIA_TYPE_REGEX.matcher(paramString);
    Preconditions.checkArgument(paramString.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
    setType(paramString.group(1));
    setSubType(paramString.group(2));
    paramString = paramString.group(3);
    if (paramString != null)
    {
      Matcher localMatcher = PARAMETER_REGEX.matcher(paramString);
      while (localMatcher.find())
      {
        String str2 = localMatcher.group(1);
        String str1 = localMatcher.group(3);
        paramString = str1;
        if (str1 == null) {
          paramString = localMatcher.group(2);
        }
        setParameter(str2, paramString);
      }
    }
    return this;
  }
  
  public static boolean matchesToken(String paramString)
  {
    return TOKEN_REGEX.matcher(paramString).matches();
  }
  
  public static String quoteString(String paramString)
  {
    paramString = String.valueOf(paramString.replace("\\", "\\\\").replace("\"", "\\\""));
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(new StringBuilder(paramString.length() + 2), "\"", paramString, "\"");
  }
  
  public String build()
  {
    Object localObject = cachedBuildResult;
    if (localObject != null) {
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(type);
    localStringBuilder.append('/');
    localStringBuilder.append(subType);
    localObject = parameters;
    if (localObject != null)
    {
      Iterator localIterator = ((SortedMap)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject).getValue();
        localStringBuilder.append("; ");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localObject = str;
        if (!matchesToken(str)) {
          localObject = quoteString(str);
        }
        localStringBuilder.append((String)localObject);
      }
    }
    cachedBuildResult = localStringBuilder.toString();
    return cachedBuildResult;
  }
  
  public void clearParameters()
  {
    cachedBuildResult = null;
    parameters.clear();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HttpMediaType)) {
      return false;
    }
    paramObject = (HttpMediaType)paramObject;
    return (equalsIgnoreParameters(paramObject)) && (parameters.equals(parameters));
  }
  
  public boolean equalsIgnoreParameters(HttpMediaType paramHttpMediaType)
  {
    return (paramHttpMediaType != null) && (getType().equalsIgnoreCase(paramHttpMediaType.getType())) && (getSubType().equalsIgnoreCase(paramHttpMediaType.getSubType()));
  }
  
  public Charset getCharsetParameter()
  {
    String str = getParameter("charset");
    if (str == null) {
      return null;
    }
    return Charset.forName(str);
  }
  
  public String getParameter(String paramString)
  {
    return (String)parameters.get(paramString.toLowerCase());
  }
  
  public Map getParameters()
  {
    return Collections.unmodifiableMap(parameters);
  }
  
  public String getSubType()
  {
    return subType;
  }
  
  public String getType()
  {
    return type;
  }
  
  public int hashCode()
  {
    return build().hashCode();
  }
  
  public HttpMediaType setCharsetParameter(Charset paramCharset)
  {
    if (paramCharset == null) {
      paramCharset = null;
    } else {
      paramCharset = paramCharset.name();
    }
    setParameter("charset", paramCharset);
    return this;
  }
  
  public HttpMediaType setParameter(String paramString)
  {
    cachedBuildResult = null;
    parameters.remove(paramString.toLowerCase());
    return this;
  }
  
  public HttpMediaType setParameter(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      setParameter(paramString1);
      return this;
    }
    Preconditions.checkArgument(TOKEN_REGEX.matcher(paramString1).matches(), "Name contains reserved characters");
    cachedBuildResult = null;
    parameters.put(paramString1.toLowerCase(), paramString2);
    return this;
  }
  
  public HttpMediaType setSubType(String paramString)
  {
    Preconditions.checkArgument(TYPE_REGEX.matcher(paramString).matches(), "Subtype contains reserved characters");
    subType = paramString;
    cachedBuildResult = null;
    return this;
  }
  
  public HttpMediaType setType(String paramString)
  {
    Preconditions.checkArgument(TYPE_REGEX.matcher(paramString).matches(), "Type contains reserved characters");
    type = paramString;
    cachedBuildResult = null;
    return this;
  }
  
  public String toString()
  {
    return build();
  }
}
