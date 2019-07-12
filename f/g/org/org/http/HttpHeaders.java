package f.g.org.org.http;

import f.g.b.a.g.z;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature.Base64;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Throwables;
import f.g.org.org.util.ArrayValueMap;
import f.g.org.org.util.ClassInfo;
import f.g.org.org.util.Data;
import f.g.org.org.util.FieldInfo;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.PubSubElementType;
import f.g.org.org.util.StringUtils;
import f.g.org.org.util.Types;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpHeaders
  extends GenericData
{
  @z("Accept")
  public List<String> accept;
  @z("Accept-Encoding")
  public List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));
  @z("Age")
  public List<Long> age;
  @z("WWW-Authenticate")
  public List<String> authenticate;
  @z("Authorization")
  public List<String> authorization;
  @z("Cache-Control")
  public List<String> cacheControl;
  @z("Content-Encoding")
  public List<String> contentEncoding;
  @z("Content-Length")
  public List<Long> contentLength;
  @z("Content-MD5")
  public List<String> contentMD5;
  @z("Content-Range")
  public List<String> contentRange;
  @z("Content-Type")
  public List<String> contentType;
  @z("Cookie")
  public List<String> cookie;
  @z("Date")
  public List<String> date;
  @z("ETag")
  public List<String> etag;
  @z("Expires")
  public List<String> expires;
  @z("If-Match")
  public List<String> ifMatch;
  @z("If-Modified-Since")
  public List<String> ifModifiedSince;
  @z("If-None-Match")
  public List<String> ifNoneMatch;
  @z("If-Range")
  public List<String> ifRange;
  @z("If-Unmodified-Since")
  public List<String> ifUnmodifiedSince;
  @z("Last-Modified")
  public List<String> lastModified;
  @z("Location")
  public List<String> location;
  @z("MIME-Version")
  public List<String> mimeVersion;
  @z("Range")
  public List<String> range;
  @z("Retry-After")
  public List<String> retryAfter;
  @z("User-Agent")
  public List<String> userAgent;
  
  public HttpHeaders()
  {
    super(EnumSet.of(PubSubElementType.CREATE));
  }
  
  public static void addHeader(Logger paramLogger, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, LowLevelHttpRequest paramLowLevelHttpRequest, String paramString, Object paramObject, Writer paramWriter)
    throws IOException
  {
    if (paramObject != null)
    {
      if (Data.isNull(paramObject)) {
        return;
      }
      paramObject = toStringValue(paramObject);
      if (((!"Authorization".equalsIgnoreCase(paramString)) && (!"Cookie".equalsIgnoreCase(paramString))) || ((paramLogger != null) && (paramLogger.isLoggable(Level.ALL)))) {
        paramLogger = paramObject;
      } else {
        paramLogger = "<Not Logged>";
      }
      if (paramStringBuilder1 != null)
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.write(paramStringBuilder1, paramString, ": ", paramLogger);
        paramStringBuilder1.append(StringUtils.LINE_SEPARATOR);
      }
      if (paramStringBuilder2 != null)
      {
        f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramStringBuilder2, " -H '", paramString, ": ", paramLogger);
        paramStringBuilder2.append("'");
      }
      if (paramLowLevelHttpRequest != null) {
        paramLowLevelHttpRequest.addHeader(paramString, paramObject);
      }
      if (paramWriter != null)
      {
        paramWriter.write(paramString);
        paramWriter.write(": ");
        paramWriter.write(paramObject);
        paramWriter.write("\r\n");
      }
    }
  }
  
  private List getAsList(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return f.sufficientlysecure.rootcommands.util.StringBuilder.newArrayList(paramObject);
  }
  
  private Object getFirstHeaderValue(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    return paramList.get(0);
  }
  
  public static Object parseValue(Type paramType, List paramList, String paramString)
  {
    return Data.parsePrimitiveValue(Data.resolveWildcardTypeOrTypeVariable(paramList, paramType), paramString);
  }
  
  public static void serializeHeaders(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, LowLevelHttpRequest paramLowLevelHttpRequest)
    throws IOException
  {
    serializeHeaders(paramHttpHeaders, paramStringBuilder1, paramStringBuilder2, paramLogger, paramLowLevelHttpRequest, null);
  }
  
  public static void serializeHeaders(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, LowLevelHttpRequest paramLowLevelHttpRequest, Writer paramWriter)
    throws IOException
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramHttpHeaders.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      Preconditions.checkArgument(localHashSet.add(str), "multiple headers of the same name (headers are case insensitive): %s", new Object[] { str });
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 != null)
      {
        Object localObject2 = paramHttpHeaders.getClassInfo().getFieldInfo(str);
        if (localObject2 != null) {
          str = ((FieldInfo)localObject2).getName();
        }
        localObject2 = localObject1.getClass();
        if ((!(localObject1 instanceof Iterable)) && (!((Class)localObject2).isArray()))
        {
          addHeader(paramLogger, paramStringBuilder1, paramStringBuilder2, paramLowLevelHttpRequest, str, localObject1, paramWriter);
        }
        else
        {
          localObject1 = Types.iterableOf(localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            addHeader(paramLogger, paramStringBuilder1, paramStringBuilder2, paramLowLevelHttpRequest, str, ((Iterator)localObject1).next(), paramWriter);
          }
        }
      }
    }
    if (paramWriter != null) {
      paramWriter.flush();
    }
  }
  
  public static void serializeHeadersForMultipartRequests(HttpHeaders paramHttpHeaders, StringBuilder paramStringBuilder, Logger paramLogger, Writer paramWriter)
    throws IOException
  {
    serializeHeaders(paramHttpHeaders, paramStringBuilder, null, paramLogger, null, paramWriter);
  }
  
  public static String toStringValue(Object paramObject)
  {
    if ((paramObject instanceof Enum)) {
      return FieldInfo.of((Enum)paramObject).getName();
    }
    return paramObject.toString();
  }
  
  public HttpHeaders clone()
  {
    return (HttpHeaders)super.clone();
  }
  
  public HttpHeaders clone(String paramString, Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (HttpHeaders)this;
  }
  
  public final void fromHttpHeaders(HttpHeaders paramHttpHeaders)
  {
    try
    {
      ParseHeaderState localParseHeaderState = new ParseHeaderState(null);
      serializeHeaders(paramHttpHeaders, null, null, null, new HeaderParsingFakeLevelHttpRequest(localParseHeaderState));
      localParseHeaderState.finish();
      return;
    }
    catch (IOException paramHttpHeaders)
    {
      Throwables.propagate(paramHttpHeaders);
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
  }
  
  public final void fromHttpResponse(LowLevelHttpResponse paramLowLevelHttpResponse, StringBuilder paramStringBuilder)
    throws IOException
  {
    clear();
    paramStringBuilder = new ParseHeaderState(paramStringBuilder);
    int j = paramLowLevelHttpResponse.getHeaderCount();
    int i = 0;
    while (i < j)
    {
      parseHeader(paramLowLevelHttpResponse.getHeaderName(i), paramLowLevelHttpResponse.getHeaderValue(i), paramStringBuilder);
      i += 1;
    }
    paramStringBuilder.finish();
  }
  
  public final String get()
  {
    return (String)getFirstHeaderValue(contentRange);
  }
  
  public final String getAccept()
  {
    return (String)getFirstHeaderValue(accept);
  }
  
  public final String getAcceptEncoding()
  {
    return (String)getFirstHeaderValue(acceptEncoding);
  }
  
  public final Long getAge()
  {
    return (Long)getFirstHeaderValue(age);
  }
  
  public final String getAuthenticate()
  {
    return (String)getFirstHeaderValue(authenticate);
  }
  
  public final List getAuthenticateAsList()
  {
    return authenticate;
  }
  
  public final String getAuthorization()
  {
    return (String)getFirstHeaderValue(authorization);
  }
  
  public final List getAuthorizationAsList()
  {
    return authorization;
  }
  
  public final String getCacheControl()
  {
    return (String)getFirstHeaderValue(cacheControl);
  }
  
  public final String getContentEncoding()
  {
    return (String)getFirstHeaderValue(contentEncoding);
  }
  
  public final Long getContentLength()
  {
    return (Long)getFirstHeaderValue(contentLength);
  }
  
  public final String getContentMD5()
  {
    return (String)getFirstHeaderValue(contentMD5);
  }
  
  public final String getContentType()
  {
    return (String)getFirstHeaderValue(contentType);
  }
  
  public final String getCookie()
  {
    return (String)getFirstHeaderValue(cookie);
  }
  
  public final String getDate()
  {
    return (String)getFirstHeaderValue(date);
  }
  
  public final String getETag()
  {
    return (String)getFirstHeaderValue(etag);
  }
  
  public final String getExpires()
  {
    return (String)getFirstHeaderValue(expires);
  }
  
  public String getFirstHeaderStringValue(String paramString)
  {
    paramString = get(paramString.toLowerCase());
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.getClass();
    if (((paramString instanceof Iterable)) || (((Class)localObject).isArray()))
    {
      localObject = Types.iterableOf(paramString).iterator();
      if (((Iterator)localObject).hasNext()) {
        return toStringValue(((Iterator)localObject).next());
      }
    }
    return toStringValue(paramString);
  }
  
  public List getHeaderStringValues(String paramString)
  {
    paramString = get(paramString.toLowerCase());
    if (paramString == null) {
      return Collections.emptyList();
    }
    Object localObject = paramString.getClass();
    if ((!(paramString instanceof Iterable)) && (!((Class)localObject).isArray())) {
      return Collections.singletonList(toStringValue(paramString));
    }
    localObject = new ArrayList();
    paramString = Types.iterableOf(paramString).iterator();
    while (paramString.hasNext()) {
      ((List)localObject).add(toStringValue(paramString.next()));
    }
    return Collections.unmodifiableList((List)localObject);
  }
  
  public final String getIfMatch()
  {
    return (String)getFirstHeaderValue(ifMatch);
  }
  
  public final String getIfModifiedSince()
  {
    return (String)getFirstHeaderValue(ifModifiedSince);
  }
  
  public final String getIfNoneMatch()
  {
    return (String)getFirstHeaderValue(ifNoneMatch);
  }
  
  public final String getIfRange()
  {
    return (String)getFirstHeaderValue(ifRange);
  }
  
  public final String getIfUnmodifiedSince()
  {
    return (String)getFirstHeaderValue(ifUnmodifiedSince);
  }
  
  public final String getLastModified()
  {
    return (String)getFirstHeaderValue(lastModified);
  }
  
  public final String getLocation()
  {
    return (String)getFirstHeaderValue(location);
  }
  
  public final String getMimeVersion()
  {
    return (String)getFirstHeaderValue(mimeVersion);
  }
  
  public final String getRetryAfter()
  {
    return (String)getFirstHeaderValue(retryAfter);
  }
  
  public final String getUserAgent()
  {
    return (String)getFirstHeaderValue(userAgent);
  }
  
  public void parseHeader(String paramString1, String paramString2, ParseHeaderState paramParseHeaderState)
  {
    Object localObject1 = context;
    Object localObject2 = classInfo;
    ArrayValueMap localArrayValueMap = arrayValueMap;
    paramParseHeaderState = logger;
    Object localObject3;
    if (paramParseHeaderState != null)
    {
      localObject3 = String.valueOf(paramString1);
      String str = String.valueOf(paramString2);
      int i = ((String)localObject3).length();
      StringBuilder localStringBuilder = new StringBuilder(str.length() + (i + 2));
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(": ");
      localStringBuilder.append(str);
      paramParseHeaderState.append(localStringBuilder.toString());
      paramParseHeaderState.append(StringUtils.LINE_SEPARATOR);
    }
    localObject2 = ((ClassInfo)localObject2).getFieldInfo(paramString1);
    if (localObject2 != null)
    {
      localObject3 = Data.resolveWildcardTypeOrTypeVariable((List)localObject1, ((FieldInfo)localObject2).getGenericType());
      if (Types.isArray((Type)localObject3))
      {
        paramString1 = Types.getRawArrayComponentType((List)localObject1, Types.getArrayComponentType((Type)localObject3));
        localArrayValueMap.put(((FieldInfo)localObject2).getField(), paramString1, parseValue(paramString1, (List)localObject1, paramString2));
        return;
      }
      if (Types.isAssignableToOrFrom(Types.getRawArrayComponentType((List)localObject1, (Type)localObject3), Iterable.class))
      {
        paramParseHeaderState = (Collection)((FieldInfo)localObject2).getValue(this);
        paramString1 = paramParseHeaderState;
        if (paramParseHeaderState == null)
        {
          paramParseHeaderState = Data.newCollectionInstance((Type)localObject3);
          paramString1 = paramParseHeaderState;
          ((FieldInfo)localObject2).setValue(this, paramParseHeaderState);
        }
        if (localObject3 == Object.class) {
          paramParseHeaderState = null;
        } else {
          paramParseHeaderState = Types.getIterableParameter((Type)localObject3);
        }
        paramString1.add(parseValue(paramParseHeaderState, (List)localObject1, paramString2));
        return;
      }
      ((FieldInfo)localObject2).setValue(this, parseValue((Type)localObject3, (List)localObject1, paramString2));
      return;
    }
    localObject1 = (ArrayList)get(paramString1);
    paramParseHeaderState = (ParseHeaderState)localObject1;
    if (localObject1 == null)
    {
      paramParseHeaderState = new ArrayList();
      clone(paramString1, paramParseHeaderState);
    }
    paramParseHeaderState.add(paramString2);
  }
  
  public final String remove()
  {
    return (String)getFirstHeaderValue(range);
  }
  
  public HttpHeaders setAccept(String paramString)
  {
    accept = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setAcceptEncoding(String paramString)
  {
    acceptEncoding = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setAge(Long paramLong)
  {
    age = getAsList(paramLong);
    return this;
  }
  
  public HttpHeaders setAuthenticate(String paramString)
  {
    authenticate = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setAuthorization(String paramString)
  {
    return setAuthorization(getAsList(paramString));
  }
  
  public HttpHeaders setAuthorization(List paramList)
  {
    authorization = paramList;
    return this;
  }
  
  public HttpHeaders setBasicAuthentication(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 != null)
      {
        int i = paramString1.length();
        StringBuilder localStringBuilder = new StringBuilder(paramString2.length() + (i + 1));
        localStringBuilder.append(paramString1);
        localStringBuilder.append(":");
        localStringBuilder.append(paramString2);
        paramString1 = String.valueOf(Base64.encodeBase64String(StringUtils.getBytesUtf8(localStringBuilder.toString())));
        if (paramString1.length() != 0) {
          paramString1 = "Basic ".concat(paramString1);
        } else {
          paramString1 = new String("Basic ");
        }
        return setAuthorization(paramString1);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public HttpHeaders setCacheControl(String paramString)
  {
    cacheControl = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setContentEncoding(String paramString)
  {
    contentEncoding = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setContentLength(Long paramLong)
  {
    contentLength = getAsList(paramLong);
    return this;
  }
  
  public HttpHeaders setContentMD5(String paramString)
  {
    contentMD5 = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setContentRange(String paramString)
  {
    contentRange = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setContentType(String paramString)
  {
    contentType = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setCookie(String paramString)
  {
    cookie = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setDate(String paramString)
  {
    date = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setETag(String paramString)
  {
    etag = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setExpires(String paramString)
  {
    expires = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setIfMatch(String paramString)
  {
    ifMatch = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setIfModifiedSince(String paramString)
  {
    ifModifiedSince = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setIfNoneMatch(String paramString)
  {
    ifNoneMatch = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setIfRange(String paramString)
  {
    ifRange = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setIfUnmodifiedSince(String paramString)
  {
    ifUnmodifiedSince = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setLastModified(String paramString)
  {
    lastModified = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setLocation(String paramString)
  {
    location = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setMimeVersion(String paramString)
  {
    mimeVersion = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setRange(String paramString)
  {
    range = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setRetryAfter(String paramString)
  {
    retryAfter = getAsList(paramString);
    return this;
  }
  
  public HttpHeaders setUserAgent(String paramString)
  {
    userAgent = getAsList(paramString);
    return this;
  }
  
  public class HeaderParsingFakeLevelHttpRequest
    extends LowLevelHttpRequest
  {
    public final HttpHeaders.ParseHeaderState state;
    
    public HeaderParsingFakeLevelHttpRequest(HttpHeaders.ParseHeaderState paramParseHeaderState)
    {
      state = paramParseHeaderState;
    }
    
    public void addHeader(String paramString1, String paramString2)
    {
      parseHeader(paramString1, paramString2, state);
    }
    
    public LowLevelHttpResponse execute()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public final class ParseHeaderState
  {
    public final ArrayValueMap arrayValueMap;
    public final ClassInfo classInfo;
    public final List<Type> context;
    public final StringBuilder logger;
    
    public ParseHeaderState(StringBuilder paramStringBuilder)
    {
      Class localClass = this$1.getClass();
      context = Arrays.asList(new Type[] { localClass });
      classInfo = ClassInfo.of(localClass, true);
      logger = paramStringBuilder;
      arrayValueMap = new ArrayValueMap(this$1);
    }
    
    public void finish()
    {
      arrayValueMap.setValues();
    }
  }
}
