package f.g.org.org.org.osmdroid.api.util;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.internal.c;
import f.g.org.org.stream.JsonFactory;

@f.g.b.a.g.h
public class h
  extends f.g.org.org.org.internal.util.h
{
  public h(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, AnnotationVisitor paramAnnotationVisitor, boolean paramBoolean)
  {
    super(paramHttpTransport, paramJsonFactory, paramString1, paramString2, paramAnnotationVisitor, paramBoolean);
  }
  
  public Type a()
  {
    return new Type(this);
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
