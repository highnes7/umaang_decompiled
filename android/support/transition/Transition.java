package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import b.b.a.N;
import b.b.v.ia;
import b.b.x.n.b;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import support.android.asm.Attribute;
import support.android.asm.Edit;
import support.android.asm.Frame;
import support.android.asm.Graph;
import support.android.asm.ItemTouchUIUtilImpl.Gingerbread;
import support.android.asm.MainActivity.29;
import support.android.asm.R.styleable;
import support.android.asm.SwipeDismissAnimation.1;
import support.android.v4.content.asm.TypedArrayUtils;
import support.android.v4.util.ArrayMap;
import support.android.v4.util.LongSparseArray;
import support.android.v4.util.SimpleArrayMap;
import support.android.v4.view.ViewCompat;

public abstract class Transition
  implements Cloneable
{
  public static final boolean $assertionsDisabled = false;
  public static final int[] DEFAULT_MATCH_ORDER = { 2, 1, 3, 4 };
  public static final String LOG_TAG = "Transition";
  public static final int MATCH_FIRST = 1;
  public static final int MATCH_ID = 3;
  public static final String MATCH_ID_STR = "id";
  public static final int MATCH_INSTANCE = 1;
  public static final String MATCH_INSTANCE_STR = "instance";
  public static final int MATCH_ITEM_ID = 4;
  public static final String MATCH_ITEM_ID_STR = "itemId";
  public static final int MATCH_LAST = 4;
  public static final int MATCH_NAME = 2;
  public static final String MATCH_NAME_STR = "name";
  public static final PathMotion STRAIGHT_PATH_MOTION = new ItemTouchUIUtilImpl.Gingerbread();
  public static ThreadLocal<b<Animator, a>> sRunningAnimators = new ThreadLocal();
  public ArrayList<Animator> mAnimators = new ArrayList();
  public boolean mCanRemoveViews = false;
  public ArrayList<Animator> mCurrentAnimators = new ArrayList();
  public long mDuration = -1L;
  public Graph mEndValues = new Graph();
  public ArrayList<ia> mEndValuesList;
  public boolean mEnded = false;
  public c mEpicenterCallback;
  public TimeInterpolator mInterpolator = null;
  public ArrayList<e> mListeners = null;
  public int[] mMatchOrder = DEFAULT_MATCH_ORDER;
  public String mName = getClass().getName();
  public b<String, String> mNameOverrides;
  public int mNumInstances = 0;
  public TransitionSet mParent = null;
  public PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
  public boolean mPaused = false;
  public Attribute mPropagation;
  public ViewGroup mSceneRoot = null;
  public long mStartDelay = -1L;
  public Graph mStartValues = new Graph();
  public ArrayList<ia> mStartValuesList;
  public ArrayList<View> mTargetChildExcludes = null;
  public ArrayList<View> mTargetExcludes = null;
  public ArrayList<Integer> mTargetIdChildExcludes = null;
  public ArrayList<Integer> mTargetIdExcludes = null;
  public ArrayList<Integer> mTargetIds = new ArrayList();
  public ArrayList<String> mTargetNameExcludes = null;
  public ArrayList<String> mTargetNames = null;
  public ArrayList<Class> mTargetTypeChildExcludes = null;
  public ArrayList<Class> mTargetTypeExcludes = null;
  public ArrayList<Class> mTargetTypes = null;
  public ArrayList<View> mTargets = new ArrayList();
  
  public Transition() {}
  
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l = TypedArrayUtils.getString(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l >= 0L) {
      setDuration(l);
    }
    l = TypedArrayUtils.getString(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l > 0L) {
      setStartDelay(l);
    }
    int i = TypedArrayUtils.getInt(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i > 0) {
      setInterpolator(AnimationUtils.loadInterpolator(paramContext, i));
    }
    paramContext = TypedArrayUtils.getValue(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      setMatchOrder(parseMatchOrder(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private void addUnmatched(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayMap1.size()) {
        break;
      }
      Edit localEdit = (Edit)paramArrayMap1.get(i);
      if (isValidTarget(view))
      {
        mStartValuesList.add(localEdit);
        mEndValuesList.add(null);
      }
      i += 1;
    }
    while (j < paramArrayMap2.size())
    {
      paramArrayMap1 = (Edit)paramArrayMap2.get(j);
      if (isValidTarget(view))
      {
        mEndValuesList.add(paramArrayMap1);
        mStartValuesList.add(null);
      }
      j += 1;
    }
  }
  
  public static void addViewValues(Graph paramGraph, View paramView, Edit paramEdit)
  {
    mSongs.put(paramView, paramEdit);
    int i = paramView.getId();
    if (i >= 0) {
      if (mBitmaps.indexOfKey(i) >= 0) {
        mBitmaps.put(i, null);
      } else {
        mBitmaps.put(i, paramView);
      }
    }
    paramEdit = ViewCompat.a(paramView);
    if (paramEdit != null) {
      if (mAdapters.containsKey(paramEdit)) {
        mAdapters.put(paramEdit, null);
      } else {
        mAdapters.put(paramEdit, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramEdit = (ListView)paramView.getParent();
      if (paramEdit.getAdapter().hasStableIds())
      {
        long l = paramEdit.getItemIdAtPosition(paramEdit.getPositionForView(paramView));
        if (mSections.indexOfKey(l) >= 0)
        {
          paramView = (View)mSections.get(l);
          if (paramView != null)
          {
            ViewCompat.start(paramView, false);
            mSections.put(l, null);
          }
        }
        else
        {
          ViewCompat.start(paramView, true);
          mSections.put(l, paramView);
        }
      }
    }
  }
  
  public static boolean alreadyContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] == j) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void captureHierarchy(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int k = paramView.getId();
    Object localObject = mTargetIdExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(k)))) {
      return;
    }
    localObject = mTargetExcludes;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = mTargetTypeExcludes;
    int j = 0;
    int i;
    if (localObject != null)
    {
      int m = ((ArrayList)localObject).size();
      i = 0;
      while (i < m)
      {
        if (((Class)mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return;
        }
        i += 1;
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new Edit();
      view = paramView;
      if (paramBoolean) {
        captureStartValues((Edit)localObject);
      } else {
        captureEndValues((Edit)localObject);
      }
      added.add(this);
      capturePropagationValues((Edit)localObject);
      if (paramBoolean) {
        addViewValues(mStartValues, paramView, (Edit)localObject);
      } else {
        addViewValues(mEndValues, paramView, (Edit)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = mTargetIdChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(k)))) {
        return;
      }
      localObject = mTargetChildExcludes;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = mTargetTypeChildExcludes;
      if (localObject != null)
      {
        k = ((ArrayList)localObject).size();
        i = 0;
        while (i < k)
        {
          if (((Class)mTargetTypeChildExcludes.get(i)).isInstance(paramView)) {
            return;
          }
          i += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      i = j;
      while (i < paramView.getChildCount())
      {
        captureHierarchy(paramView.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
  }
  
  private ArrayList excludeId(ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramInt > 0)
    {
      if (paramBoolean) {
        return b.a(paramArrayList, Integer.valueOf(paramInt));
      }
      localArrayList = b.remove0(paramArrayList, Integer.valueOf(paramInt));
    }
    return localArrayList;
  }
  
  public static ArrayList excludeObject(ArrayList paramArrayList, Object paramObject, boolean paramBoolean)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramObject != null)
    {
      if (paramBoolean) {
        return b.a(paramArrayList, paramObject);
      }
      localArrayList = b.remove0(paramArrayList, paramObject);
    }
    return localArrayList;
  }
  
  private ArrayList excludeType(ArrayList paramArrayList, Class paramClass, boolean paramBoolean)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramClass != null)
    {
      if (paramBoolean) {
        return b.a(paramArrayList, paramClass);
      }
      localArrayList = b.remove0(paramArrayList, paramClass);
    }
    return localArrayList;
  }
  
  private ArrayList excludeView(ArrayList paramArrayList, View paramView, boolean paramBoolean)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramView != null)
    {
      if (paramBoolean) {
        return b.a(paramArrayList, paramView);
      }
      localArrayList = b.remove0(paramArrayList, paramView);
    }
    return localArrayList;
  }
  
  public static ArrayMap getRunningAnimators()
  {
    ArrayMap localArrayMap2 = (ArrayMap)sRunningAnimators.get();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (localArrayMap2 == null)
    {
      localArrayMap1 = new ArrayMap();
      sRunningAnimators.set(localArrayMap1);
    }
    return localArrayMap1;
  }
  
  public static boolean isValidMatch(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 4);
  }
  
  public static boolean isValueChanged(Edit paramEdit1, Edit paramEdit2, String paramString)
  {
    paramEdit1 = values.get(paramString);
    paramEdit2 = values.get(paramString);
    if ((paramEdit1 == null) && (paramEdit2 == null)) {
      return false;
    }
    if (paramEdit1 != null)
    {
      if (paramEdit2 == null) {
        return true;
      }
      return true ^ paramEdit1.equals(paramEdit2);
    }
    return true;
  }
  
  private void matchIds(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, SparseArray paramSparseArray1, SparseArray paramSparseArray2)
  {
    int j = paramSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          Edit localEdit1 = (Edit)paramArrayMap1.get(localView1);
          Edit localEdit2 = (Edit)paramArrayMap2.get(localView2);
          if ((localEdit1 != null) && (localEdit2 != null))
          {
            mStartValuesList.add(localEdit1);
            mEndValuesList.add(localEdit2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchInstances(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2)
  {
    int i = paramArrayMap1.size() - 1;
    while (i >= 0)
    {
      Object localObject1 = (View)paramArrayMap1.keyAt(i);
      if ((localObject1 != null) && (isValidTarget((View)localObject1)))
      {
        localObject1 = (Edit)paramArrayMap2.remove(localObject1);
        if (localObject1 != null)
        {
          Object localObject2 = view;
          if ((localObject2 != null) && (isValidTarget((View)localObject2)))
          {
            localObject2 = (Edit)paramArrayMap1.removeAt(i);
            mStartValuesList.add(localObject2);
            mEndValuesList.add(localObject1);
          }
        }
      }
      i -= 1;
    }
  }
  
  private void matchItemIds(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, LongSparseArray paramLongSparseArray1, LongSparseArray paramLongSparseArray2)
  {
    int j = paramLongSparseArray1.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          Edit localEdit1 = (Edit)paramArrayMap1.get(localView1);
          Edit localEdit2 = (Edit)paramArrayMap2.get(localView2);
          if ((localEdit1 != null) && (localEdit2 != null))
          {
            mStartValuesList.add(localEdit1);
            mEndValuesList.add(localEdit2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchNames(ArrayMap paramArrayMap1, ArrayMap paramArrayMap2, ArrayMap paramArrayMap3, ArrayMap paramArrayMap4)
  {
    int j = paramArrayMap3.size();
    int i = 0;
    while (i < j)
    {
      View localView1 = (View)paramArrayMap3.get(i);
      if ((localView1 != null) && (isValidTarget(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i));
        if ((localView2 != null) && (isValidTarget(localView2)))
        {
          Edit localEdit1 = (Edit)paramArrayMap1.get(localView1);
          Edit localEdit2 = (Edit)paramArrayMap2.get(localView2);
          if ((localEdit1 != null) && (localEdit2 != null))
          {
            mStartValuesList.add(localEdit1);
            mEndValuesList.add(localEdit2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
      i += 1;
    }
  }
  
  private void matchStartAndEnd(Graph paramGraph1, Graph paramGraph2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(mSongs);
    ArrayMap localArrayMap2 = new ArrayMap(mSongs);
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = mMatchOrder;
      if (i >= arrayOfInt.length) {
        break;
      }
      int j = arrayOfInt[i];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            if (j == 4) {
              matchItemIds(localArrayMap1, localArrayMap2, mSections, mSections);
            }
          }
          else {
            matchIds(localArrayMap1, localArrayMap2, mBitmaps, mBitmaps);
          }
        }
        else {
          matchNames(localArrayMap1, localArrayMap2, mAdapters, mAdapters);
        }
      }
      else {
        matchInstances(localArrayMap1, localArrayMap2);
      }
      i += 1;
    }
    addUnmatched(localArrayMap1, localArrayMap2);
  }
  
  public static int[] parseMatchOrder(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 3;
      }
      else if ("instance".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 1;
      }
      else if ("name".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 2;
      }
      else if ("itemId".equalsIgnoreCase((String)localObject))
      {
        paramString[i] = 4;
      }
      else
      {
        if (!((String)localObject).isEmpty()) {
          break label135;
        }
        localObject = new int[paramString.length - 1];
        System.arraycopy(paramString, 0, localObject, 0, i);
        i -= 1;
        paramString = (String)localObject;
      }
      i += 1;
      continue;
      label135:
      throw new InflateException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unknown match type in matchOrder: '", (String)localObject, "'"));
    }
    return paramString;
  }
  
  private void runAnimator(Animator paramAnimator, ArrayMap paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new MainActivity.29(this, paramArrayMap));
      animate(paramAnimator);
    }
  }
  
  public Transition addListener(e paramE)
  {
    if (mListeners == null) {
      mListeners = new ArrayList();
    }
    mListeners.add(paramE);
    return this;
  }
  
  public Transition addTarget(int paramInt)
  {
    if (paramInt != 0) {
      mTargetIds.add(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Transition addTarget(View paramView)
  {
    mTargets.add(paramView);
    return this;
  }
  
  public Transition addTarget(Class paramClass)
  {
    if (mTargetTypes == null) {
      mTargetTypes = new ArrayList();
    }
    mTargetTypes.add(paramClass);
    return this;
  }
  
  public Transition addTarget(String paramString)
  {
    if (mTargetNames == null) {
      mTargetNames = new ArrayList();
    }
    mTargetNames.add(paramString);
    return this;
  }
  
  public void animate(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      remove();
      return;
    }
    if (getDuration() >= 0L) {
      paramAnimator.setDuration(getDuration());
    }
    if (getStartDelay() >= 0L) {
      paramAnimator.setStartDelay(getStartDelay());
    }
    if (getInterpolator() != null) {
      paramAnimator.setInterpolator(getInterpolator());
    }
    paramAnimator.addListener(new SwipeDismissAnimation.1(this));
    paramAnimator.start();
  }
  
  public void cancel()
  {
    int i = mCurrentAnimators.size() - 1;
    while (i >= 0)
    {
      ((Animator)mCurrentAnimators.get(i)).cancel();
      i -= 1;
    }
    ArrayList localArrayList = mListeners;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = (ArrayList)mListeners.clone();
      int j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        ((e)localArrayList.get(i)).d(this);
        i += 1;
      }
    }
  }
  
  public abstract void captureEndValues(Edit paramEdit);
  
  public void capturePropagationValues(Edit paramEdit)
  {
    if ((mPropagation != null) && (!values.isEmpty()))
    {
      String[] arrayOfString = mPropagation.a();
      if (arrayOfString == null) {
        return;
      }
      int j = 0;
      int i = 0;
      while (i < arrayOfString.length)
      {
        if (!values.containsKey(arrayOfString[i]))
        {
          i = j;
          break label75;
        }
        i += 1;
      }
      i = 1;
      label75:
      if (i == 0) {
        mPropagation.a(paramEdit);
      }
    }
  }
  
  public abstract void captureStartValues(Edit paramEdit);
  
  public void captureValues(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    clearValues(paramBoolean);
    int i = mTargetIds.size();
    int k = 0;
    Object localObject1;
    if ((i > 0) || (mTargets.size() > 0))
    {
      localObject1 = mTargetNames;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = mTargetTypes;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label80;
        }
      }
    }
    captureHierarchy(paramViewGroup, paramBoolean);
    break label314;
    label80:
    i = 0;
    Object localObject2;
    while (i < mTargetIds.size())
    {
      localObject1 = paramViewGroup.findViewById(((Integer)mTargetIds.get(i)).intValue());
      if (localObject1 != null)
      {
        localObject2 = new Edit();
        view = ((View)localObject1);
        if (paramBoolean) {
          captureStartValues((Edit)localObject2);
        } else {
          captureEndValues((Edit)localObject2);
        }
        added.add(this);
        capturePropagationValues((Edit)localObject2);
        if (paramBoolean) {
          addViewValues(mStartValues, (View)localObject1, (Edit)localObject2);
        } else {
          addViewValues(mEndValues, (View)localObject1, (Edit)localObject2);
        }
      }
      i += 1;
    }
    i = 0;
    while (i < mTargets.size())
    {
      paramViewGroup = (View)mTargets.get(i);
      localObject1 = new Edit();
      view = paramViewGroup;
      if (paramBoolean) {
        captureStartValues((Edit)localObject1);
      } else {
        captureEndValues((Edit)localObject1);
      }
      added.add(this);
      capturePropagationValues((Edit)localObject1);
      if (paramBoolean) {
        addViewValues(mStartValues, paramViewGroup, (Edit)localObject1);
      } else {
        addViewValues(mEndValues, paramViewGroup, (Edit)localObject1);
      }
      i += 1;
    }
    label314:
    if (!paramBoolean)
    {
      paramViewGroup = mNameOverrides;
      if (paramViewGroup != null)
      {
        int m = paramViewGroup.size();
        paramViewGroup = new ArrayList(m);
        i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= m) {
            break;
          }
          localObject1 = (String)mNameOverrides.keyAt(i);
          paramViewGroup.add(mStartValues.mAdapters.remove(localObject1));
          i += 1;
        }
        while (j < m)
        {
          localObject1 = (View)paramViewGroup.get(j);
          if (localObject1 != null)
          {
            localObject2 = (String)mNameOverrides.get(j);
            mStartValues.mAdapters.put(localObject2, localObject1);
          }
          j += 1;
        }
      }
    }
  }
  
  public void clearValues(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mStartValues.mSongs.clear();
      mStartValues.mBitmaps.clear();
      mStartValues.mSections.clear();
      return;
    }
    mEndValues.mSongs.clear();
    mEndValues.mBitmaps.clear();
    mEndValues.mSections.clear();
  }
  
  public Transition clone()
  {
    try
    {
      Object localObject1 = super.clone();
      localObject1 = (Transition)localObject1;
      Object localObject2 = new ArrayList();
      mAnimators = ((ArrayList)localObject2);
      localObject2 = new Graph();
      mStartValues = ((Graph)localObject2);
      localObject2 = new Graph();
      mEndValues = ((Graph)localObject2);
      mStartValuesList = null;
      mEndValuesList = null;
      return localObject1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, Edit paramEdit1, Edit paramEdit2)
  {
    return null;
  }
  
  public void createAnimators(ViewGroup paramViewGroup, Graph paramGraph1, Graph paramGraph2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramArrayList1.size();
    long l1 = Long.MAX_VALUE;
    int i = 0;
    long l2;
    int j;
    while (i < k)
    {
      Object localObject1 = (Edit)paramArrayList1.get(i);
      paramGraph1 = (Edit)paramArrayList2.get(i);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!added.contains(this)) {
          localObject2 = null;
        }
      }
      Graph localGraph = paramGraph1;
      if (paramGraph1 != null)
      {
        localGraph = paramGraph1;
        if (!added.contains(this)) {
          localGraph = null;
        }
      }
      if ((localObject2 == null) && (localGraph == null)) {}
      do
      {
        do
        {
          l2 = l1;
          break;
          if ((localObject2 != null) && (localGraph != null) && (!isTransitionRequired(localObject2, localGraph))) {
            j = 0;
          } else {
            j = 1;
          }
        } while (j == 0);
        localObject1 = createAnimator(paramViewGroup, localObject2, localGraph);
      } while (localObject1 == null);
      View localView;
      Object localObject3;
      if (localGraph != null)
      {
        localView = view;
        localObject3 = getTransitionProperties();
        if ((localView != null) && (localObject3 != null) && (localObject3.length > 0))
        {
          paramGraph1 = new Edit();
          view = localView;
          Edit localEdit = (Edit)mSongs.get(localView);
          if (localEdit != null)
          {
            j = 0;
            while (j < localObject3.length)
            {
              values.put(localObject3[j], values.get(localObject3[j]));
              j += 1;
            }
          }
          int m = localArrayMap.size();
          j = 0;
          while (j < m)
          {
            localObject3 = (a)localArrayMap.get((Animator)localArrayMap.keyAt(j));
            if ((mData != null) && (mPermissions == localView) && (mSize.equals(getName())) && (mData.equals(paramGraph1)))
            {
              localObject1 = null;
              break;
            }
            j += 1;
          }
        }
        else
        {
          paramGraph1 = null;
        }
      }
      else
      {
        localView = view;
        paramGraph1 = null;
      }
      l2 = l1;
      if (localObject1 != null)
      {
        localObject3 = mPropagation;
        l2 = l1;
        if (localObject3 != null)
        {
          l2 = ((Attribute)localObject3).a(paramViewGroup, this, localObject2, localGraph);
          localSparseIntArray.put(mAnimators.size(), (int)l2);
          l2 = Math.min(l2, l1);
        }
        localArrayMap.put(localObject1, new a(localView, getName(), this, Frame.get(paramViewGroup), paramGraph1));
        mAnimators.add(localObject1);
      }
      i += 1;
      l1 = l2;
    }
    if (l1 != 0L)
    {
      i = 0;
      while (i < localSparseIntArray.size())
      {
        j = localSparseIntArray.keyAt(i);
        paramViewGroup = (Animator)mAnimators.get(j);
        l2 = localSparseIntArray.valueAt(i);
        paramViewGroup.setStartDelay(paramViewGroup.getStartDelay() + (l2 - l1));
        i += 1;
      }
    }
  }
  
  public Transition excludeChildren(int paramInt, boolean paramBoolean)
  {
    mTargetIdChildExcludes = excludeId(mTargetIdChildExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(View paramView, boolean paramBoolean)
  {
    mTargetChildExcludes = excludeView(mTargetChildExcludes, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeChildren(Class paramClass, boolean paramBoolean)
  {
    mTargetTypeChildExcludes = excludeType(mTargetTypeChildExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean)
  {
    mTargetIdExcludes = excludeId(mTargetIdExcludes, paramInt, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean)
  {
    mTargetExcludes = excludeView(mTargetExcludes, paramView, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(Class paramClass, boolean paramBoolean)
  {
    mTargetTypeExcludes = excludeType(mTargetTypeExcludes, paramClass, paramBoolean);
    return this;
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean)
  {
    mTargetNameExcludes = excludeObject(mTargetNameExcludes, paramString, paramBoolean);
    return this;
  }
  
  public void forceToEnd(ViewGroup paramViewGroup)
  {
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    if (paramViewGroup != null)
    {
      paramViewGroup = Frame.get(paramViewGroup);
      i -= 1;
      while (i >= 0)
      {
        a localA = (a)localArrayMap.get(i);
        if ((mPermissions != null) && (paramViewGroup.equals(mContentStart))) {
          ((Animator)localArrayMap.keyAt(i)).end();
        }
        i -= 1;
      }
    }
  }
  
  public long getDuration()
  {
    return mDuration;
  }
  
  public Rect getEpicenter()
  {
    c localC = mEpicenterCallback;
    if (localC == null) {
      return null;
    }
    return localC.a(this);
  }
  
  public c getEpicenterCallback()
  {
    return mEpicenterCallback;
  }
  
  public TimeInterpolator getInterpolator()
  {
    return mInterpolator;
  }
  
  public Edit getMatchedTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null) {
      return ((Transition)localObject).getMatchedTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = mStartValuesList;
    } else {
      localObject = mEndValuesList;
    }
    if (localObject == null) {
      return null;
    }
    int m = ((ArrayList)localObject).size();
    int k = -1;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      Edit localEdit = (Edit)((ArrayList)localObject).get(i);
      if (localEdit == null) {
        return null;
      }
      if (view == paramView)
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (j >= 0)
    {
      if (paramBoolean) {
        paramView = mEndValuesList;
      } else {
        paramView = mStartValuesList;
      }
      return (Edit)paramView.get(j);
    }
    return null;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public PathMotion getPathMotion()
  {
    return mPathMotion;
  }
  
  public Attribute getPropagation()
  {
    return mPropagation;
  }
  
  public long getStartDelay()
  {
    return mStartDelay;
  }
  
  public List getTargetIds()
  {
    return mTargetIds;
  }
  
  public List getTargetNames()
  {
    return mTargetNames;
  }
  
  public List getTargetTypes()
  {
    return mTargetTypes;
  }
  
  public List getTargets()
  {
    return mTargets;
  }
  
  public String[] getTransitionProperties()
  {
    return null;
  }
  
  public Edit getTransitionValues(View paramView, boolean paramBoolean)
  {
    Object localObject = mParent;
    if (localObject != null) {
      return ((Transition)localObject).getTransitionValues(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = mStartValues;
    } else {
      localObject = mEndValues;
    }
    return (Edit)mSongs.get(paramView);
  }
  
  public boolean isTransitionRequired(Edit paramEdit1, Edit paramEdit2)
  {
    if ((paramEdit1 != null) && (paramEdit2 != null))
    {
      Object localObject = getTransitionProperties();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label100;
          }
          if (isValueChanged(paramEdit1, paramEdit2, localObject[i])) {
            break;
          }
          i += 1;
        }
      }
      localObject = values.keySet().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!isValueChanged(paramEdit1, paramEdit2, (String)((Iterator)localObject).next()));
      return true;
    }
    label100:
    return false;
  }
  
  public boolean isValidTarget(View paramView)
  {
    int j = paramView.getId();
    ArrayList localArrayList = mTargetIdExcludes;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(j)))) {
      return false;
    }
    localArrayList = mTargetExcludes;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = mTargetTypeExcludes;
    int i;
    if (localArrayList != null)
    {
      int k = localArrayList.size();
      i = 0;
      while (i < k)
      {
        if (((Class)mTargetTypeExcludes.get(i)).isInstance(paramView)) {
          return false;
        }
        i += 1;
      }
    }
    if ((mTargetNameExcludes != null) && (ViewCompat.a(paramView) != null) && (mTargetNameExcludes.contains(ViewCompat.a(paramView)))) {
      return false;
    }
    if ((mTargetIds.size() == 0) && (mTargets.size() == 0))
    {
      localArrayList = mTargetTypes;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = mTargetNames;
        if (localArrayList == null) {
          break label296;
        }
        if (localArrayList.isEmpty()) {
          return true;
        }
      }
    }
    if (!mTargetIds.contains(Integer.valueOf(j)))
    {
      if (mTargets.contains(paramView)) {
        return true;
      }
      localArrayList = mTargetNames;
      if ((localArrayList != null) && (localArrayList.contains(ViewCompat.a(paramView)))) {
        return true;
      }
      if (mTargetTypes != null)
      {
        i = 0;
        while (i < mTargetTypes.size())
        {
          if (((Class)mTargetTypes.get(i)).isInstance(paramView)) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    label296:
    return true;
    return false;
  }
  
  public void pause(View paramView)
  {
    if (!mEnded)
    {
      ArrayMap localArrayMap = getRunningAnimators();
      int i = localArrayMap.size();
      paramView = Frame.get(paramView);
      i -= 1;
      int j;
      while (i >= 0)
      {
        Object localObject = (a)localArrayMap.get(i);
        if ((mPermissions != null) && (paramView.equals(mContentStart)))
        {
          localObject = (Animator)localArrayMap.keyAt(i);
          j = Build.VERSION.SDK_INT;
          ((Animator)localObject).pause();
        }
        i -= 1;
      }
      paramView = mListeners;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)mListeners.clone();
        j = paramView.size();
        i = 0;
        while (i < j)
        {
          ((e)paramView.get(i)).b(this);
          i += 1;
        }
      }
      mPaused = true;
    }
  }
  
  public void playTransition(ViewGroup paramViewGroup)
  {
    mStartValuesList = new ArrayList();
    mEndValuesList = new ArrayList();
    matchStartAndEnd(mStartValues, mEndValues);
    ArrayMap localArrayMap = getRunningAnimators();
    int i = localArrayMap.size();
    support.android.asm.Object localObject = Frame.get(paramViewGroup);
    i -= 1;
    while (i >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i);
      if (localAnimator != null)
      {
        a localA = (a)localArrayMap.get(localAnimator);
        if ((localA != null) && (mPermissions != null) && (localObject.equals(mContentStart)))
        {
          Edit localEdit1 = mData;
          Object localObject1 = mPermissions;
          Edit localEdit2 = getTransitionValues((View)localObject1, true);
          localObject1 = getMatchedTransitionValues((View)localObject1, true);
          int j;
          if (((localEdit2 != null) || (localObject1 != null)) && (typeUtils.isTransitionRequired(localEdit1, (Edit)localObject1))) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              localArrayMap.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i -= 1;
    }
    createAnimators(paramViewGroup, mStartValues, mEndValues, mStartValuesList, mEndValuesList);
    runAnimators();
  }
  
  public void remove()
  {
    mNumInstances -= 1;
    if (mNumInstances == 0)
    {
      Object localObject = mListeners;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)mListeners.clone();
        int j = ((ArrayList)localObject).size();
        i = 0;
        while (i < j)
        {
          ((e)((ArrayList)localObject).get(i)).a(this);
          i += 1;
        }
      }
      int i = 0;
      while (i < mStartValues.mSections.size())
      {
        localObject = (View)mStartValues.mSections.valueAt(i);
        if (localObject != null) {
          ViewCompat.start((View)localObject, false);
        }
        i += 1;
      }
      i = 0;
      while (i < mEndValues.mSections.size())
      {
        localObject = (View)mEndValues.mSections.valueAt(i);
        if (localObject != null) {
          ViewCompat.start((View)localObject, false);
        }
        i += 1;
      }
      mEnded = true;
    }
  }
  
  public Transition removeListener(e paramE)
  {
    ArrayList localArrayList = mListeners;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramE);
    if (mListeners.size() == 0) {
      mListeners = null;
    }
    return this;
  }
  
  public Transition removeTarget(int paramInt)
  {
    if (paramInt != 0) {
      mTargetIds.remove(Integer.valueOf(paramInt));
    }
    return this;
  }
  
  public Transition removeTarget(View paramView)
  {
    mTargets.remove(paramView);
    return this;
  }
  
  public Transition removeTarget(Class paramClass)
  {
    ArrayList localArrayList = mTargetTypes;
    if (localArrayList != null) {
      localArrayList.remove(paramClass);
    }
    return this;
  }
  
  public Transition removeTarget(String paramString)
  {
    ArrayList localArrayList = mTargetNames;
    if (localArrayList != null) {
      localArrayList.remove(paramString);
    }
    return this;
  }
  
  public void resume(View paramView)
  {
    if (mPaused)
    {
      if (!mEnded)
      {
        ArrayMap localArrayMap = getRunningAnimators();
        int i = localArrayMap.size();
        paramView = Frame.get(paramView);
        i -= 1;
        int j;
        while (i >= 0)
        {
          Object localObject = (a)localArrayMap.get(i);
          if ((mPermissions != null) && (paramView.equals(mContentStart)))
          {
            localObject = (Animator)localArrayMap.keyAt(i);
            j = Build.VERSION.SDK_INT;
            ((Animator)localObject).resume();
          }
          i -= 1;
        }
        paramView = mListeners;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)mListeners.clone();
          j = paramView.size();
          i = 0;
          while (i < j)
          {
            ((e)paramView.get(i)).c(this);
            i += 1;
          }
        }
      }
      mPaused = false;
    }
  }
  
  public void runAnimators()
  {
    start();
    ArrayMap localArrayMap = getRunningAnimators();
    Iterator localIterator = mAnimators.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        start();
        runAnimator(localAnimator, localArrayMap);
      }
    }
    mAnimators.clear();
    remove();
  }
  
  public void setCanRemoveViews(boolean paramBoolean)
  {
    mCanRemoveViews = paramBoolean;
  }
  
  public Transition setDuration(long paramLong)
  {
    mDuration = paramLong;
    return this;
  }
  
  public void setEpicenterCallback(c paramC)
  {
    mEpicenterCallback = paramC;
  }
  
  public Transition setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    mInterpolator = paramTimeInterpolator;
    return this;
  }
  
  public void setMatchOrder(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i = 0;
      while (i < paramVarArgs.length) {
        if (isValidMatch(paramVarArgs[i]))
        {
          if (!alreadyContains(paramVarArgs, i)) {
            i += 1;
          } else {
            throw new IllegalArgumentException("matches contains a duplicate value");
          }
        }
        else {
          throw new IllegalArgumentException("matches contains invalid value");
        }
      }
      mMatchOrder = ((int[])paramVarArgs.clone());
      return;
    }
    mMatchOrder = DEFAULT_MATCH_ORDER;
  }
  
  public void setPathMotion(PathMotion paramPathMotion)
  {
    if (paramPathMotion == null)
    {
      mPathMotion = STRAIGHT_PATH_MOTION;
      return;
    }
    mPathMotion = paramPathMotion;
  }
  
  public void setPropagation(Attribute paramAttribute)
  {
    mPropagation = paramAttribute;
  }
  
  public Transition setSceneRoot(ViewGroup paramViewGroup)
  {
    mSceneRoot = paramViewGroup;
    return this;
  }
  
  public Transition setStartDelay(long paramLong)
  {
    mStartDelay = paramLong;
    return this;
  }
  
  public void start()
  {
    if (mNumInstances == 0)
    {
      ArrayList localArrayList = mListeners;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)mListeners.clone();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((e)localArrayList.get(i)).e(this);
          i += 1;
        }
      }
      mEnded = false;
    }
    mNumInstances += 1;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString);
    paramString.append(getClass().getSimpleName());
    paramString.append("@");
    paramString.append(Integer.toHexString(hashCode()));
    paramString.append(": ");
    String str = paramString.toString();
    paramString = str;
    if (mDuration != -1L)
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, "dur(");
      paramString.append(mDuration);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    str = paramString;
    if (mStartDelay != -1L)
    {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, "dly(");
      paramString.append(mStartDelay);
      paramString.append(") ");
      str = paramString.toString();
    }
    paramString = str;
    if (mInterpolator != null) {
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(str, "interp("), mInterpolator, ") ");
    }
    if ((mTargetIds.size() > 0) || (mTargets.size() > 0))
    {
      str = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, "tgts(");
      int i = mTargetIds.size();
      int j = 0;
      paramString = str;
      if (i > 0)
      {
        i = 0;
        for (;;)
        {
          paramString = str;
          if (i >= mTargetIds.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(str, ", ");
          }
          paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString);
          paramString.append(mTargetIds.get(i));
          str = paramString.toString();
          i += 1;
        }
      }
      str = paramString;
      if (mTargets.size() > 0)
      {
        i = j;
        for (;;)
        {
          str = paramString;
          if (i >= mTargets.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, ", ");
          }
          paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(str);
          paramString.append(mTargets.get(i));
          paramString = paramString.toString();
          i += 1;
        }
      }
      return f.sufficientlysecure.rootcommands.util.StringBuilder.toString(str, ")");
    }
    return paramString;
  }
  
  private static class a
  {
    public support.android.asm.Object mContentStart;
    public Edit mData;
    public View mPermissions;
    public String mSize;
    public Transition typeUtils;
    
    public a(View paramView, String paramString, Transition paramTransition, support.android.asm.Object paramObject, Edit paramEdit)
    {
      mPermissions = paramView;
      mSize = paramString;
      mData = paramEdit;
      mContentStart = paramObject;
      typeUtils = paramTransition;
    }
  }
  
  private static class b
  {
    public b() {}
    
    public static ArrayList a(ArrayList paramArrayList, Object paramObject)
    {
      ArrayList localArrayList = paramArrayList;
      if (paramArrayList == null) {
        localArrayList = new ArrayList();
      }
      if (!localArrayList.contains(paramObject)) {
        localArrayList.add(paramObject);
      }
      return localArrayList;
    }
    
    public static ArrayList remove0(ArrayList paramArrayList, Object paramObject)
    {
      if (paramArrayList != null)
      {
        paramArrayList.remove(paramObject);
        if (paramArrayList.isEmpty()) {
          return null;
        }
      }
      return paramArrayList;
    }
  }
  
  public static abstract class c
  {
    public c() {}
    
    public abstract Rect a(Transition paramTransition);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public static @interface d {}
  
  public static abstract interface e
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void b(Transition paramTransition);
    
    public abstract void c(Transition paramTransition);
    
    public abstract void d(Transition paramTransition);
    
    public abstract void e(Transition paramTransition);
  }
}
