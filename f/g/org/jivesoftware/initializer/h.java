package f.g.org.jivesoftware.initializer;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.internal.c;
import f.g.org.org.stream.JsonFactory;

public final class h
  extends f.g.org.org.org.internal.util.h
{
  public h(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, AnnotationVisitor paramAnnotationVisitor)
  {
    super(paramHttpTransport, paramJsonFactory, "https://www.googleapis.com/", "bigquery/v2/", paramAnnotationVisitor, false);
  }
  
  public f a()
  {
    return new f(this);
  }
  
  public h a(o paramO)
  {
    c = paramO;
    return this;
  }
  
  public h a(AnnotationVisitor paramAnnotationVisitor)
  {
    f = paramAnnotationVisitor;
    return this;
  }
  
  public h a(c paramC)
  {
    c = paramC;
    return this;
  }
  
  public h a(String paramString)
  {
    return (h)super.a(paramString);
  }
  
  public h a(boolean paramBoolean)
  {
    h = paramBoolean;
    return this;
  }
  
  public h b(boolean paramBoolean)
  {
    l = paramBoolean;
    return this;
  }
  
  public h c(String paramString)
  {
    return (h)super.c(paramString);
  }
  
  public h c(boolean paramBoolean)
  {
    return (h)b(true).a(true);
  }
  
  public h setTitle(String paramString)
  {
    e = paramString;
    return this;
  }
}
