package org.spongycastle.jcajce;

import java.security.InvalidParameterException;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PKIXExtendedBuilderParameters
  implements CertPathParameters
{
  public final PKIXExtendedParameters baseParameters;
  public final Set<X509Certificate> excludedCerts;
  public final int maxPathLength;
  
  public PKIXExtendedBuilderParameters(Builder paramBuilder)
  {
    baseParameters = baseParameters;
    excludedCerts = Collections.unmodifiableSet(excludedCerts);
    maxPathLength = maxPathLength;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public PKIXExtendedParameters getBaseParameters()
  {
    return baseParameters;
  }
  
  public Set getExcludedCerts()
  {
    return excludedCerts;
  }
  
  public int getMaxPathLength()
  {
    return maxPathLength;
  }
  
  public static class Builder
  {
    public final PKIXExtendedParameters baseParameters;
    public Set<X509Certificate> excludedCerts = new HashSet();
    public int maxPathLength = 5;
    
    public Builder(PKIXBuilderParameters paramPKIXBuilderParameters)
    {
      baseParameters = new PKIXExtendedParameters.Builder(paramPKIXBuilderParameters).build();
      maxPathLength = paramPKIXBuilderParameters.getMaxPathLength();
    }
    
    public Builder(PKIXExtendedParameters paramPKIXExtendedParameters)
    {
      baseParameters = paramPKIXExtendedParameters;
    }
    
    public Builder addExcludedCerts(Set paramSet)
    {
      excludedCerts.addAll(paramSet);
      return this;
    }
    
    public PKIXExtendedBuilderParameters build()
    {
      return new PKIXExtendedBuilderParameters(this);
    }
    
    public Builder setMaxPathLength(int paramInt)
    {
      if (paramInt >= -1)
      {
        maxPathLength = paramInt;
        return this;
      }
      throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
    }
  }
}
