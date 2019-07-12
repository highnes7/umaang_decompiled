package f.g.org.org.org.osmdroid.api;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.internal.c;
import f.g.org.org.util.ObjectParser;

@f.g.b.a.g.h
public class h
  extends f.g.org.org.org.internal.h
{
  public h(HttpTransport paramHttpTransport, String paramString1, String paramString2, ObjectParser paramObjectParser, AnnotationVisitor paramAnnotationVisitor)
  {
    super(paramHttpTransport, paramString1, paramString2, paramObjectParser, paramAnnotationVisitor);
  }
  
  public e a()
  {
    return new e(this);
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
    super.a(paramString);
    return (h)this;
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
    super.c(paramString);
    return (h)this;
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
