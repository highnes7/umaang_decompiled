package support.android.v4.view;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.b.a.G;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import support.android.internal.R.id;

public class g
{
  public static final ArrayList<WeakReference<View>> c = new ArrayList();
  @G
  public WeakHashMap<View, Boolean> a = null;
  public SparseArray<WeakReference<View>> b = null;
  public WeakReference<KeyEvent> d = null;
  
  public g() {}
  
  private void a()
  {
    Object localObject = a;
    if (localObject != null) {
      ((WeakHashMap)localObject).clear();
    }
    if (c.isEmpty()) {
      return;
    }
    ArrayList localArrayList = c;
    for (;;)
    {
      int i;
      try
      {
        if (a == null) {
          a = new WeakHashMap();
        }
        i = c.size() - 1;
        if (i >= 0)
        {
          localObject = (View)((WeakReference)c.get(i)).get();
          if (localObject == null)
          {
            c.remove(i);
          }
          else
          {
            a.put(localObject, Boolean.TRUE);
            localObject = ((View)localObject).getParent();
            if ((localObject instanceof View))
            {
              a.put((View)localObject, Boolean.TRUE);
              localObject = ((ViewParent)localObject).getParent();
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      i -= 1;
    }
  }
  
  public static void a(View paramView)
  {
    ArrayList localArrayList = c;
    try
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramView) {
          return;
        }
      }
      c.add(new WeakReference(paramView));
      return;
    }
    catch (Throwable paramView)
    {
      throw paramView;
    }
  }
  
  private SparseArray b()
  {
    if (b == null) {
      b = new SparseArray();
    }
    return b;
  }
  
  private View b(View paramView, KeyEvent paramKeyEvent)
  {
    Object localObject = a;
    if (localObject != null)
    {
      if (!((WeakHashMap)localObject).containsKey(paramView)) {
        return null;
      }
      if ((paramView instanceof ViewGroup))
      {
        localObject = (ViewGroup)paramView;
        int i = ((ViewGroup)localObject).getChildCount() - 1;
        while (i >= 0)
        {
          View localView = b(((ViewGroup)localObject).getChildAt(i), paramKeyEvent);
          if (localView != null) {
            return localView;
          }
          i -= 1;
        }
      }
      if (c(paramView, paramKeyEvent)) {
        return paramView;
      }
    }
    return null;
  }
  
  public static g b(View paramView)
  {
    g localG2 = (g)paramView.getTag(R.id.tag_unhandled_key_event_manager);
    g localG1 = localG2;
    if (localG2 == null)
    {
      localG1 = new g();
      paramView.setTag(R.id.tag_unhandled_key_event_manager, localG1);
    }
    return localG1;
  }
  
  public static void c(View paramView)
  {
    ArrayList localArrayList = c;
    int i = 0;
    try
    {
      while (i < c.size())
      {
        if (((WeakReference)c.get(i)).get() == paramView)
        {
          c.remove(i);
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramView)
    {
      throw paramView;
    }
  }
  
  private boolean c(View paramView, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
    if (localArrayList != null)
    {
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        if (((x)localArrayList.get(i)).onUnhandledKeyEvent(paramView, paramKeyEvent)) {
          return true;
        }
        i -= 1;
      }
    }
    return false;
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    Object localObject1 = d;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() == paramKeyEvent)) {
      return false;
    }
    d = new WeakReference(paramKeyEvent);
    Object localObject2 = null;
    SparseArray localSparseArray = b();
    localObject1 = localObject2;
    if (paramKeyEvent.getAction() == 1)
    {
      int i = localSparseArray.indexOfKey(paramKeyEvent.getKeyCode());
      localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = (WeakReference)localSparseArray.valueAt(i);
        localSparseArray.removeAt(i);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (WeakReference)localSparseArray.get(paramKeyEvent.getKeyCode());
    }
    if (localObject2 != null)
    {
      localObject1 = (View)((WeakReference)localObject2).get();
      if ((localObject1 != null) && (ViewCompat.cancel((View)localObject1)))
      {
        c((View)localObject1, paramKeyEvent);
        return true;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  public boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0) {
      a();
    }
    paramView = b(paramView, paramKeyEvent);
    if (paramKeyEvent.getAction() == 0)
    {
      int i = paramKeyEvent.getKeyCode();
      if ((paramView != null) && (!KeyEvent.isModifierKey(i))) {
        b().put(i, new WeakReference(paramView));
      }
    }
    return paramView != null;
  }
}
