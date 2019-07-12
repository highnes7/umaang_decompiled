package f.g.org.org.dom4j.util;

import f.g.b.a.g.h;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.xml.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

@h
public final class Namespace
  implements f.g.org.org.http.Object, AnnotationVisitor
{
  public static final PercentEscaper percentEncoder = new PercentEscaper("-_.~", false);
  public static final SecureRandom random = new SecureRandom();
  public String consumerKey;
  public ACRALog log;
  public String nonce;
  public String realm;
  public String signature;
  public String timestamp;
  public String token;
  public String uri;
  public String value;
  public String verifier;
  public String version;
  
  public Namespace() {}
  
  private void appendParameter(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramStringBuilder.append(' ');
      paramStringBuilder.append(toString(paramString1));
      paramStringBuilder.append("=\"");
      paramStringBuilder.append(toString(paramString2));
      paramStringBuilder.append("\",");
    }
  }
  
  private void create(TreeMap paramTreeMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      put(paramTreeMap, paramString1, paramString2);
    }
  }
  
  private void put(TreeMap paramTreeMap, String paramString, Object paramObject)
  {
    String str = toString(paramString);
    if (paramObject == null) {
      paramString = null;
    } else {
      paramString = toString(paramObject.toString());
    }
    paramTreeMap.put(str, paramString);
  }
  
  public static String toString(String paramString)
  {
    return percentEncoder.escape(paramString);
  }
  
  public void computeSignature(String paramString, GenericUrl paramGenericUrl)
    throws GeneralSecurityException
  {
    ACRALog localACRALog = log;
    Object localObject2 = localACRALog.getSignatureMethod();
    value = ((String)localObject2);
    Object localObject1 = new TreeMap();
    Object localObject3 = realm;
    if (localObject3 != null) {
      put((TreeMap)localObject1, "oauth_callback", localObject3);
    }
    localObject3 = consumerKey;
    if (localObject3 != null) {
      put((TreeMap)localObject1, "oauth_consumer_key", localObject3);
    }
    localObject3 = nonce;
    if (localObject3 != null) {
      put((TreeMap)localObject1, "oauth_nonce", localObject3);
    }
    if (localObject2 != null) {
      put((TreeMap)localObject1, "oauth_signature_method", localObject2);
    }
    localObject2 = timestamp;
    if (localObject2 != null) {
      put((TreeMap)localObject1, "oauth_timestamp", localObject2);
    }
    localObject2 = token;
    if (localObject2 != null) {
      put((TreeMap)localObject1, "oauth_token", localObject2);
    }
    localObject2 = verifier;
    if (localObject2 != null) {
      put((TreeMap)localObject1, "oauth_verifier", localObject2);
    }
    localObject2 = version;
    if (localObject2 != null) {
      put((TreeMap)localObject1, "oauth_version", localObject2);
    }
    localObject2 = paramGenericUrl.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
      localObject3 = ((Map.Entry)localObject4).getValue();
      if (localObject3 != null)
      {
        localObject4 = (String)((Map.Entry)localObject4).getKey();
        if ((localObject3 instanceof Collection))
        {
          localObject3 = ((Collection)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            put((TreeMap)localObject1, (String)localObject4, ((Iterator)localObject3).next());
          }
        }
        else
        {
          put((TreeMap)localObject1, (String)localObject4, localObject3);
        }
      }
    }
    localObject2 = new StringBuilder();
    int i = 1;
    localObject1 = ((TreeMap)localObject1).entrySet().iterator();
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      if (i != 0)
      {
        j = 0;
      }
      else
      {
        ((StringBuilder)localObject2).append('&');
        j = i;
      }
      ((StringBuilder)localObject2).append((String)((Map.Entry)localObject3).getKey());
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      i = j;
      if (localObject3 != null)
      {
        ((StringBuilder)localObject2).append('=');
        ((StringBuilder)localObject2).append((String)localObject3);
        i = j;
      }
    }
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new GenericUrl();
    localObject3 = paramGenericUrl.getScheme();
    ((GenericUrl)localObject2).setScheme((String)localObject3);
    ((GenericUrl)localObject2).setHost(paramGenericUrl.getHost());
    ((GenericUrl)localObject2).setPathParts(paramGenericUrl.getPathParts());
    int k = paramGenericUrl.getPort();
    i = k;
    if ((!"http".equals(localObject3)) || (k != 80))
    {
      j = i;
      if ("https".equals(localObject3))
      {
        j = i;
        if (k != 443) {}
      }
    }
    else
    {
      j = -1;
    }
    ((GenericUrl)localObject2).setPort(j);
    paramGenericUrl = ((GenericUrl)localObject2).build();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(toString(paramString));
    ((StringBuilder)localObject2).append('&');
    ((StringBuilder)localObject2).append(toString(paramGenericUrl));
    ((StringBuilder)localObject2).append('&');
    ((StringBuilder)localObject2).append(toString((String)localObject1));
    signature = localACRALog.computeSignature(((StringBuilder)localObject2).toString());
  }
  
  public void create()
  {
    timestamp = Long.toString(System.currentTimeMillis() / 1000L);
  }
  
  public void generate()
  {
    nonce = Long.toHexString(Math.abs(random.nextLong()));
  }
  
  public String getAuthorizationHeader()
  {
    StringBuilder localStringBuilder = new StringBuilder("OAuth");
    appendParameter(localStringBuilder, "realm", uri);
    appendParameter(localStringBuilder, "oauth_callback", realm);
    appendParameter(localStringBuilder, "oauth_consumer_key", consumerKey);
    appendParameter(localStringBuilder, "oauth_nonce", nonce);
    appendParameter(localStringBuilder, "oauth_signature", signature);
    appendParameter(localStringBuilder, "oauth_signature_method", value);
    appendParameter(localStringBuilder, "oauth_timestamp", timestamp);
    appendParameter(localStringBuilder, "oauth_token", token);
    appendParameter(localStringBuilder, "oauth_verifier", verifier);
    appendParameter(localStringBuilder, "oauth_version", version);
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void intercept(HttpRequest paramHttpRequest)
    throws IOException
  {
    generate();
    create();
    try
    {
      computeSignature(paramHttpRequest.getRequestMethod(), paramHttpRequest.getUrl());
      paramHttpRequest.getHeaders().setAuthorization(getAuthorizationHeader());
      return;
    }
    catch (GeneralSecurityException paramHttpRequest)
    {
      IOException localIOException = new IOException();
      localIOException.initCause(paramHttpRequest);
      throw localIOException;
    }
  }
  
  public void visit(HttpRequest paramHttpRequest)
    throws IOException
  {
    paramHttpRequest.setInterceptor(this);
  }
}
