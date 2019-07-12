package f.g.org.org.org.fdroid;

import f.g.org.org.http.parse.NetHttpTransport;
import f.g.org.org.http.parse.NetHttpTransport.Builder;
import f.g.org.org.org.Item;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class SchemaParser
{
  public SchemaParser() {}
  
  public static NetHttpTransport build()
    throws GeneralSecurityException, IOException
  {
    return new NetHttpTransport.Builder().trustCertificates(Item.getTag()).build();
  }
}
