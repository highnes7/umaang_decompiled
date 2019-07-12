package support.android.v4.asm;

import android.os.Bundle;
import java.util.List;

public abstract interface Subscriber
  extends Subscription
{
  public abstract void add(String paramString, List paramList, Bundle paramBundle);
  
  public abstract void e(String paramString, Bundle paramBundle);
}
