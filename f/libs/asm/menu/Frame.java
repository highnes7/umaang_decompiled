package f.libs.asm.menu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

public class Frame
{
  public static final IntentFilter d = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
  public static final IntentFilter g = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  public static final IntentFilter h = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
  public final AtomicBoolean a;
  public final BroadcastReceiver b;
  public boolean c;
  public final Context e;
  public final BroadcastReceiver i;
  
  public Frame(Context paramContext)
  {
    e = paramContext;
    i = new WalletTransactionsFragment.TransactionsLoader.2(this);
    b = new AndroidRouter.ConnectivityBroadcastReceiver(this);
    a = new AtomicBoolean(false);
  }
  
  public void a()
  {
    if (!a.getAndSet(false)) {
      return;
    }
    e.unregisterReceiver(i);
    e.unregisterReceiver(b);
  }
  
  public boolean c()
  {
    return c;
  }
  
  public void init()
  {
    Object localObject = a;
    boolean bool2 = true;
    if (((AtomicBoolean)localObject).getAndSet(true)) {
      return;
    }
    localObject = e.registerReceiver(null, g);
    int j = -1;
    if (localObject != null) {
      j = ((Intent)localObject).getIntExtra("status", -1);
    }
    boolean bool1 = bool2;
    if (j != 2) {
      if (j == 5) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    c = bool1;
    e.registerReceiver(i, d);
    e.registerReceiver(b, h);
  }
}
