package android.support.v4.package_7;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import b.b.a.N;
import b.b.x.n.t;
import support.android.v4.util.SimpleArrayMap;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.c;
import support.android.v4.view.i;
import support.support.asm.BaseFragment;
import support.support.asm.ClassReader;
import support.support.asm.MethodWriter;
import support.support.asm.d;
import support.support.asm.f;

@N({b.b.a.N.a.b})
public class SupportActivity
  extends Activity
  implements d, c
{
  public t<Class<? extends android.support.v4.app.SupportActivity.ExtraData>, android.support.v4.app.SupportActivity.ExtraData> mExtraDataMap = new SimpleArrayMap();
  public MethodWriter mLifecycleRegistry = new MethodWriter(this);
  
  public SupportActivity() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (ViewCompat.a(localView, paramKeyEvent))) {
      return true;
    }
    return i.a(this, localView, this, paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    View localView = getWindow().getDecorView();
    if ((localView != null) && (ViewCompat.a(localView, paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public ExtraData getExtraData(Class paramClass)
  {
    return (ExtraData)mExtraDataMap.get(paramClass);
  }
  
  public ClassReader getLifecycle()
  {
    return mLifecycleRegistry;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    BaseFragment.showDialog(this);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    mLifecycleRegistry.a(f.d);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void putExtraData(ExtraData paramExtraData)
  {
    mExtraDataMap.put(paramExtraData.getClass(), paramExtraData);
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  @N({b.b.a.N.a.b})
  public class ExtraData
  {
    public ExtraData() {}
  }
}
