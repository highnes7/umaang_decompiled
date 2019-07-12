package f.g.org.org.org.jdom;

import f.g.b.a.a.b.v;
import f.g.b.a.g.h;
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
import java.io.IOException;

@h
public class Subsequence
  extends ClassWriter
{
  public static final String base = "http://metadata/computeMetadata/v1/instance/service-accounts/default/token";
  
  public Subsequence(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
  {
    super(new Label(paramHttpTransport, paramJsonFactory));
  }
  
  public Subsequence(Label paramLabel)
  {
    super(paramLabel);
  }
  
  public Plot execute()
    throws IOException
  {
    Object localObject = new GenericUrl(pop());
    localObject = getValue().createRequestFactory().buildRequest((GenericUrl)localObject);
    ((HttpRequest)localObject).setParser(new JsonObjectParser(intValue()));
    ((HttpRequest)localObject).getHeaders().clone("X-Google-Metadata-Request", Boolean.valueOf(true));
    return (Plot)((HttpRequest)localObject).execute().parseAs(v.class);
  }
}
