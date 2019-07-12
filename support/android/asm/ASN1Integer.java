package support.android.asm;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.support.transition.TransitionSet;
import android.support.v4.package_7.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import b.b.a.N;
import java.util.ArrayList;
import java.util.List;

@N({b.b.a.N.a.b})
public class ASN1Integer
  extends FragmentTransitionImpl
{
  public ASN1Integer() {}
  
  public static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetIds())) || (!FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetNames())) || (!FragmentTransitionImpl.isNullOrEmpty(paramTransition.getTargetTypes()));
  }
  
  public void addTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
  }
  
  public void addTargets(Object paramObject, ArrayList paramArrayList)
  {
    paramObject = (Transition)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.size();
      while (i < j)
      {
        addTargets(paramObject.get(i), paramArrayList);
        i += 1;
      }
    }
    if ((!hasSimpleTarget(paramObject)) && (FragmentTransitionImpl.isNullOrEmpty(paramObject.getTargets())))
    {
      int k = paramArrayList.size();
      i = j;
      while (i < k)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    ClassWriter.a(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean canHandle(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object cloneTransition(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).clone();
    }
    return null;
  }
  
  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().add(paramObject1).add(paramObject2).a(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.add(paramObject1);
      }
      paramObject2.add(paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.add((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.add((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.add((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void removeTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
  }
  
  public void replaceTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (Transition)paramObject;
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.size();
      while (i < j)
      {
        replaceTargets(paramObject.get(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!hasSimpleTarget(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        }
        while (j < i)
        {
          paramObject.addTarget((View)paramArrayList2.get(j));
          j += 1;
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    ((Transition)paramObject).addListener(new ActionMenuItemView(this, paramView, paramArrayList));
  }
  
  public void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList paramArrayList1, Object paramObject3, ArrayList paramArrayList2, Object paramObject4, ArrayList paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new m(this, paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void setEpicenter(Object paramObject, Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new ByteVector(this, paramRect));
    }
  }
  
  public void setEpicenter(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      Rect localRect = new Rect();
      getBoundsOnScreen(paramView, localRect);
      paramObject.setEpicenterCallback(new ClassReader(this, localRect));
    }
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.getTargets();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      FragmentTransitionImpl.bfsAddViewChildren(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public void swapSharedElementTargets(Object paramObject, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object wrapTransitionInSet(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.add((Transition)paramObject);
    return localTransitionSet;
  }
}
