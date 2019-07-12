package org.spongycastle.jcajce;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.IOException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import org.spongycastle.util.Selector;

public class PKIXCertStoreSelector<T extends Certificate>
  implements Selector<T>
{
  public final CertSelector baseSelector;
  
  public PKIXCertStoreSelector(CertSelector paramCertSelector)
  {
    baseSelector = paramCertSelector;
  }
  
  public static Collection getCertificates(PKIXCertStoreSelector paramPKIXCertStoreSelector, CertStore paramCertStore)
    throws CertStoreException
  {
    return paramCertStore.getCertificates(new SelectorClone(paramPKIXCertStoreSelector));
  }
  
  public Object clone()
  {
    return new PKIXCertStoreSelector(baseSelector);
  }
  
  public boolean match(Certificate paramCertificate)
  {
    return baseSelector.match(paramCertificate);
  }
  
  public static class Builder
  {
    public final CertSelector baseSelector;
    
    public Builder(CertSelector paramCertSelector)
    {
      baseSelector = ((CertSelector)paramCertSelector.clone());
    }
    
    public PKIXCertStoreSelector build()
    {
      return new PKIXCertStoreSelector(baseSelector, null);
    }
  }
  
  private static class SelectorClone
    extends X509CertSelector
  {
    public final PKIXCertStoreSelector selector;
    
    public SelectorClone(PKIXCertStoreSelector paramPKIXCertStoreSelector)
    {
      selector = paramPKIXCertStoreSelector;
      if ((PKIXCertStoreSelector.access$100(paramPKIXCertStoreSelector) instanceof X509CertSelector))
      {
        paramPKIXCertStoreSelector = (X509CertSelector)PKIXCertStoreSelector.access$100(paramPKIXCertStoreSelector);
        setAuthorityKeyIdentifier(paramPKIXCertStoreSelector.getAuthorityKeyIdentifier());
        setBasicConstraints(paramPKIXCertStoreSelector.getBasicConstraints());
        setCertificate(paramPKIXCertStoreSelector.getCertificate());
        setCertificateValid(paramPKIXCertStoreSelector.getCertificateValid());
        setKeyUsage(paramPKIXCertStoreSelector.getKeyUsage());
        setMatchAllSubjectAltNames(paramPKIXCertStoreSelector.getMatchAllSubjectAltNames());
        setPrivateKeyValid(paramPKIXCertStoreSelector.getPrivateKeyValid());
        setSerialNumber(paramPKIXCertStoreSelector.getSerialNumber());
        setSubjectKeyIdentifier(paramPKIXCertStoreSelector.getSubjectKeyIdentifier());
        setSubjectPublicKey(paramPKIXCertStoreSelector.getSubjectPublicKey());
        try
        {
          setExtendedKeyUsage(paramPKIXCertStoreSelector.getExtendedKeyUsage());
          setIssuer(paramPKIXCertStoreSelector.getIssuerAsBytes());
          setNameConstraints(paramPKIXCertStoreSelector.getNameConstraints());
          setPathToNames(paramPKIXCertStoreSelector.getPathToNames());
          setPolicy(paramPKIXCertStoreSelector.getPolicy());
          setSubject(paramPKIXCertStoreSelector.getSubjectAsBytes());
          setSubjectAlternativeNames(paramPKIXCertStoreSelector.getSubjectAlternativeNames());
          setSubjectPublicKeyAlgID(paramPKIXCertStoreSelector.getSubjectPublicKeyAlgID());
          return;
        }
        catch (IOException paramPKIXCertStoreSelector)
        {
          throw new IllegalStateException(StringBuilder.get(paramPKIXCertStoreSelector, StringBuilder.append("base selector invalid: ")), paramPKIXCertStoreSelector);
        }
      }
    }
    
    public boolean match(Certificate paramCertificate)
    {
      PKIXCertStoreSelector localPKIXCertStoreSelector = selector;
      if (localPKIXCertStoreSelector == null) {
        return paramCertificate != null;
      }
      return localPKIXCertStoreSelector.match(paramCertificate);
    }
  }
}
