package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import support.android.asm.Attribute;
import support.android.asm.Edit;
import support.android.asm.FieldWriter;
import support.android.asm.Graph;
import support.android.asm.R.styleable;
import support.android.asm.f;
import support.android.v4.content.asm.TypedArrayUtils;

public class TransitionSet
  extends Transition
{
  public static final int BUTTON_WEEK_INDEX = 1;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int FORMAT_ISO_8859_7 = 8;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int QUIET_HOURS_DEFAULT_END_MINUTE = 0;
  public static final int WEEKS_BUFFER = 1;
  public boolean b = false;
  public boolean e = true;
  public int hash = 0;
  public int n;
  public ArrayList<Transition> next = new ArrayList();
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockActionMenuItemView);
    a(TypedArrayUtils.getString(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  private void init()
  {
    a localA = new a(this);
    Iterator localIterator = next.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).addListener(localA);
    }
    n = next.size();
  }
  
  public TransitionSet a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        e = false;
        return this;
      }
      throw new AndroidRuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Invalid parameter for TransitionSet ordering: ", paramInt));
    }
    e = true;
    return this;
  }
  
  public TransitionSet add(Transition paramTransition)
  {
    next.add(paramTransition);
    mParent = this;
    long l = mDuration;
    if (l >= 0L) {
      paramTransition.setDuration(l);
    }
    if ((hash & 0x1) != 0) {
      paramTransition.setInterpolator(getInterpolator());
    }
    if ((hash & 0x2) != 0) {
      paramTransition.setPropagation(getPropagation());
    }
    if ((hash & 0x4) != 0) {
      paramTransition.setPathMotion(getPathMotion());
    }
    if ((hash & 0x8) != 0) {
      paramTransition.setEpicenterCallback(getEpicenterCallback());
    }
    return this;
  }
  
  public TransitionSet addListener(Transition.e paramE)
  {
    super.addListener(paramE);
    return (TransitionSet)this;
  }
  
  public TransitionSet addTarget(int paramInt)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).addTarget(paramInt);
      i += 1;
    }
    super.addTarget(paramInt);
    return (TransitionSet)this;
  }
  
  public TransitionSet addTarget(View paramView)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).addTarget(paramView);
      i += 1;
    }
    mTargets.add(paramView);
    return this;
  }
  
  public TransitionSet addTarget(Class paramClass)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).addTarget(paramClass);
      i += 1;
    }
    super.addTarget(paramClass);
    return (TransitionSet)this;
  }
  
  public TransitionSet addTarget(String paramString)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).addTarget(paramString);
      i += 1;
    }
    super.addTarget(paramString);
    return (TransitionSet)this;
  }
  
  public void cancel()
  {
    super.cancel();
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).cancel();
      i += 1;
    }
  }
  
  public void captureEndValues(Edit paramEdit)
  {
    if (isValidTarget(view))
    {
      Iterator localIterator = next.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(view))
        {
          localTransition.captureEndValues(paramEdit);
          added.add(localTransition);
        }
      }
    }
  }
  
  public void capturePropagationValues(Edit paramEdit)
  {
    super.capturePropagationValues(paramEdit);
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).capturePropagationValues(paramEdit);
      i += 1;
    }
  }
  
  public void captureStartValues(Edit paramEdit)
  {
    if (isValidTarget(view))
    {
      Iterator localIterator = next.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.isValidTarget(view))
        {
          localTransition.captureStartValues(paramEdit);
          added.add(localTransition);
        }
      }
    }
  }
  
  public Transition clone()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.clone();
    next = new ArrayList();
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.add(((Transition)next.get(i)).clone());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public void createAnimators(ViewGroup paramViewGroup, Graph paramGraph1, Graph paramGraph2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    long l1 = getStartDelay();
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      Transition localTransition = (Transition)next.get(i);
      if ((l1 > 0L) && ((e) || (i == 0)))
      {
        long l2 = localTransition.getStartDelay();
        if (l2 > 0L) {
          localTransition.setStartDelay(l2 + l1);
        } else {
          localTransition.setStartDelay(l1);
        }
      }
      localTransition.createAnimators(paramViewGroup, paramGraph1, paramGraph2, paramArrayList1, paramArrayList2);
      i += 1;
    }
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).excludeTarget(paramInt, paramBoolean);
      i += 1;
    }
    super.excludeTarget(paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).excludeTarget(paramView, paramBoolean);
      i += 1;
    }
    super.excludeTarget(paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(Class paramClass, boolean paramBoolean)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).excludeTarget(paramClass, paramBoolean);
      i += 1;
    }
    super.excludeTarget(paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).excludeTarget(paramString, paramBoolean);
      i += 1;
    }
    mTargetNameExcludes = Transition.excludeObject(mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  public void forceToEnd(ViewGroup paramViewGroup)
  {
    super.forceToEnd(paramViewGroup);
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).forceToEnd(paramViewGroup);
      i += 1;
    }
  }
  
  public Transition get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < next.size())) {
      return (Transition)next.get(paramInt);
    }
    return null;
  }
  
  public int multiply()
  {
    return e ^ true;
  }
  
  public void pause(View paramView)
  {
    super.pause(paramView);
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).pause(paramView);
      i += 1;
    }
  }
  
  public TransitionSet removeListener(Transition.e paramE)
  {
    super.removeListener(paramE);
    return (TransitionSet)this;
  }
  
  public TransitionSet removeTarget(int paramInt)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).removeTarget(paramInt);
      i += 1;
    }
    super.removeTarget(paramInt);
    return (TransitionSet)this;
  }
  
  public TransitionSet removeTarget(View paramView)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).removeTarget(paramView);
      i += 1;
    }
    mTargets.remove(paramView);
    return this;
  }
  
  public TransitionSet removeTarget(Class paramClass)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).removeTarget(paramClass);
      i += 1;
    }
    ArrayList localArrayList = mTargetTypes;
    if (localArrayList != null) {
      localArrayList.remove(paramClass);
    }
    return this;
  }
  
  public TransitionSet removeTarget(String paramString)
  {
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).removeTarget(paramString);
      i += 1;
    }
    ArrayList localArrayList = mTargetNames;
    if (localArrayList != null) {
      localArrayList.remove(paramString);
    }
    return this;
  }
  
  public TransitionSet reset(Transition paramTransition)
  {
    next.remove(paramTransition);
    mParent = null;
    return this;
  }
  
  public void resume(View paramView)
  {
    super.resume(paramView);
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).resume(paramView);
      i += 1;
    }
  }
  
  public void runAnimators()
  {
    if (next.isEmpty())
    {
      start();
      remove();
      return;
    }
    init();
    Object localObject;
    if (!e)
    {
      int i = 1;
      while (i < next.size())
      {
        ((Transition)next.get(i - 1)).addListener(new FieldWriter(this, (Transition)next.get(i)));
        i += 1;
      }
      localObject = (Transition)next.get(0);
      if (localObject != null) {
        ((Transition)localObject).runAnimators();
      }
    }
    else
    {
      localObject = next.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).runAnimators();
      }
    }
  }
  
  public void setCanRemoveViews(boolean paramBoolean)
  {
    mCanRemoveViews = paramBoolean;
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).setCanRemoveViews(paramBoolean);
      i += 1;
    }
  }
  
  public TransitionSet setDuration(long paramLong)
  {
    mDuration = paramLong;
    if (mDuration >= 0L)
    {
      int j = next.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)next.get(i)).setDuration(paramLong);
        i += 1;
      }
    }
    return this;
  }
  
  public void setEpicenterCallback(Transition.c paramC)
  {
    mEpicenterCallback = paramC;
    hash |= 0x8;
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).setEpicenterCallback(paramC);
      i += 1;
    }
  }
  
  public TransitionSet setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    hash |= 0x1;
    ArrayList localArrayList = next;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)next.get(i)).setInterpolator(paramTimeInterpolator);
        i += 1;
      }
    }
    mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    super.setPathMotion(paramPathMotion);
    hash |= 0x4;
    int i = 0;
    while (i < next.size())
    {
      ((Transition)next.get(i)).setPathMotion(paramPathMotion);
      i += 1;
    }
  }
  
  public void setPropagation(Attribute paramAttribute)
  {
    mPropagation = paramAttribute;
    hash |= 0x2;
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).setPropagation(paramAttribute);
      i += 1;
    }
  }
  
  public TransitionSet setSceneRoot(ViewGroup paramViewGroup)
  {
    mSceneRoot = paramViewGroup;
    int j = next.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)next.get(i)).setSceneRoot(paramViewGroup);
      i += 1;
    }
    return this;
  }
  
  public TransitionSet setStartDelay(long paramLong)
  {
    mStartDelay = paramLong;
    return this;
  }
  
  public int size()
  {
    return next.size();
  }
  
  public String toString(String paramString)
  {
    Object localObject = super.toString(paramString);
    int i = 0;
    while (i < next.size())
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject, "\n");
      Transition localTransition = (Transition)next.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      ((StringBuilder)localObject).append(localTransition.toString(localStringBuilder.toString()));
      localObject = ((StringBuilder)localObject).toString();
      i += 1;
    }
    return localObject;
  }
  
  public static class a
    extends f
  {
    public TransitionSet a;
    
    public a(TransitionSet paramTransitionSet)
    {
      a = paramTransitionSet;
    }
    
    public void a(Transition paramTransition)
    {
      TransitionSet localTransitionSet = a;
      n -= 1;
      if (n == 0)
      {
        b = false;
        localTransitionSet.remove();
      }
      paramTransition.removeListener(this);
    }
    
    public void e(Transition paramTransition)
    {
      paramTransition = a;
      if (!b)
      {
        paramTransition.start();
        a.b = true;
      }
    }
  }
}
