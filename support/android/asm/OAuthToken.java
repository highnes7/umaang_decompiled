package support.android.asm;

import android.os.IBinder;

public class OAuthToken
  implements Object
{
  public final IBinder token;
  
  public OAuthToken(IBinder paramIBinder)
  {
    token = paramIBinder;
  }
  
  public boolean equals(java.lang.Object paramObject)
  {
    return ((paramObject instanceof OAuthToken)) && (token.equals(token));
  }
  
  public int hashCode()
  {
    return token.hashCode();
  }
}
