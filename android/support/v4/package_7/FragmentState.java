package android.support.v4.package_7;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import support.support.asm.Line;

public final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<android.support.v4.app.FragmentState> CREATOR = new Parcelable.Creator()
  {
    public FragmentState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new FragmentState(paramAnonymousParcel);
    }
    
    public FragmentState[] newArray(int paramAnonymousInt)
    {
      return new FragmentState[paramAnonymousInt];
    }
  };
  public final Bundle mArguments;
  public final String mClassName;
  public final int mContainerId;
  public final boolean mDetached;
  public final int mFragmentId;
  public final boolean mFromLayout;
  public final boolean mHidden;
  public final int mIndex;
  public Fragment mInstance;
  public final boolean mRetainInstance;
  public Bundle mSavedFragmentState;
  public final String mTag;
  
  public FragmentState(Parcel paramParcel)
  {
    mClassName = paramParcel.readString();
    mIndex = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool2 = true;
    boolean bool1;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mFromLayout = bool1;
    mFragmentId = paramParcel.readInt();
    mContainerId = paramParcel.readInt();
    mTag = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mRetainInstance = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    mDetached = bool1;
    mArguments = paramParcel.readBundle();
    if (paramParcel.readInt() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    mHidden = bool1;
    mSavedFragmentState = paramParcel.readBundle();
  }
  
  public FragmentState(Fragment paramFragment)
  {
    mClassName = paramFragment.getClass().getName();
    mIndex = mIndex;
    mFromLayout = mFromLayout;
    mFragmentId = mFragmentId;
    mContainerId = mContainerId;
    mTag = mTag;
    mRetainInstance = mRetainInstance;
    mDetached = mDetached;
    mArguments = mArguments;
    mHidden = mHidden;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Fragment instantiate(FragmentHostCallback paramFragmentHostCallback, FragmentContainer paramFragmentContainer, Fragment paramFragment, FragmentManagerNonConfig paramFragmentManagerNonConfig, Line paramLine)
  {
    if (mInstance == null)
    {
      Context localContext = paramFragmentHostCallback.getContext();
      Bundle localBundle = mArguments;
      if (localBundle != null) {
        localBundle.setClassLoader(localContext.getClassLoader());
      }
      if (paramFragmentContainer != null) {
        mInstance = paramFragmentContainer.instantiate(localContext, mClassName, mArguments);
      } else {
        mInstance = Fragment.instantiate(localContext, mClassName, mArguments);
      }
      paramFragmentContainer = mSavedFragmentState;
      if (paramFragmentContainer != null)
      {
        paramFragmentContainer.setClassLoader(localContext.getClassLoader());
        mInstance.mSavedFragmentState = mSavedFragmentState;
      }
      mInstance.setIndex(mIndex, paramFragment);
      paramFragmentContainer = mInstance;
      mFromLayout = mFromLayout;
      mRestored = true;
      mFragmentId = mFragmentId;
      mContainerId = mContainerId;
      mTag = mTag;
      mRetainInstance = mRetainInstance;
      mDetached = mDetached;
      mHidden = mHidden;
      mFragmentManager = mFragmentManager;
      if (FragmentManagerImpl.DEBUG)
      {
        paramFragmentHostCallback = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Instantiated fragment ");
        paramFragmentHostCallback.append(mInstance);
        paramFragmentHostCallback.toString();
      }
    }
    paramFragmentHostCallback = mInstance;
    mChildNonConfig = paramFragmentManagerNonConfig;
    mViewModelStore = paramLine;
    return paramFragmentHostCallback;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
}
