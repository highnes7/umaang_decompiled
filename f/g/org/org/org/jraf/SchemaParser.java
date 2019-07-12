package f.g.org.org.org.jraf;

import f.g.org.org.http.gzip.ApacheHttpTransport;
import f.g.org.org.http.gzip.ApacheHttpTransport.Builder;
import f.g.org.org.org.Item;
import java.io.IOException;
import java.security.GeneralSecurityException;

public final class SchemaParser
{
  public SchemaParser() {}
  
  public static ApacheHttpTransport build()
    throws GeneralSecurityException, IOException
  {
    return new ApacheHttpTransport.Builder().trustCertificates(Item.getTag()).build();
  }
}
