package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * Structured textual way of describing how to find a Property in an urban area (country properties are often defined differently). Note : Address corresponds to SID UrbanPropertyAddress
 */
public class GeographicAddress {

    private String id = null;
    private String href = null;
    private String city = null;
    private String country = null;
    private String locality = null;
    private String postcode = null;
    private String stateOrProvince = null;
    private String streetName = null;
    private String streetNr = null;
    private String streetNrLast = null;
    private String streetNrLastSuffix = null;
    private String streetNrSuffix = null;
    private String streetSuffix = null;
    private String streetType = null;
    private GeographicLocation geographicLocation = null;
    private String schemaLocation = null;
    private String type = null;

    public GeographicAddress id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Unique identifier of the place
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeographicAddress href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Unique reference of the place
     *
     * @return href
     **/
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public GeographicAddress city(String city) {
        this.city = city;
        return this;
    }

    /**
     * City that the address is in
     *
     * @return city
     **/
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GeographicAddress country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Country that the address is in
     *
     * @return country
     **/
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeographicAddress locality(String locality) {
        this.locality = locality;
        return this;
    }

    /**
     * An area of defined or undefined boundaries within a local authority or other legislatively defined area, usually rural or semi rural in nature. [ANZLIC-STREET], or a suburb, a bounded locality within a city, town or shire principally of urban character [ANZLICSTREET]
     *
     * @return locality
     **/
    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public GeographicAddress postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * descriptor for a postal delivery area, used to speed and simplify the delivery of mail (also know as zipcode)
     *
     * @return postcode
     **/
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public GeographicAddress stateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    /**
     * the State or Province that the address is in
     *
     * @return stateOrProvince
     **/
    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public GeographicAddress streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    /**
     * Name of the street or other street type
     *
     * @return streetName
     **/
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public GeographicAddress streetNr(String streetNr) {
        this.streetNr = streetNr;
        return this;
    }

    /**
     * Number identifying a specific property on a public street. It may be combined with streetNrLast for ranged addresses
     *
     * @return streetNr
     **/
    public String getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(String streetNr) {
        this.streetNr = streetNr;
    }

    public GeographicAddress streetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
        return this;
    }

    /**
     * Last number in a range of street numbers allocated to a property
     *
     * @return streetNrLast
     **/
    public String getStreetNrLast() {
        return streetNrLast;
    }

    public void setStreetNrLast(String streetNrLast) {
        this.streetNrLast = streetNrLast;
    }

    public GeographicAddress streetNrLastSuffix(String streetNrLastSuffix) {
        this.streetNrLastSuffix = streetNrLastSuffix;
        return this;
    }

    /**
     * Last street number suffix for a ranged address
     *
     * @return streetNrLastSuffix
     **/
    public String getStreetNrLastSuffix() {
        return streetNrLastSuffix;
    }

    public void setStreetNrLastSuffix(String streetNrLastSuffix) {
        this.streetNrLastSuffix = streetNrLastSuffix;
    }

    public GeographicAddress streetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
        return this;
    }

    /**
     * the first street number suffix
     *
     * @return streetNrSuffix
     **/
    public String getStreetNrSuffix() {
        return streetNrSuffix;
    }

    public void setStreetNrSuffix(String streetNrSuffix) {
        this.streetNrSuffix = streetNrSuffix;
    }

    public GeographicAddress streetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
        return this;
    }

    /**
     * A modifier denoting a relative direction
     *
     * @return streetSuffix
     **/
    public String getStreetSuffix() {
        return streetSuffix;
    }

    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public GeographicAddress streetType(String streetType) {
        this.streetType = streetType;
        return this;
    }

    /**
     * alley, avenue, boulevard, brae, crescent, drive, highway, lane, terrace, parade, place, tarn, way, wharf
     *
     * @return streetType
     **/
    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public GeographicAddress geographicLocation(GeographicLocation geographicLocation) {
        this.geographicLocation = geographicLocation;
        return this;
    }

    /**
     * Get geographicLocation
     *
     * @return geographicLocation
     **/
    public GeographicLocation getGeographicLocation() {
        return geographicLocation;
    }

    public void setGeographicLocation(GeographicLocation geographicLocation) {
        this.geographicLocation = geographicLocation;
    }

    /**
     * A URI to a JSON-Schema file that defines additional attributes and relationships
     *
     * @return schemaLocation
     **/
    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public GeographicAddress type(String type) {
        this.type = type;
        return this;
    }

    /**
     * When sub-classing, this defines the sub-class entity name
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GeographicAddress geographicAddress = (GeographicAddress) o;
        return Objects.equals(this.id, geographicAddress.id) &&
                Objects.equals(this.href, geographicAddress.href) &&
                Objects.equals(this.city, geographicAddress.city) &&
                Objects.equals(this.country, geographicAddress.country) &&
                Objects.equals(this.locality, geographicAddress.locality) &&
                Objects.equals(this.postcode, geographicAddress.postcode) &&
                Objects.equals(this.stateOrProvince, geographicAddress.stateOrProvince) &&
                Objects.equals(this.streetName, geographicAddress.streetName) &&
                Objects.equals(this.streetNr, geographicAddress.streetNr) &&
                Objects.equals(this.streetNrLast, geographicAddress.streetNrLast) &&
                Objects.equals(this.streetNrLastSuffix, geographicAddress.streetNrLastSuffix) &&
                Objects.equals(this.streetNrSuffix, geographicAddress.streetNrSuffix) &&
                Objects.equals(this.streetSuffix, geographicAddress.streetSuffix) &&
                Objects.equals(this.streetType, geographicAddress.streetType) &&
                Objects.equals(this.geographicLocation, geographicAddress.geographicLocation) &&
                Objects.equals(this.schemaLocation, geographicAddress.schemaLocation) &&
                Objects.equals(this.type, geographicAddress.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, href, city, country, locality, postcode, stateOrProvince, streetName, streetNr, streetNrLast, streetNrLastSuffix, streetNrSuffix, streetSuffix, streetType, geographicLocation, schemaLocation, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GeographicAddress {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    stateOrProvince: ").append(toIndentedString(stateOrProvince)).append("\n");
        sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
        sb.append("    streetNr: ").append(toIndentedString(streetNr)).append("\n");
        sb.append("    streetNrLast: ").append(toIndentedString(streetNrLast)).append("\n");
        sb.append("    streetNrLastSuffix: ").append(toIndentedString(streetNrLastSuffix)).append("\n");
        sb.append("    streetNrSuffix: ").append(toIndentedString(streetNrSuffix)).append("\n");
        sb.append("    streetSuffix: ").append(toIndentedString(streetSuffix)).append("\n");
        sb.append("    streetType: ").append(toIndentedString(streetType)).append("\n");
        sb.append("    geographicLocation: ").append(toIndentedString(geographicLocation)).append("\n");
        sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
