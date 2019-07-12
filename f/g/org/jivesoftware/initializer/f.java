package f.g.org.jivesoftware.initializer;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.Item;
import f.g.org.org.org.internal.Element;
import f.g.org.org.org.internal.c;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;

public class f
  extends f.g.org.org.org.internal.util.i
{
  public static final String A = "bigquery/v2/";
  public static final String e = "https://www.googleapis.com/bigquery/v2/";
  public static final String t = "https://www.googleapis.com/";
  
  static
  {
    boolean bool;
    if ((Item.a.intValue() == 1) && (Item.b.intValue() >= 15)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.20.0 of the BigQuery API library.", new Object[] { Item.id });
  }
  
  public f(h paramH)
  {
    super(paramH);
  }
  
  public f(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, AnnotationVisitor paramAnnotationVisitor)
  {
    super(new h(paramHttpTransport, paramJsonFactory, paramAnnotationVisitor));
  }
  
  public g a()
  {
    return new g(this);
  }
  
  public void a(Element paramElement)
    throws IOException
  {
    if (c() != null) {
      c().a(paramElement);
    }
  }
  
  public Attribute createAttribute()
  {
    return new Attribute(this);
  }
  
  public ClassWriter f()
  {
    return new ClassWriter(this);
  }
  
  public Logger getLogger()
  {
    return new Logger(this);
  }
  
  public i p()
  {
    return new i(this);
  }
}
