package support.android.v4.asm;

import android.os.Bundle;

public abstract interface TransactionListener
{
  public abstract void d(String paramString, MediaBrowserCompat.MediaBrowserImplBase paramMediaBrowserImplBase);
  
  public abstract Result run(String paramString, int paramInt, Bundle paramBundle);
}
