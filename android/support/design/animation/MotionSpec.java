package android.support.design.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import b.b.x.n.t;
import java.util.ArrayList;
import java.util.List;
import support.android.v4.util.SimpleArrayMap;

public class MotionSpec
{
  public static final String PAGE_KEY = "MotionSpec";
  public final t<String, MotionTiming> timings = new SimpleArrayMap();
  
  public MotionSpec() {}
  
  public static void addTimingFromAnimator(MotionSpec paramMotionSpec, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      paramMotionSpec.setTiming(paramAnimator.getPropertyName(), MotionTiming.createFromAnimator(paramAnimator));
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("Animator must be an ObjectAnimator: ", paramAnimator));
  }
  
  public static MotionSpec createFromAttribute(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return createFromResource(paramContext, paramInt);
      }
    }
    return null;
  }
  
  public static MotionSpec createFromResource(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((paramContext instanceof AnimatorSet))
      {
        paramContext = (AnimatorSet)paramContext;
        paramContext = createSpecFromAnimators(paramContext.getChildAnimations());
        return paramContext;
      }
      if (paramContext != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramContext);
        paramContext = createSpecFromAnimators(localArrayList);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Can't load animation resource ID #0x");
    paramContext.append(Integer.toHexString(paramInt));
    paramContext.toString();
    return null;
  }
  
  public static MotionSpec createSpecFromAnimators(List paramList)
  {
    MotionSpec localMotionSpec = new MotionSpec();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      addTimingFromAnimator(localMotionSpec, (Animator)paramList.get(i));
      i += 1;
    }
    return localMotionSpec;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (MotionSpec.class == paramObject.getClass()))
    {
      paramObject = (MotionSpec)paramObject;
      return timings.equals(timings);
    }
    return false;
  }
  
  public MotionTiming getTiming(String paramString)
  {
    if (hasTiming(paramString)) {
      return (MotionTiming)timings.get(paramString);
    }
    throw new IllegalArgumentException();
  }
  
  public long getTotalDuration()
  {
    int j = timings.size();
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      MotionTiming localMotionTiming = (MotionTiming)timings.get(i);
      long l2 = localMotionTiming.getDelay();
      l1 = Math.max(l1, localMotionTiming.getDuration() + l2);
      i += 1;
    }
    return l1;
  }
  
  public boolean hasTiming(String paramString)
  {
    return timings.get(paramString) != null;
  }
  
  public int hashCode()
  {
    return timings.hashCode();
  }
  
  public void setTiming(String paramString, MotionTiming paramMotionTiming)
  {
    timings.put(paramString, paramMotionTiming);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(MotionSpec.class.getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, timings, "}\n");
  }
}
