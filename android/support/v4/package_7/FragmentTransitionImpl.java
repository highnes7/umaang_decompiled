package android.support.v4.package_7;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.b.a.N;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import support.android.v4.view.ViewCompat;
import support.android.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl;

@N({b.b.a.N.a.b})
public abstract class FragmentTransitionImpl
{
  public FragmentTransitionImpl() {}
  
  public static void bfsAddViewChildren(List paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k)) {
      return;
    }
    paramList.add(paramView);
    int i = k;
    while (i < paramList.size())
    {
      paramView = (View)paramList.get(i);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int m = paramView.getChildCount();
        int j = 0;
        while (j < m)
        {
          View localView = paramView.getChildAt(j);
          if (!containedBeforeIndex(paramList, localView, k)) {
            paramList.add(localView);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public static boolean containedBeforeIndex(List paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String findKeyForValue(Map paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  public static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public abstract void addTarget(Object paramObject, View paramView);
  
  public abstract void addTargets(Object paramObject, ArrayList paramArrayList);
  
  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean canHandle(Object paramObject);
  
  public void captureTransitioningViews(ArrayList paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        if (ViewGroupCompat.ViewGroupCompatStubImpl.add(paramView))
        {
          paramArrayList.add(paramView);
          return;
        }
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          captureTransitioningViews(paramArrayList, paramView.getChildAt(i));
          i += 1;
        }
      }
      paramArrayList.add(paramView);
    }
  }
  
  public abstract Object cloneTransition(Object paramObject);
  
  public void findNamedViews(Map paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ViewCompat.a(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          findNamedViews(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  public void getBoundsOnScreen(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[0];
    int m = paramView.getWidth();
    int n = arrayOfInt[1];
    paramRect.set(i, j, m + k, paramView.getHeight() + n);
  }
  
  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public ArrayList prepareSetNameOverridesReordered(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(ViewCompat.a(localView));
      ViewCompat.a(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract void removeTarget(Object paramObject, View paramView);
  
  public abstract void replaceTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public void scheduleNameReset(ViewGroup paramViewGroup, ArrayList paramArrayList, Map paramMap)
  {
    OneShotPreDrawListener.a(paramViewGroup, new FragmentTransitionImpl.3(this, paramArrayList, paramMap));
  }
  
  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3);
  
  public abstract void setEpicenter(Object paramObject, Rect paramRect);
  
  public abstract void setEpicenter(Object paramObject, View paramView);
  
  public void setNameOverridesOrdered(View paramView, ArrayList paramArrayList, Map paramMap)
  {
    OneShotPreDrawListener.a(paramView, new FragmentTransitionImpl.2(this, paramArrayList, paramMap));
  }
  
  public void setNameOverridesReordered(View paramView, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, Map paramMap)
  {
    int k = paramArrayList2.size();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = ViewCompat.a((View)localObject);
      localArrayList.add(str);
      if (str != null)
      {
        ViewCompat.a((View)localObject, null);
        localObject = (String)paramMap.get(str);
        int j = 0;
        while (j < k)
        {
          if (((String)localObject).equals(paramArrayList3.get(j)))
          {
            ViewCompat.a((View)paramArrayList2.get(j), str);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    OneShotPreDrawListener.a(paramView, new FragmentTransitionImpl.1(this, k, paramArrayList2, paramArrayList3, paramArrayList1, localArrayList));
  }
  
  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList);
  
  public abstract void swapSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2);
  
  public abstract Object wrapTransitionInSet(Object paramObject);
}
