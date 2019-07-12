package f.g.org.org.org.internal;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.util.ObjectParser;

public abstract class h
{
  public c c;
  public String d;
  public String e;
  public AnnotationVisitor f;
  public boolean h;
  public String j;
  public boolean l;
  public final ObjectParser objectParser;
  public final HttpTransport transport;
  
  public h(HttpTransport paramHttpTransport, String paramString1, String paramString2, ObjectParser paramObjectParser, AnnotationVisitor paramAnnotationVisitor)
  {
    if (paramHttpTransport != null)
    {
      transport = paramHttpTransport;
      objectParser = paramObjectParser;
      c(paramString1);
      a(paramString2);
      f = paramAnnotationVisitor;
      return;
    }
    throw new NullPointerException();
  }
  
  public abstract f a();
  
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
    d = f.valueOf(paramString);
    return this;
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
  
  public final String b()
  {
    return e;
  }
  
  public final c c()
  {
    return c;
  }
  
  public h c(String paramString)
  {
    j = f.append(paramString);
    return this;
  }
  
  public h c(boolean paramBoolean)
  {
    return b(true).a(true);
  }
  
  public final AnnotationVisitor d()
  {
    return f;
  }
  
  public final String e()
  {
    return d;
  }
  
  public final boolean f()
  {
    return h;
  }
  
  public ObjectParser getObjectParser()
  {
    return objectParser;
  }
  
  public final HttpTransport getTransport()
  {
    return transport;
  }
  
  public final String h()
  {
    return j;
  }
  
  public final boolean n()
  {
    return l;
  }
  
  public h setTitle(String paramString)
  {
    e = paramString;
    return this;
  }
}
