package f.g.org.org.dom4j.asm;

import f.g.b.a.a.b.v;
import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.UrlEncodedContent;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.util.Element;
import f.g.org.org.util.GenericData;
import java.io.IOException;
import java.util.Collection;

public class Buffer
  extends GenericData
{
  public f.g.org.org.http.AnnotationVisitor av;
  public GenericUrl buffer;
  public final HttpTransport bytes;
  public f.g.org.org.http.Object command;
  @z("grant_type")
  public String grantType;
  @z("scope")
  public String scopes;
  public final JsonFactory size;
  
  public Buffer(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, GenericUrl paramGenericUrl, String paramString)
  {
    if (paramHttpTransport != null)
    {
      bytes = paramHttpTransport;
      if (paramJsonFactory != null)
      {
        size = paramJsonFactory;
        setTitle(paramGenericUrl);
        setTitle(paramString);
        return;
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public final HttpResponse authenticate()
    throws IOException
  {
    Object localObject = bytes.createRequestFactory(new AnnotationVisitor(this)).buildPostRequest(buffer, new UrlEncodedContent(this));
    ((HttpRequest)localObject).setParser(new JsonObjectParser(size));
    ((HttpRequest)localObject).setThrowExceptionOnExecuteError(false);
    localObject = ((HttpRequest)localObject).execute();
    if (((HttpResponse)localObject).isSuccessStatusCode()) {
      return localObject;
    }
    throw GeneralRange.from(size, (HttpResponse)localObject);
  }
  
  public Buffer clone(String paramString, Object paramObject)
  {
    super.clone(paramString, paramObject);
    return (Buffer)this;
  }
  
  public final JsonFactory completeSegmentByteCount()
  {
    return size;
  }
  
  public Plot execute()
    throws IOException
  {
    return (Plot)authenticate().parseAs(v.class);
  }
  
  public final f.g.org.org.http.Object getCommand()
  {
    return command;
  }
  
  public final String getFlag()
  {
    return grantType;
  }
  
  public final String getTopic()
  {
    return scopes;
  }
  
  public final f.g.org.org.http.AnnotationVisitor isDisplayed()
  {
    return av;
  }
  
  public final HttpTransport read()
  {
    return bytes;
  }
  
  public final GenericUrl readByte()
  {
    return buffer;
  }
  
  public Buffer setTitle(f.g.org.org.http.AnnotationVisitor paramAnnotationVisitor)
  {
    av = paramAnnotationVisitor;
    return this;
  }
  
  public Buffer setTitle(GenericUrl paramGenericUrl)
  {
    buffer = paramGenericUrl;
    boolean bool;
    if (paramGenericUrl.getFragment() == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.append(bool);
    return this;
  }
  
  public Buffer setTitle(f.g.org.org.http.Object paramObject)
  {
    command = paramObject;
    return this;
  }
  
  public Buffer setTitle(String paramString)
  {
    if (paramString != null)
    {
      grantType = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Buffer setTitle(Collection paramCollection)
  {
    if (paramCollection == null) {
      paramCollection = null;
    } else {
      paramCollection = Element.append(' ').toString(paramCollection);
    }
    scopes = paramCollection;
    return this;
  }
}
