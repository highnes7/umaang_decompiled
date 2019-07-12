package f.g.org.org.org.internal.util;

import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.internal.c;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.stream.JsonObjectParser.Builder;
import java.util.Collection;

public abstract class h
  extends f.g.org.org.org.internal.h
{
  public h(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, AnnotationVisitor paramAnnotationVisitor, boolean paramBoolean)
  {
    super(paramHttpTransport, paramString1, paramString2, localBuilder.setWrapperKeys((Collection)paramJsonFactory).build(), paramAnnotationVisitor);
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
  
  public abstract i a();
  
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
  
  public final JsonFactory getJsonFactory()
  {
    return getObjectParser().getJsonFactory();
  }
  
  public final JsonObjectParser getObjectParser()
  {
    return (JsonObjectParser)objectParser;
  }
  
  public h setTitle(String paramString)
  {
    e = paramString;
    return this;
  }
}
