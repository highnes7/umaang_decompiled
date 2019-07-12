package f.g.org.org.org.objectweb.asm;

import f.g.org.org.dom4j.asm.AnnotationNode;
import f.g.org.org.dom4j.asm.ByteVector;
import f.g.org.org.dom4j.asm.Settings;
import f.g.org.org.dom4j.asm.e;
import f.g.org.org.http.AnnotationVisitor;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.http.Object;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.util.PemReader;
import f.g.org.org.util.PemReader.Section;
import f.g.org.org.util.SecurityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;

public class Item
  extends ByteVector
{
  public PrivateKey a;
  public String b;
  public String c;
  public String g;
  public Collection<String> h;
  
  public Item()
  {
    super(Settings.getJid());
    a("https://accounts.google.com/o/oauth2/token");
  }
  
  public Item a(e paramE)
  {
    Collection localCollection = c;
    if (paramE != null)
    {
      localCollection.add(paramE);
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item a(AnnotationVisitor paramAnnotationVisitor)
  {
    array = paramAnnotationVisitor;
    return this;
  }
  
  public Item a(GenericUrl paramGenericUrl)
  {
    data = paramGenericUrl;
    return this;
  }
  
  public Item a(HttpTransport paramHttpTransport)
  {
    b = paramHttpTransport;
    return this;
  }
  
  public Item a(Object paramObject)
  {
    buffer = paramObject;
    return this;
  }
  
  public Item a(JsonFactory paramJsonFactory)
  {
    Q = paramJsonFactory;
    return this;
  }
  
  public Item a(f.g.org.org.util.Item paramItem)
  {
    if (paramItem != null)
    {
      g = paramItem;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item a(File paramFile)
    throws GeneralSecurityException, IOException
  {
    a = SecurityUtils.loadPrivateKeyFromKeyStore(SecurityUtils.getPkcs12KeyStore(), new FileInputStream(paramFile), "notasecret", "privatekey", "notasecret");
    return this;
  }
  
  public Item a(String paramString)
  {
    super.a(paramString);
    return (Item)this;
  }
  
  public Item a(String paramString1, String paramString2)
  {
    a(new AnnotationNode(paramString1, paramString2));
    return this;
  }
  
  public Item a(Collection paramCollection)
  {
    h = paramCollection;
    return this;
  }
  
  public f a()
  {
    return new f(this);
  }
  
  public Item b(String paramString)
  {
    c = paramString;
    return this;
  }
  
  public Item b(PrivateKey paramPrivateKey)
  {
    a = paramPrivateKey;
    return this;
  }
  
  public Item b(Collection paramCollection)
  {
    if (paramCollection != null)
    {
      c = paramCollection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Item c(String paramString)
  {
    g = paramString;
    return this;
  }
  
  public final String getId()
  {
    return g;
  }
  
  public final String getName()
  {
    return c;
  }
  
  public final String getOwner()
  {
    return b;
  }
  
  public final Collection getTitle()
  {
    return h;
  }
  
  public Item load(Token paramToken)
  {
    paramToken = paramToken.getDetails();
    a(new AnnotationNode(paramToken.location(), paramToken.getProperty()));
    return this;
  }
  
  public Item load(File paramFile)
    throws GeneralSecurityException, IOException
  {
    paramFile = PemReader.readFirstSectionAndClose(new FileReader(paramFile), "PRIVATE KEY").getBase64DecodedBytes();
    a = SecurityUtils.getRsaKeyFactory().generatePrivate(new PKCS8EncodedKeySpec(paramFile));
    return this;
  }
  
  public final PrivateKey newInvokeDynamic()
  {
    return a;
  }
  
  public Item putByte(String paramString)
  {
    b = paramString;
    return this;
  }
}
