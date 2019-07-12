package f.g.org.org.org.objectweb.asm;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.dom4j.asm.AnnotationNode;
import f.g.org.org.dom4j.asm.AnnotationWriter;
import f.g.org.org.dom4j.asm.ResponseHandler;
import f.g.org.org.dom4j.asm.Settings;
import f.g.org.org.dom4j.asm.d;
import f.g.org.org.dom4j.asm.e;
import f.g.org.org.dom4j.asm.f;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.Object;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.Item;
import f.g.org.org.util.store.DataStore;
import f.g.org.org.util.store.DataStoreFactory;
import java.io.IOException;
import java.util.Collection;

public class b
  extends d
{
  public String a;
  public String c;
  
  public b(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, Token paramToken, Collection paramCollection)
  {
    super(Settings.getJid(), paramHttpTransport, paramJsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new AnnotationNode(paramToken.getDetails().location(), paramToken.getDetails().getProperty()), paramToken.getDetails().location(), "https://accounts.google.com/o/oauth2/auth");
    a(paramCollection);
  }
  
  public b(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory, String paramString1, String paramString2, Collection paramCollection)
  {
    super(Settings.getJid(), paramHttpTransport, paramJsonFactory, new GenericUrl("https://accounts.google.com/o/oauth2/token"), new AnnotationNode(paramString1, paramString2), paramString1, "https://accounts.google.com/o/oauth2/auth");
    a(paramCollection);
  }
  
  public b a(AnnotationWriter paramAnnotationWriter)
  {
    n = paramAnnotationWriter;
    return this;
  }
  
  public b a(ResponseHandler paramResponseHandler)
  {
    if (paramResponseHandler != null)
    {
      a = paramResponseHandler;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(e paramE)
  {
    Collection localCollection = m;
    if (paramE != null)
    {
      localCollection.add(paramE);
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(f paramF)
  {
    super.a(paramF);
    return (b)this;
  }
  
  public b a(AnnotationVisitor paramAnnotationVisitor)
  {
    l = paramAnnotationVisitor;
    return this;
  }
  
  public b a(GenericUrl paramGenericUrl)
  {
    if (paramGenericUrl != null)
    {
      f = paramGenericUrl;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(HttpTransport paramHttpTransport)
  {
    if (paramHttpTransport != null)
    {
      c = paramHttpTransport;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(Object paramObject)
  {
    e = paramObject;
    return this;
  }
  
  public b a(JsonFactory paramJsonFactory)
  {
    if (paramJsonFactory != null)
    {
      k = paramJsonFactory;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(Item paramItem)
  {
    if (paramItem != null)
    {
      p = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(DataStore paramDataStore)
  {
    super.a(paramDataStore);
    return (b)this;
  }
  
  public b a(DataStoreFactory paramDataStoreFactory)
    throws IOException
  {
    return (b)super.a(paramDataStoreFactory);
  }
  
  public b a(String paramString)
  {
    if (paramString != null)
    {
      h = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b a(Collection paramCollection)
  {
    Preconditions.set(paramCollection.isEmpty() ^ true);
    s = paramCollection;
    return this;
  }
  
  public i a()
  {
    return new i(this);
  }
  
  public b b(String paramString)
  {
    if (paramString != null)
    {
      b = paramString;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b c(String paramString)
  {
    c = paramString;
    return this;
  }
  
  public b c(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      m = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public b close(String paramString)
  {
    a = paramString;
    return this;
  }
  
  public final String onCreateView()
  {
    return a;
  }
  
  public final String write()
  {
    return c;
  }
}
