package f.g.org.org.org.objectweb.asm;

import f.g.b.a.b.b.b.f;
import f.g.b.a.g.z;
import f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions;
import f.g.org.org.stream.JsonFactory;
import java.io.IOException;
import java.io.Reader;

public final class Token
  extends f.g.org.org.stream.Object
{
  @z
  public Document installed;
  @z
  public Document web;
  
  public Token() {}
  
  public static Token load(JsonFactory paramJsonFactory, Reader paramReader)
    throws IOException
  {
    return (Token)paramJsonFactory.fromReader(paramReader, f.class);
  }
  
  public Token clone()
  {
    return (Token)super.clone();
  }
  
  public Token clone(String paramString, Object paramObject)
  {
    return (Token)super.clone(paramString, paramObject);
  }
  
  public Document getDetails()
  {
    Object localObject = web;
    boolean bool = true;
    int i;
    if (localObject == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (installed == null) {
      j = 1;
    } else {
      j = 0;
    }
    if (i == j) {
      bool = false;
    }
    Preconditions.append(bool);
    Document localDocument = web;
    localObject = localDocument;
    if (localDocument == null) {
      localObject = installed;
    }
    return localObject;
  }
  
  public Document getValue()
  {
    return installed;
  }
  
  public Token setPos(Document paramDocument)
  {
    web = paramDocument;
    return this;
  }
  
  public Token setValue(Document paramDocument)
  {
    installed = paramDocument;
    return this;
  }
  
  public Document tag()
  {
    return web;
  }
}
