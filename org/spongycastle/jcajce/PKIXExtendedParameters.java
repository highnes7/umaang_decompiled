package org.spongycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.x509.GeneralName;

public class PKIXExtendedParameters
  implements CertPathParameters
{
  public static final int CHAIN_VALIDITY_MODEL = 1;
  public static final int PKIX_VALIDITY_MODEL = 0;
  public final PKIXParameters baseParameters;
  public final Date date;
  public final List<PKIXCRLStore> extraCRLStores;
  public final List<PKIXCertStore> extraCertStores;
  public final Map<GeneralName, PKIXCRLStore> namedCRLStoreMap;
  public final Map<GeneralName, PKIXCertStore> namedCertificateStoreMap;
  public final boolean revocationEnabled;
  public final PKIXCertStoreSelector targetConstraints;
  public final Set<TrustAnchor> trustAnchors;
  public final boolean useDeltas;
  public final int validityModel;
  
  public PKIXExtendedParameters(Builder paramBuilder)
  {
    baseParameters = baseParameters;
    date = date;
    extraCertStores = Collections.unmodifiableList(extraCertStores);
    namedCertificateStoreMap = Collections.unmodifiableMap(new HashMap(namedCertificateStoreMap));
    extraCRLStores = Collections.unmodifiableList(extraCRLStores);
    namedCRLStoreMap = Collections.unmodifiableMap(new HashMap(namedCRLStoreMap));
    targetConstraints = targetConstraints;
    revocationEnabled = revocationEnabled;
    useDeltas = useDeltas;
    validityModel = validityModel;
    trustAnchors = Collections.unmodifiableSet(trustAnchors);
  }
  
  public Object clone()
  {
    return this;
  }
  
  public List getCRLStores()
  {
    return extraCRLStores;
  }
  
  public List getCertPathCheckers()
  {
    return baseParameters.getCertPathCheckers();
  }
  
  public List getCertStores()
  {
    return baseParameters.getCertStores();
  }
  
  public List getCertificateStores()
  {
    return extraCertStores;
  }
  
  public Date getDate()
  {
    return new Date(date.getTime());
  }
  
  public Set getInitialPolicies()
  {
    return baseParameters.getInitialPolicies();
  }
  
  public Map getNamedCRLStoreMap()
  {
    return namedCRLStoreMap;
  }
  
  public Map getNamedCertificateStoreMap()
  {
    return namedCertificateStoreMap;
  }
  
  public String getSigProvider()
  {
    return baseParameters.getSigProvider();
  }
  
  public PKIXCertStoreSelector getTargetConstraints()
  {
    return targetConstraints;
  }
  
  public Set getTrustAnchors()
  {
    return trustAnchors;
  }
  
  public int getValidityModel()
  {
    return validityModel;
  }
  
  public boolean isAnyPolicyInhibited()
  {
    return baseParameters.isAnyPolicyInhibited();
  }
  
  public boolean isExplicitPolicyRequired()
  {
    return baseParameters.isExplicitPolicyRequired();
  }
  
  public boolean isPolicyMappingInhibited()
  {
    return baseParameters.isPolicyMappingInhibited();
  }
  
  public boolean isRevocationEnabled()
  {
    return revocationEnabled;
  }
  
  public boolean isUseDeltasEnabled()
  {
    return useDeltas;
  }
  
  public static class Builder
  {
    public final PKIXParameters baseParameters;
    public final Date date;
    public List<PKIXCRLStore> extraCRLStores = new ArrayList();
    public List<PKIXCertStore> extraCertStores = new ArrayList();
    public Map<GeneralName, PKIXCRLStore> namedCRLStoreMap = new HashMap();
    public Map<GeneralName, PKIXCertStore> namedCertificateStoreMap = new HashMap();
    public boolean revocationEnabled;
    public PKIXCertStoreSelector targetConstraints;
    public Set<TrustAnchor> trustAnchors;
    public boolean useDeltas = false;
    public int validityModel = 0;
    
    public Builder(PKIXParameters paramPKIXParameters)
    {
      baseParameters = ((PKIXParameters)paramPKIXParameters.clone());
      Object localObject = paramPKIXParameters.getTargetCertConstraints();
      if (localObject != null) {
        targetConstraints = new PKIXCertStoreSelector.Builder((CertSelector)localObject).build();
      }
      Date localDate = paramPKIXParameters.getDate();
      localObject = localDate;
      if (localDate == null) {
        localObject = new Date();
      }
      date = ((Date)localObject);
      revocationEnabled = paramPKIXParameters.isRevocationEnabled();
      trustAnchors = paramPKIXParameters.getTrustAnchors();
    }
    
    public Builder(PKIXExtendedParameters paramPKIXExtendedParameters)
    {
      baseParameters = PKIXExtendedParameters.access$000(paramPKIXExtendedParameters);
      date = PKIXExtendedParameters.access$100(paramPKIXExtendedParameters);
      targetConstraints = PKIXExtendedParameters.access$200(paramPKIXExtendedParameters);
      extraCertStores = new ArrayList(PKIXExtendedParameters.access$300(paramPKIXExtendedParameters));
      namedCertificateStoreMap = new HashMap(PKIXExtendedParameters.access$400(paramPKIXExtendedParameters));
      extraCRLStores = new ArrayList(PKIXExtendedParameters.access$500(paramPKIXExtendedParameters));
      namedCRLStoreMap = new HashMap(PKIXExtendedParameters.access$600(paramPKIXExtendedParameters));
      useDeltas = PKIXExtendedParameters.access$700(paramPKIXExtendedParameters);
      validityModel = PKIXExtendedParameters.access$800(paramPKIXExtendedParameters);
      revocationEnabled = paramPKIXExtendedParameters.isRevocationEnabled();
      trustAnchors = paramPKIXExtendedParameters.getTrustAnchors();
    }
    
    public Builder addCRLStore(PKIXCRLStore paramPKIXCRLStore)
    {
      extraCRLStores.add(paramPKIXCRLStore);
      return this;
    }
    
    public Builder addCertificateStore(PKIXCertStore paramPKIXCertStore)
    {
      extraCertStores.add(paramPKIXCertStore);
      return this;
    }
    
    public Builder addNamedCRLStore(GeneralName paramGeneralName, PKIXCRLStore paramPKIXCRLStore)
    {
      namedCRLStoreMap.put(paramGeneralName, paramPKIXCRLStore);
      return this;
    }
    
    public Builder addNamedCertificateStore(GeneralName paramGeneralName, PKIXCertStore paramPKIXCertStore)
    {
      namedCertificateStoreMap.put(paramGeneralName, paramPKIXCertStore);
      return this;
    }
    
    public PKIXExtendedParameters build()
    {
      return new PKIXExtendedParameters(this);
    }
    
    public void setRevocationEnabled(boolean paramBoolean)
    {
      revocationEnabled = paramBoolean;
    }
    
    public Builder setTargetConstraints(PKIXCertStoreSelector paramPKIXCertStoreSelector)
    {
      targetConstraints = paramPKIXCertStoreSelector;
      return this;
    }
    
    public Builder setTrustAnchor(TrustAnchor paramTrustAnchor)
    {
      trustAnchors = Collections.singleton(paramTrustAnchor);
      return this;
    }
    
    public Builder setTrustAnchors(Set paramSet)
    {
      trustAnchors = paramSet;
      return this;
    }
    
    public Builder setUseDeltasEnabled(boolean paramBoolean)
    {
      useDeltas = paramBoolean;
      return this;
    }
    
    public Builder setValidityModel(int paramInt)
    {
      validityModel = paramInt;
      return this;
    }
  }
}
