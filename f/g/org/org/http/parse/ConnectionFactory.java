package f.g.org.org.http.parse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract interface ConnectionFactory
{
  public abstract HttpURLConnection openConnection(URL paramURL)
    throws IOException, ClassCastException;
}
