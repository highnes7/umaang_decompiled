package f.g.org.org.http;

import f.g.b.a.c.K.a;
import f.g.org.org.util.StreamingContent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class MultipartContent
  extends AbstractHttpContent
{
  public static final String NEWLINE = "\r\n";
  public static final String TWO_DASHES = "--";
  public ArrayList<K.a> parts = new ArrayList();
  
  public MultipartContent()
  {
    super(new HttpMediaType("multipart/related").setParameter("boundary", "__END_OF_PART__"));
  }
  
  public MultipartContent addPart(Part paramPart)
  {
    ArrayList localArrayList = parts;
    if (paramPart != null)
    {
      localArrayList.add(paramPart);
      return this;
    }
    throw new NullPointerException();
  }
  
  public final String getBoundary()
  {
    return getMediaType().getParameter("boundary");
  }
  
  public final Collection getParts()
  {
    return Collections.unmodifiableCollection(parts);
  }
  
  public boolean retrySupported()
  {
    Iterator localIterator = parts.iterator();
    while (localIterator.hasNext()) {
      if (!nextcontent.retrySupported()) {
        return false;
      }
    }
    return true;
  }
  
  public MultipartContent setBoundary(String paramString)
  {
    HttpMediaType localHttpMediaType = getMediaType();
    if (paramString != null)
    {
      localHttpMediaType.setParameter("boundary", paramString);
      return this;
    }
    throw new NullPointerException();
  }
  
  public MultipartContent setContentParts(Collection paramCollection)
  {
    parts = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      addPart(new Part(null, (HttpContent)paramCollection.next()));
    }
    return this;
  }
  
  public MultipartContent setMediaType(HttpMediaType paramHttpMediaType)
  {
    mediaType = paramHttpMediaType;
    return this;
  }
  
  public MultipartContent setParts(Collection paramCollection)
  {
    parts = new ArrayList(paramCollection);
    return this;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(paramOutputStream, getCharset());
    String str = getBoundary();
    Iterator localIterator = parts.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Part)localIterator.next();
      HttpHeaders localHttpHeaders = new HttpHeaders().setAcceptEncoding(null);
      Object localObject1 = headers;
      if (localObject1 != null) {
        localHttpHeaders.fromHttpHeaders((HttpHeaders)localObject1);
      }
      localHttpHeaders.setContentEncoding(null).setUserAgent(null).setContentType(null).setContentLength(null).clone("Content-Transfer-Encoding", null);
      localObject1 = content;
      if (localObject1 != null)
      {
        localHttpHeaders.clone("Content-Transfer-Encoding", Arrays.asList(new String[] { "binary" }));
        localHttpHeaders.setContentType(((HttpContent)localObject1).getType());
        localObject2 = encoding;
        long l;
        if (localObject2 == null)
        {
          l = ((HttpContent)localObject1).getLength();
        }
        else
        {
          localHttpHeaders.setContentEncoding(((HttpEncoding)localObject2).getName());
          localObject2 = new HttpEncodingStreamingContent((StreamingContent)localObject1, (HttpEncoding)localObject2);
          HttpContent localHttpContent = (HttpContent)localObject1;
          localObject1 = localObject2;
          l = AbstractHttpContent.computeLength(localHttpContent);
        }
        localObject2 = localObject1;
        if (l != -1L)
        {
          localHttpHeaders.setContentLength(Long.valueOf(l));
          localObject2 = localObject1;
        }
      }
      else
      {
        localObject2 = null;
      }
      localOutputStreamWriter.write("--");
      localOutputStreamWriter.write(str);
      localOutputStreamWriter.write("\r\n");
      HttpHeaders.serializeHeadersForMultipartRequests(localHttpHeaders, null, null, localOutputStreamWriter);
      if (localObject2 != null)
      {
        localOutputStreamWriter.write("\r\n");
        localOutputStreamWriter.flush();
        ((StreamingContent)localObject2).writeTo(paramOutputStream);
        localOutputStreamWriter.write("\r\n");
      }
    }
    localOutputStreamWriter.write("--");
    localOutputStreamWriter.write(str);
    localOutputStreamWriter.write("--");
    localOutputStreamWriter.write("\r\n");
    localOutputStreamWriter.flush();
  }
  
  public final class Part
  {
    public HttpContent content;
    public HttpEncoding encoding;
    public HttpHeaders headers;
    
    public Part()
    {
      this(null);
    }
    
    public Part()
    {
      this(this$1);
    }
    
    public Part(HttpContent paramHttpContent)
    {
      setHeaders(this$1);
      setContent(paramHttpContent);
    }
    
    public HttpContent getContent()
    {
      return content;
    }
    
    public HttpEncoding getEncoding()
    {
      return encoding;
    }
    
    public HttpHeaders getHeaders()
    {
      return headers;
    }
    
    public Part setContent(HttpContent paramHttpContent)
    {
      content = paramHttpContent;
      return this;
    }
    
    public Part setEncoding(HttpEncoding paramHttpEncoding)
    {
      encoding = paramHttpEncoding;
      return this;
    }
    
    public Part setHeaders(HttpHeaders paramHttpHeaders)
    {
      headers = paramHttpHeaders;
      return this;
    }
  }
}
