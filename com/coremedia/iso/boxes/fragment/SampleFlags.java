package com.coremedia.iso.boxes.fragment;

import f.h.a.c.e.a.c;
import java.nio.ByteBuffer;

public class SampleFlags
{
  public int reserved;
  public int sampleDegradationPriority;
  public int sampleDependsOn;
  public int sampleHasRedundancy;
  public int sampleIsDependedOn;
  public boolean sampleIsDifferenceSample;
  public int samplePaddingValue;
  
  public SampleFlags() {}
  
  public SampleFlags(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer = new c(paramByteBuffer);
    reserved = paramByteBuffer.a(6);
    sampleDependsOn = paramByteBuffer.a(2);
    sampleIsDependedOn = paramByteBuffer.a(2);
    sampleHasRedundancy = paramByteBuffer.a(2);
    samplePaddingValue = paramByteBuffer.a(3);
    boolean bool = true;
    if (paramByteBuffer.a(1) != 1) {
      bool = false;
    }
    sampleIsDifferenceSample = bool;
    sampleDegradationPriority = paramByteBuffer.a(16);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (SampleFlags.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (SampleFlags)paramObject;
      if (reserved != reserved) {
        return false;
      }
      if (sampleDegradationPriority != sampleDegradationPriority) {
        return false;
      }
      if (sampleDependsOn != sampleDependsOn) {
        return false;
      }
      if (sampleHasRedundancy != sampleHasRedundancy) {
        return false;
      }
      if (sampleIsDependedOn != sampleIsDependedOn) {
        return false;
      }
      if (sampleIsDifferenceSample != sampleIsDifferenceSample) {
        return false;
      }
      return samplePaddingValue == samplePaddingValue;
    }
    return false;
  }
  
  public void getContent(ByteBuffer paramByteBuffer)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public int getReserved()
  {
    return reserved;
  }
  
  public int getSampleDegradationPriority()
  {
    return sampleDegradationPriority;
  }
  
  public int getSampleDependsOn()
  {
    return sampleDependsOn;
  }
  
  public int getSampleHasRedundancy()
  {
    return sampleHasRedundancy;
  }
  
  public int getSampleIsDependedOn()
  {
    return sampleIsDependedOn;
  }
  
  public int getSamplePaddingValue()
  {
    return samplePaddingValue;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public boolean isSampleIsDifferenceSample()
  {
    return sampleIsDifferenceSample;
  }
  
  public void setReserved(int paramInt)
  {
    reserved = paramInt;
  }
  
  public void setSampleDegradationPriority(int paramInt)
  {
    sampleDegradationPriority = paramInt;
  }
  
  public void setSampleDependsOn(int paramInt)
  {
    sampleDependsOn = paramInt;
  }
  
  public void setSampleHasRedundancy(int paramInt)
  {
    sampleHasRedundancy = paramInt;
  }
  
  public void setSampleIsDependedOn(int paramInt)
  {
    sampleIsDependedOn = paramInt;
  }
  
  public void setSampleIsDifferenceSample(boolean paramBoolean)
  {
    sampleIsDifferenceSample = paramBoolean;
  }
  
  public void setSamplePaddingValue(int paramInt)
  {
    samplePaddingValue = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SampleFlags{reserved=");
    localStringBuilder.append(reserved);
    localStringBuilder.append(", sampleDependsOn=");
    localStringBuilder.append(sampleDependsOn);
    localStringBuilder.append(", sampleHasRedundancy=");
    localStringBuilder.append(sampleHasRedundancy);
    localStringBuilder.append(", samplePaddingValue=");
    localStringBuilder.append(samplePaddingValue);
    localStringBuilder.append(", sampleIsDifferenceSample=");
    localStringBuilder.append(sampleIsDifferenceSample);
    localStringBuilder.append(", sampleDegradationPriority=");
    return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, sampleDegradationPriority, '}');
  }
}
