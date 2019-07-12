package f.g.org.org.util.store;

import java.io.IOException;

public abstract interface DataStoreFactory
{
  public abstract DataStore getDataStore(String paramString)
    throws IOException;
}
