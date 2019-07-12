package f.g.org.org.org.objectweb.asm;

import f.g.b.a.a.b.v;
import f.g.org.org.dom4j.asm.ClassWriter;
import f.g.org.org.dom4j.asm.Plot;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpHeaders;
import f.g.org.org.http.HttpRequest;
import f.g.org.org.http.HttpRequestFactory;
import f.g.org.org.http.HttpResponse;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.util.ObjectParser;
import java.io.IOException;
import java.io.InputStream;

public class a
  extends f
{
  public static final String t = "http://metadata/computeMetadata/v1/instance/service-accounts/default/token";
  
  public a(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    super(new Item().a(paramHttpTransport).a(paramJsonFactory).a("http://metadata/computeMetadata/v1/instance/service-accounts/default/token"));
  }
  
  public Plot execute()
    throws IOException
  {
    Object localObject1 = new GenericUrl(pop());
    Object localObject2 = getValue().createRequestFactory().buildRequest((GenericUrl)localObject1);
    localObject1 = new JsonObjectParser(intValue());
    ((HttpRequest)localObject2).setParser((ObjectParser)localObject1);
    ((HttpRequest)localObject2).getHeaders().clone("X-Google-Metadata-Request", Boolean.valueOf(true));
    ((HttpRequest)localObject2).setThrowExceptionOnExecuteError(false);
    localObject2 = ((HttpRequest)localObject2).execute();
    int i = ((HttpResponse)localObject2).getStatusCode();
    if (i == 200)
    {
      InputStream localInputStream = ((HttpResponse)localObject2).getContent();
      if (localInputStream != null) {
        return (Plot)((JsonObjectParser)localObject1).parseAndClose(localInputStream, ((HttpResponse)localObject2).getContentCharset(), v.class);
      }
      throw new IOException("Empty content from metadata token server request.");
    }
    if (i == 404) {
      throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified.", new Object[] { Integer.valueOf(i) }));
    }
    throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", new Object[] { Integer.valueOf(i), ((HttpResponse)localObject2).parseAsString() }));
  }
}
