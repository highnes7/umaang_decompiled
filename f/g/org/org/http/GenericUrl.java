package f.g.org.org.http;

import f.g.org.org.util.GenericData;
import f.g.org.org.util.xml.CharEscapers;
import f.g.org.org.util.xml.Escaper;
import f.g.org.org.util.xml.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class GenericUrl
  extends GenericData
{
  public static final Escaper URI_FRAGMENT_ESCAPER = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
  public String fragment;
  public String host;
  public List<String> pathParts;
  public int port = -1;
  public String scheme;
  public String userInfo;
  
  public GenericUrl() {}
  
  public GenericUrl(String paramString)
  {
    this(parseURL(paramString));
  }
  
  public GenericUrl(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    scheme = paramString1.toLowerCase();
    host = paramString2;
    port = paramInt;
    pathParts = toPathParts(paramString3);
    paramString2 = null;
    if (paramString4 != null) {
      paramString1 = CharEscapers.decodeUri(paramString4);
    } else {
      paramString1 = null;
    }
    fragment = paramString1;
    if (paramString5 != null) {
      UrlEncodedParser.parse(paramString5, this);
    }
    paramString1 = paramString2;
    if (paramString6 != null) {
      paramString1 = CharEscapers.decodeUri(paramString6);
    }
    userInfo = paramString1;
  }
  
  public GenericUrl(URI paramURI)
  {
    this(paramURI.getScheme(), paramURI.getHost(), paramURI.getPort(), paramURI.getRawPath(), paramURI.getRawFragment(), paramURI.getRawQuery(), paramURI.getRawUserInfo());
  }
  
  public GenericUrl(URL paramURL)
  {
    this(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), paramURL.getPath(), paramURL.getRef(), paramURL.getQuery(), paramURL.getUserInfo());
  }
  
  public static void addQueryParams(Set paramSet, StringBuilder paramStringBuilder)
  {
    paramSet = paramSet.iterator();
    boolean bool1 = true;
    while (paramSet.hasNext())
    {
      Object localObject2 = (Map.Entry)paramSet.next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      if (localObject1 != null)
      {
        localObject2 = CharEscapers.escapeUriQuery((String)((Map.Entry)localObject2).getKey());
        if ((localObject1 instanceof Collection))
        {
          localObject1 = ((Collection)localObject1).iterator();
          for (boolean bool2 = bool1;; bool2 = appendParam(bool2, paramStringBuilder, (String)localObject2, ((Iterator)localObject1).next()))
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
          }
        }
        bool1 = appendParam(bool1, paramStringBuilder, (String)localObject2, localObject1);
      }
    }
  }
  
  public static boolean appendParam(boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    if (paramBoolean)
    {
      paramBoolean = false;
      paramStringBuilder.append('?');
    }
    else
    {
      paramStringBuilder.append('&');
    }
    paramStringBuilder.append(paramString);
    paramString = CharEscapers.escapeUriQuery(paramObject.toString());
    if (paramString.length() != 0)
    {
      paramStringBuilder.append('=');
      paramStringBuilder.append(paramString);
    }
    return paramBoolean;
  }
  
  private void appendRawPathFromParts(StringBuilder paramStringBuilder)
  {
    int j = pathParts.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)pathParts.get(i);
      if (i != 0) {
        paramStringBuilder.append('/');
      }
      if (str.length() != 0) {
        paramStringBuilder.append(CharEscapers.escapeUriPath(str));
      }
      i += 1;
    }
  }
  
  public static URL parseURL(String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static List toPathParts(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 1;
      int k;
      for (int j = 0; i != 0; j = k + 1)
      {
        k = paramString.indexOf('/', j);
        if (k != -1) {
          i = 1;
        } else {
          i = 0;
        }
        String str;
        if (i != 0) {
          str = paramString.substring(j, k);
        } else {
          str = paramString.substring(j);
        }
        localArrayList.add(CharEscapers.decodeUri(str));
      }
      return localArrayList;
    }
    return null;
  }
  
  public static URI toURI(String paramString)
  {
    try
    {
      paramString = new URI(paramString);
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public void appendRawPath(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      List localList1 = toPathParts(paramString);
      paramString = pathParts;
      if ((paramString != null) && (!paramString.isEmpty()))
      {
        int i = pathParts.size();
        List localList2 = pathParts;
        i -= 1;
        paramString = String.valueOf((String)localList2.get(i));
        String str = String.valueOf((String)localList1.get(0));
        if (str.length() != 0) {
          paramString = paramString.concat(str);
        } else {
          paramString = new String(paramString);
        }
        localList2.set(i, paramString);
        pathParts.addAll(localList1.subList(1, localList1.size()));
        return;
      }
      pathParts = localList1;
    }
  }
  
  public final String build()
  {
    String str1 = String.valueOf(buildAuthority());
    String str2 = String.valueOf(buildRelativeUrl());
    if (str2.length() != 0) {
      return str1.concat(str2);
    }
    return new String(str1);
  }
  
  public final String buildAuthority()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = scheme;
    f.g.org.org.util.Preconditions.append(str);
    localStringBuilder.append((String)str);
    localStringBuilder.append("://");
    str = userInfo;
    if (str != null)
    {
      localStringBuilder.append(CharEscapers.escapeUriUserInfo(str));
      localStringBuilder.append('@');
    }
    str = host;
    f.g.org.org.util.Preconditions.append(str);
    localStringBuilder.append((String)str);
    int i = port;
    if (i != -1)
    {
      localStringBuilder.append(':');
      localStringBuilder.append(i);
    }
    return localStringBuilder.toString();
  }
  
  public final String buildRelativeUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (pathParts != null) {
      appendRawPathFromParts(localStringBuilder);
    }
    addQueryParams(entrySet(), localStringBuilder);
    String str = fragment;
    if (str != null)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(URI_FRAGMENT_ESCAPER.escape(str));
    }
    return localStringBuilder.toString();
  }
  
  public GenericUrl clone()
  {
    GenericUrl localGenericUrl = (GenericUrl)super.clone();
    List localList = pathParts;
    if (localList != null) {
      pathParts = new ArrayList(localList);
    }
    return localGenericUrl;
  }
  
  public GenericUrl clone(String paramString, Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (GenericUrl)this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((super.equals(paramObject)) && ((paramObject instanceof GenericUrl)))
    {
      paramObject = (GenericUrl)paramObject;
      return build().equals(paramObject.toString());
    }
    return false;
  }
  
  public Collection getAll(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {
      return Collections.emptySet();
    }
    if ((paramString instanceof Collection)) {
      return Collections.unmodifiableCollection((Collection)paramString);
    }
    return Collections.singleton(paramString);
  }
  
  public Object getFirst(String paramString)
  {
    paramString = get(paramString);
    if ((paramString instanceof Collection))
    {
      paramString = ((Collection)paramString).iterator();
      if (paramString.hasNext()) {
        return paramString.next();
      }
      return null;
    }
    return paramString;
  }
  
  public String getFragment()
  {
    return fragment;
  }
  
  public String getHost()
  {
    return host;
  }
  
  public List getPathParts()
  {
    return pathParts;
  }
  
  public int getPort()
  {
    return port;
  }
  
  public String getRawPath()
  {
    if (pathParts == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    appendRawPathFromParts(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final String getScheme()
  {
    return scheme;
  }
  
  public final String getUserInfo()
  {
    return userInfo;
  }
  
  public int hashCode()
  {
    return build().hashCode();
  }
  
  public final void setFragment(String paramString)
  {
    fragment = paramString;
  }
  
  public final void setHost(String paramString)
  {
    if (paramString != null)
    {
      host = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  public void setPathParts(List paramList)
  {
    pathParts = paramList;
  }
  
  public final void setPort(int paramInt)
  {
    boolean bool;
    if (paramInt >= -1) {
      bool = true;
    } else {
      bool = false;
    }
    f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkArgument(bool, "expected port >= -1");
    port = paramInt;
  }
  
  public void setRawPath(String paramString)
  {
    pathParts = toPathParts(paramString);
  }
  
  public final void setScheme(String paramString)
  {
    if (paramString != null)
    {
      scheme = paramString;
      return;
    }
    throw new NullPointerException();
  }
  
  public final void setUserInfo(String paramString)
  {
    userInfo = paramString;
  }
  
  public String toString()
  {
    return build();
  }
  
  public final URI toURI()
  {
    return toURI(build());
  }
  
  public final URL toURL()
  {
    return parseURL(build());
  }
  
  public final URL toURL(String paramString)
  {
    try
    {
      URL localURL = toURL();
      paramString = new URL(localURL, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
  }
}
