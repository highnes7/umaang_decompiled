package support.android.asm;

import android.support.transition.AutoTransition;
import android.support.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b.b.v.O;
import b.b.x.n.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.SimpleArrayMap;
import support.android.v4.view.ViewCompat;

public class ClassWriter
{
  public static ArrayList<ViewGroup> a = new ArrayList();
  public static Transition c = new AutoTransition();
  public static final String d = "TransitionManager";
  public static ThreadLocal<WeakReference<b<ViewGroup, ArrayList<Transition>>>> t = new ThreadLocal();
  public b<O, Transition> g = new ArrayMap();
  public b<O, b<O, Transition>> m = new ArrayMap();
  
  public ClassWriter() {}
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!a.contains(paramViewGroup)) && (ViewCompat.isLaidOut(paramViewGroup)))
    {
      a.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = c;
      }
      paramTransition = localTransition.clone();
      put(paramViewGroup, paramTransition);
      paramViewGroup.setTag(R.id.transition_current_scene, null);
      show(paramViewGroup, paramTransition);
    }
  }
  
  public static void a(Label paramLabel)
  {
    a(paramLabel, c);
  }
  
  public static void a(Label paramLabel, Transition paramTransition)
  {
    ViewGroup localViewGroup = paramLabel.getText();
    if (!a.contains(localViewGroup))
    {
      if (paramTransition == null)
      {
        paramLabel.a();
        return;
      }
      a.add(localViewGroup);
      paramTransition = paramTransition.clone();
      paramTransition.setSceneRoot(localViewGroup);
      Label localLabel = Label.a(localViewGroup);
      if ((localLabel != null) && (localLabel.c())) {
        paramTransition.setCanRemoveViews(true);
      }
      put(localViewGroup, paramTransition);
      paramLabel.a();
      show(localViewGroup, paramTransition);
    }
  }
  
  private Transition b(Label paramLabel)
  {
    Object localObject = paramLabel.getText();
    if (localObject != null)
    {
      localObject = Label.a((View)localObject);
      if (localObject != null)
      {
        ArrayMap localArrayMap = (ArrayMap)m.get(paramLabel);
        if (localArrayMap != null)
        {
          localObject = (Transition)localArrayMap.get(localObject);
          if (localObject != null) {
            return localObject;
          }
        }
      }
    }
    paramLabel = (Transition)g.get(paramLabel);
    if (paramLabel != null) {
      return paramLabel;
    }
    return c;
  }
  
  public static void b(ViewGroup paramViewGroup)
  {
    a(paramViewGroup, null);
  }
  
  public static void b(Label paramLabel, Transition paramTransition)
  {
    a(paramLabel, paramTransition);
  }
  
  public static ArrayMap get()
  {
    Object localObject = (WeakReference)t.get();
    if (localObject != null)
    {
      localObject = (ArrayMap)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new ArrayMap();
    WeakReference localWeakReference = new WeakReference(localObject);
    t.set(localWeakReference);
    return localObject;
  }
  
  public static void put(ViewGroup paramViewGroup)
  {
    a.remove(paramViewGroup);
    ArrayList localArrayList = (ArrayList)get().get(paramViewGroup);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localArrayList = new ArrayList(localArrayList);
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        ((Transition)localArrayList.get(i)).forceToEnd(paramViewGroup);
        i -= 1;
      }
    }
  }
  
  public static void put(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)get().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).pause(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.captureValues(paramViewGroup, true);
    }
    paramViewGroup = Label.a(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.b();
    }
  }
  
  public static void show(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new ea.a(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
  
  public void c(Label paramLabel)
  {
    a(paramLabel, b(paramLabel));
  }
  
  public void get(Label paramLabel, Transition paramTransition)
  {
    g.put(paramLabel, paramTransition);
  }
  
  public void put(Label paramLabel1, Label paramLabel2, Transition paramTransition)
  {
    ArrayMap localArrayMap2 = (ArrayMap)m.get(paramLabel2);
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      m.put(paramLabel2, localArrayMap1);
    }
    localArrayMap1.put(paramLabel1, paramTransition);
  }
}
