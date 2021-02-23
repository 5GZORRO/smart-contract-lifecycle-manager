package eu._5gzorro.manager.domain;


import java.util.List;

public class ProductOffering {
  private String name;
  private List<Place> places;
  private List<ProductOfferTerm> productOfferTerms;
  private ServiceCandidate serviceCandidate;
  private List<ServiceLevelAgreement> serviceLevelAgreements;

  public String getName() {
    return name;
  }

  public ProductOffering setName(String name) {
    this.name = name;
    return this;
  }

  public List<Place> getPlaces() {
    return places;
  }

  public ProductOffering setPlaces(List<Place> places) {
    this.places = places;
    return this;
  }

  public List<ProductOfferTerm> getProductOfferTerms() {
    return productOfferTerms;
  }

  public ProductOffering setProductOfferTerms(
      List<ProductOfferTerm> productOfferTerms) {
    this.productOfferTerms = productOfferTerms;
    return this;
  }

  public ServiceCandidate getServiceCandidate() {
    return serviceCandidate;
  }

  public ProductOffering setServiceCandidate(
      ServiceCandidate serviceCandidate) {
    this.serviceCandidate = serviceCandidate;
    return this;
  }

  public List<ServiceLevelAgreement> getServiceLevelAgreements() {
    return serviceLevelAgreements;
  }

  public ProductOffering setServiceLevelAgreements(List<ServiceLevelAgreement> serviceLevelAgreements) {
    this.serviceLevelAgreements = serviceLevelAgreements;
    return this;
  }
}
