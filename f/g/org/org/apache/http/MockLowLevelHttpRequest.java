package f.g.org.org.apache.http;

import f.g.b.a.g.h;
import f.g.org.org.http.HttpMediaType;
import f.g.org.org.http.LowLevelHttpRequest;
import f.g.org.org.http.LowLevelHttpResponse;
import f.g.org.org.util.Charsets;
import f.g.org.org.util.IOUtils;
import f.g.org.org.util.StreamingContent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

@h
public class MockLowLevelHttpRequest
  extends LowLevelHttpRequest
{
  public final Map<String, List<String>> headersMap = new HashMap();
  public MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
  public String url;
  
  public MockLowLevelHttpRequest() {}
  
  public MockLowLevelHttpRequest(String paramString)
  {
    url = paramString;
  }
  
  public void addHeader(String paramString1, String paramString2)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public LowLevelHttpResponse execute()
    throws IOException
  {
    return response;
  }
  
  public String getContentAsString()
    throws IOException
  {
    if (getStreamingContent() == null) {
      return "";
    }
    Object localObject2 = new ByteArrayOutputStream();
    getStreamingContent().writeTo((OutputStream)localObject2);
    String str = getContentEncoding();
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (str.contains("gzip"))
      {
        localObject2 = new GZIPInputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject2).toByteArray()));
        localObject1 = new ByteArrayOutputStream();
        IOUtils.copy((InputStream)localObject2, (OutputStream)localObject1, true);
      }
    }
    localObject2 = getContentType();
    if (localObject2 != null) {
      localObject2 = new HttpMediaType((String)localObject2);
    } else {
      localObject2 = null;
    }
    if ((localObject2 != null) && (((HttpMediaType)localObject2).getCharsetParameter() != null)) {
      localObject2 = ((HttpMediaType)localObject2).getCharsetParameter();
    } else {
      localObject2 = Charsets.ISO_8859_1;
    }
    return ((ByteArrayOutputStream)localObject1).toString(((Charset)localObject2).name());
  }
  
  public String getFirstHeaderValue(String paramString)
  {
    paramString = (List)headersMap.get(paramString.toLowerCase());
    if (paramString == null) {
      return null;
    }
    return (String)paramString.get(0);
  }
  
  public List getHeaderValues(String paramString)
  {
    paramString = (List)headersMap.get(paramString.toLowerCase());
    if (paramString == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(paramString);
  }
  
  public Map getHeaders()
  {
    return Collections.unmodifiableMap(headersMap);
  }
  
  public MockLowLevelHttpResponse getResponse()
  {
    return response;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public MockLowLevelHttpRequest setResponse(MockLowLevelHttpResponse paramMockLowLevelHttpResponse)
  {
    response = paramMockLowLevelHttpResponse;
    return this;
  }
  
  public MockLowLevelHttpRequest setUrl(String paramString)
  {
    url = paramString;
    return this;
  }
}
