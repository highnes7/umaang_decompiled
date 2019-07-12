package f.g.org.org.org.objectweb.asm;

import f.g.b.a.d.b;
import f.g.b.a.g.h;
import f.g.org.org.dom4j.asm.Buffer;
import f.g.org.org.dom4j.asm.Plot;
import f.g.org.org.http.GenericUrl;
import f.g.org.org.http.HttpTransport;
import f.g.org.org.org.tree.Label;
import f.g.org.org.org.tree.i;
import f.g.org.org.stream.JsonFactory;
import f.g.org.org.stream.JsonObjectParser;
import f.g.org.org.stream.digests.JsonWebSignature;
import f.g.org.org.stream.digests.JsonWebSignature.Header;
import f.g.org.org.stream.digests.JsonWebToken.Payload;
import f.g.org.org.util.Element;
import f.g.org.org.util.GenericData;
import f.g.org.org.util.PemReader;
import f.g.org.org.util.PemReader.Section;
import f.g.org.org.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import java.util.Collections;

public class f
  extends f.g.org.org.dom4j.asm.ClassWriter
{
  public static final String A = "service_account";
  @h
  public static MethodWriter D = new MethodWriter();
  public static final String t = "authorized_user";
  public PrivateKey a;
  public String b;
  public Collection<String> c;
  public String g;
  public String h;
  
  public f()
  {
    this(new Item());
  }
  
  public f(Item paramItem)
  {
    super(paramItem);
    if (a == null)
    {
      boolean bool;
      if ((c == null) && (h == null) && (g == null)) {
        bool = true;
      } else {
        bool = false;
      }
      f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.append(bool);
      return;
    }
    String str = c;
    f.g.org.org.util.Preconditions.append(str);
    h = ((String)str);
    c = Collections.unmodifiableCollection(h);
    a = a;
    b = b;
    g = g;
  }
  
  public static f a(HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    if (paramHttpTransport != null)
    {
      if (paramJsonFactory != null) {
        return D.a(paramHttpTransport, paramJsonFactory);
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static f a(f.g.org.org.stream.Object paramObject, HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    String str1 = (String)paramObject.get("client_id");
    String str2 = (String)paramObject.get("client_secret");
    paramObject = (String)paramObject.get("refresh_token");
    if ((str1 != null) && (str2 != null) && (paramObject != null))
    {
      paramHttpTransport = new Item().a(str1, str2).a(paramHttpTransport).a(paramJsonFactory).a();
      paramHttpTransport.put(paramObject);
      paramHttpTransport.add();
      return paramHttpTransport;
    }
    throw new IOException("Error reading user credential from stream,  expecting 'client_id', 'client_secret' and 'refresh_token'.");
  }
  
  public static f a(InputStream paramInputStream)
    throws IOException
  {
    return a(paramInputStream, Label.d, i.c);
  }
  
  public static f a(InputStream paramInputStream, HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramHttpTransport != null)
      {
        if (paramJsonFactory != null)
        {
          paramInputStream = (f.g.org.org.stream.Object)new JsonObjectParser(paramJsonFactory).parseAndClose(paramInputStream, ClassWriter.UTF8, b.class);
          String str = (String)paramInputStream.get("type");
          if (str != null)
          {
            if ("authorized_user".equals(str)) {
              return a(paramInputStream, paramHttpTransport, paramJsonFactory);
            }
            if ("service_account".equals(str)) {
              return run(paramInputStream, paramHttpTransport, paramJsonFactory);
            }
            throw new IOException(String.format("Error reading credentials from stream, 'type' value '%s' not recognized. Expecting '%s' or '%s'.", new Object[] { str, "authorized_user", "service_account" }));
          }
          throw new IOException("Error reading credentials from stream, 'type' field not specified.");
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public static f e()
    throws IOException
  {
    return a(Label.d, i.c);
  }
  
  public static PrivateKey init(String paramString)
    throws IOException
  {
    paramString = PemReader.readFirstSectionAndClose(new StringReader(paramString), "PRIVATE KEY");
    if (paramString != null)
    {
      paramString = new PKCS8EncodedKeySpec(paramString.getBase64DecodedBytes());
      try
      {
        paramString = SecurityUtils.getRsaKeyFactory().generatePrivate(paramString);
        return paramString;
      }
      catch (InvalidKeySpecException paramString) {}catch (NoSuchAlgorithmException paramString) {}
      IOException localIOException = new IOException("Unexpected exception reading PKCS data");
      ClassWriter.get(localIOException, paramString);
      throw ((IOException)localIOException);
    }
    throw new IOException("Invalid PKCS8 data.");
  }
  
  public static f run(f.g.org.org.stream.Object paramObject, HttpTransport paramHttpTransport, JsonFactory paramJsonFactory)
    throws IOException
  {
    Object localObject1 = (String)paramObject.get("client_id");
    String str = (String)paramObject.get("client_email");
    Object localObject2 = (String)paramObject.get("private_key");
    paramObject = (String)paramObject.get("private_key_id");
    if ((localObject1 != null) && (str != null) && (localObject2 != null) && (paramObject != null))
    {
      localObject1 = init((String)localObject2);
      localObject2 = Collections.emptyList();
      return new Item().a(paramHttpTransport).a(paramJsonFactory).b(str).a((Collection)localObject2).b((PrivateKey)localObject1).putByte(paramObject).a();
    }
    throw new IOException("Error reading service account credential from stream, expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
  }
  
  public f a(Plot paramPlot)
  {
    super.a(paramPlot);
    return (f)this;
  }
  
  public f a(Long paramLong)
  {
    super.a(paramLong);
    return (f)this;
  }
  
  public f a(String paramString)
  {
    super.a(paramString);
    return (f)this;
  }
  
  public f a(Collection paramCollection)
  {
    if (a == null) {
      return this;
    }
    return new Item().b(a).putByte(b).b(h).c(g).a(paramCollection).a(getValue()).a(intValue()).a(a()).a();
  }
  
  public f add(Long paramLong)
  {
    return (f)super.add(paramLong);
  }
  
  public boolean b()
  {
    if (a == null) {
      return false;
    }
    Collection localCollection = c;
    return (localCollection == null) || (localCollection.isEmpty());
  }
  
  public final String d()
  {
    if (c == null) {
      return null;
    }
    return Element.append(' ').toString(c);
  }
  
  public Plot execute()
    throws IOException
  {
    if (a == null) {
      return super.execute();
    }
    Object localObject1 = new JsonWebSignature.Header();
    ((JsonWebSignature.Header)localObject1).setAlgorithm("RS256");
    ((JsonWebSignature.Header)localObject1).setType("JWT");
    ((JsonWebSignature.Header)localObject1).setKeyId(b);
    Object localObject2 = new JsonWebToken.Payload();
    long l = a().currentTimeMillis();
    ((JsonWebToken.Payload)localObject2).clone(h);
    ((JsonWebToken.Payload)localObject2).set(pop());
    l /= 1000L;
    ((JsonWebToken.Payload)localObject2).set(Long.valueOf(l));
    ((JsonWebToken.Payload)localObject2).get(Long.valueOf(l + 3600L));
    ((JsonWebToken.Payload)localObject2).get(g);
    ((GenericData)localObject2).put("scope", Element.append(' ').toString(c));
    Object localObject3 = a;
    try
    {
      localObject1 = JsonWebSignature.signUsingRsaSha256((PrivateKey)localObject3, intValue(), (JsonWebSignature.Header)localObject1, (JsonWebToken.Payload)localObject2);
      localObject2 = getValue();
      localObject3 = intValue();
      localObject2 = new Buffer((HttpTransport)localObject2, (JsonFactory)localObject3, new GenericUrl(pop()), "urn:ietf:params:oauth:grant-type:jwt-bearer");
      ((GenericData)localObject2).put("assertion", localObject1);
      localObject1 = ((Buffer)localObject2).execute();
      return localObject1;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject2 = new IOException();
      ((IOException)localObject2).initCause(localGeneralSecurityException);
      throw ((Throwable)localObject2);
    }
  }
  
  public final String f()
  {
    return h;
  }
  
  public final String getIntent()
  {
    return g;
  }
  
  public final PrivateKey n()
  {
    return a;
  }
  
  public final String o()
  {
    return b;
  }
  
  public final Collection p()
  {
    return c;
  }
  
  public f put(String paramString)
  {
    if (paramString != null)
    {
      boolean bool;
      if ((intValue() != null) && (getValue() != null) && (put() != null)) {
        bool = true;
      } else {
        bool = false;
      }
      f.g.org.org.codehaus.libs.objectweb.asm.asm.Preconditions.checkArgument(bool, "Please use the Builder and call setJsonFactory, setTransport and setClientSecrets");
    }
    super.put(paramString);
    return (f)this;
  }
}
