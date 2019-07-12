package f.g.org.org.org.internal;

import f.g.b.a.g.w;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AbstractInputStreamContent;
import f.g.org.org.http.EmptyContent;
import f.g.org.org.http.FormatedText;
import f.g.org.org.http.GZipEncoding;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpContent;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.UriTemplate;
import f.g.org.org.org.client.Buffer;
import f.g.org.org.org.client.ByteVector;
import f.g.org.org.util.GenericData;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Element<T>
  extends w
{
  public static final String CVS_ID = "Google-API-Java-Client";
  public HttpHeaders attributes = new HttpHeaders();
  public Class<T> c;
  public Buffer children;
  public HttpHeaders headers;
  public final String name;
  public final String namespace;
  public ByteVector parent;
  public String prefix;
  public final HttpContent text;
  public final f this$0;
  public int type = -1;
  public boolean value;
  
  public Element(f paramF, String paramString1, String paramString2, HttpContent paramHttpContent, Class paramClass)
  {
    if (paramClass != null)
    {
      c = paramClass;
      if (paramF != null)
      {
        this$0 = paramF;
        if (paramString1 != null)
        {
          name = paramString1;
          if (paramString2 != null)
          {
            namespace = paramString2;
            text = paramHttpContent;
            paramF = paramF.getItem();
            if (paramF != null)
            {
              paramString1 = attributes;
              int i = paramF.length();
              paramString2 = new StringBuilder("Google-API-Java-Client".length() + (i + 1));
              paramString2.append(paramF);
              paramString2.append(" ");
              paramString2.append("Google-API-Java-Client");
              paramString1.setUserAgent(paramString2.toString());
              return;
            }
            attributes.setUserAgent("Google-API-Java-Client");
            return;
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  private HttpResponse execute(boolean paramBoolean)
    throws IOException
  {
    Object localObject2;
    if (children == null)
    {
      localObject2 = put(paramBoolean).execute();
    }
    else
    {
      Object localObject1 = getValue();
      paramBoolean = equals().size().buildRequest(name, (GenericUrl)localObject1, text).getThrowExceptionOnExecuteError();
      HttpResponse localHttpResponse = children.append(attributes).append(value).write((GenericUrl)localObject1);
      localObject1 = localHttpResponse;
      localHttpResponse.getRequest().setParser(equals().e());
      localObject2 = localObject1;
      if (paramBoolean) {
        if (localHttpResponse.isSuccessStatusCode()) {
          localObject2 = localObject1;
        } else {
          throw add(localHttpResponse);
        }
      }
    }
    headers = ((HttpResponse)localObject2).getHeaders();
    type = ((HttpResponse)localObject2).getStatusCode();
    prefix = ((HttpResponse)localObject2).getStatusMessage();
    return localObject2;
  }
  
  private HttpRequest put(boolean paramBoolean)
    throws IOException
  {
    Object localObject = children;
    boolean bool2 = true;
    if (localObject == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.append(bool1);
    boolean bool1 = bool2;
    if (paramBoolean) {
      if (name.equals("GET")) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    Preconditions.append(bool1);
    if (paramBoolean) {
      localObject = "HEAD";
    } else {
      localObject = name;
    }
    localObject = equals().size().buildRequest((String)localObject, getValue(), text);
    new f.g.org.org.org.Request().intercept((HttpRequest)localObject);
    ((HttpRequest)localObject).setParser(equals().e());
    if ((text == null) && ((name.equals("POST")) || (name.equals("PUT")) || (name.equals("PATCH")))) {
      ((HttpRequest)localObject).setContent(new EmptyContent());
    }
    ((HttpRequest)localObject).getHeaders().putAll(attributes);
    if (!value) {
      ((HttpRequest)localObject).setEncoding(new GZipEncoding());
    }
    ((HttpRequest)localObject).setResponseInterceptor(new b(this, ((HttpRequest)localObject).getResponseInterceptor(), (HttpRequest)localObject));
    return localObject;
  }
  
  public IOException add(HttpResponse paramHttpResponse)
  {
    return new FormatedText(paramHttpResponse);
  }
  
  public final void add(f.g.org.org.org.network.f paramF, Class paramClass, f.g.org.org.org.network.Request paramRequest)
    throws IOException
  {
    boolean bool;
    if (children == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Batching media requests is not supported");
    paramF.add(append(), getDeclaringClass(), paramClass, paramRequest);
  }
  
  public HttpRequest append()
    throws IOException
  {
    return put(false);
  }
  
  public final void clear(AbstractInputStreamContent paramAbstractInputStreamContent)
  {
    HttpRequestFactory localHttpRequestFactory = this$0.size();
    children = new Buffer(paramAbstractInputStreamContent, localHttpRequestFactory.getTransport(), localHttpRequestFactory.getInitializer());
    children.write(name);
    paramAbstractInputStreamContent = text;
    if (paramAbstractInputStreamContent != null) {
      children.write(paramAbstractInputStreamContent);
    }
  }
  
  public Element clone(String paramString, Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (Element)this;
  }
  
  public void doSend(OutputStream paramOutputStream)
    throws IOException
  {
    get().execute(paramOutputStream);
  }
  
  public f equals()
  {
    return this$0;
  }
  
  public Object execute()
    throws IOException
  {
    return get().parseAs(c);
  }
  
  public HttpResponse get()
    throws IOException
  {
    return execute(false);
  }
  
  public final String getAttributeNamespace()
  {
    return namespace;
  }
  
  public final HttpHeaders getAttributeValue()
  {
    return attributes;
  }
  
  public final Buffer getChild()
  {
    return children;
  }
  
  public InputStream getContent()
    throws IOException
  {
    return get().getContent();
  }
  
  public final Class getDeclaringClass()
  {
    return c;
  }
  
  public HttpRequest getElementById()
    throws IOException
  {
    return put(true);
  }
  
  public final HttpHeaders getHeaders()
  {
    return headers;
  }
  
  public final String getName()
  {
    return name;
  }
  
  public final String getNamespacePrefix()
  {
    return prefix;
  }
  
  public final ByteVector getRoot()
  {
    return parent;
  }
  
  public GenericUrl getValue()
  {
    return new GenericUrl(UriTemplate.expand(this$0.getText(), namespace, this, true));
  }
  
  public HttpResponse init()
    throws IOException
  {
    clone("alt", "media");
    return get();
  }
  
  public final boolean next()
  {
    return value;
  }
  
  public InputStream read()
    throws IOException
  {
    return init().getContent();
  }
  
  public final void readObject()
  {
    HttpRequestFactory localHttpRequestFactory = this$0.size();
    parent = new ByteVector(localHttpRequestFactory.getTransport(), localHttpRequestFactory.getInitializer());
  }
  
  public HttpResponse revalidateCacheEntry()
    throws IOException
  {
    boolean bool;
    if (children == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    HttpResponse localHttpResponse = execute(true);
    localHttpResponse.ignore();
    return localHttpResponse;
  }
  
  public Element setAttribute(HttpHeaders paramHttpHeaders)
  {
    attributes = paramHttpHeaders;
    return this;
  }
  
  public Element setAttributes(boolean paramBoolean)
  {
    value = paramBoolean;
    return this;
  }
  
  public final HttpContent setText()
  {
    return text;
  }
  
  public final int type()
  {
    return type;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    ByteVector localByteVector = parent;
    if (localByteVector == null)
    {
      init().execute(paramOutputStream);
      return;
    }
    localByteVector.read(getValue(), attributes, paramOutputStream);
  }
  
  public final void write(Object paramObject, String paramString)
  {
    boolean bool;
    if ((!this$0.add()) && (paramObject == null)) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.checkArgument(bool, "Required parameter %s must be specified", new Object[] { paramString });
  }
}
