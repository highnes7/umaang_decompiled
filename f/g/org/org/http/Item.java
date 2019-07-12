package f.g.org.org.http;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.util.StringUtils;
import java.io.IOException;

public class Item
{
  public int a;
  public String b;
  public HttpHeaders c;
  public String content;
  public String g;
  
  public Item(int paramInt, String paramString, HttpHeaders paramHttpHeaders)
  {
    set(paramInt);
    a(paramString);
    a(paramHttpHeaders);
  }
  
  public Item(HttpResponse paramHttpResponse)
  {
    this(paramHttpResponse.getStatusCode(), paramHttpResponse.getStatusMessage(), paramHttpResponse.getHeaders());
    try
    {
      String str = paramHttpResponse.parseAsString();
      content = str;
      str = content;
      int i = str.length();
      if (i == 0) {
        content = null;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    paramHttpResponse = FormatedText.computeMessageBuffer(paramHttpResponse);
    if (content != null)
    {
      paramHttpResponse.append(StringUtils.LINE_SEPARATOR);
      paramHttpResponse.append(content);
    }
    b = paramHttpResponse.toString();
  }
  
  public Item a(HttpHeaders paramHttpHeaders)
  {
    if (paramHttpHeaders != null)
    {
      c = paramHttpHeaders;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item a(String paramString)
  {
    g = paramString;
    return this;
  }
  
  public final String a()
  {
    return g;
  }
  
  public FormatedText bold()
  {
    return new FormatedText(this);
  }
  
  public final String getContent()
  {
    return content;
  }
  
  public final String getOwner()
  {
    return b;
  }
  
  public final int getTitle()
  {
    return a;
  }
  
  public Item put(String paramString)
  {
    b = paramString;
    return this;
  }
  
  public HttpHeaders set()
  {
    return c;
  }
  
  public Item set(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    a = paramInt;
    return this;
  }
  
  public Item setContent(String paramString)
  {
    content = paramString;
    return this;
  }
}
