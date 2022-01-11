package eu._5gzorro.tm_forum.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A geographicLocation allows referring a geographicLocation through an id, or, describing through coordinate(s) a point, a line or a space.
 */

public class GeographicLocation {

    private String id = null;
    private String href = null;
    private String name = null;
    private String geometryType = null;
    private String accuracy = null;
    private String spatialRef = null;
    private String type = null;
    private String schemaLocation = null;
    private List<GeographicPoint> geometry = null;

    public GeographicLocation id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Unique identifier of the geographic location
     *
     * @return id
     **/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeographicLocation href(String href) {
        this.href = href;
        return this;
    }

    /**
     * An URI used to access to the geographic location resource
     *
     * @return href
     **/

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public GeographicLocation name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the geographic location
     *
     * @return name
     **/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeographicLocation geometryType(String geometryType) {
        this.geometryType = geometryType;
        return this;
    }

    /**
     * Type allows describing Geographic Location form: it could be a point, a line, a polygon, a cylinder, etc ...
     *
     * @return geometryType
     **/

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public GeographicLocation accuracy(String accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    /**
     * Accuracy of the coordinate specified
     *
     * @return geometryType
     **/

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public GeographicLocation type(String type) {
        this.type = type;
        return this;
    }

    public GeographicLocation spatialRef(String spatialRef) {
        this.spatialRef = spatialRef;
        return this;
    }

    /**
     * Geocoding referential
     *
     * @return spatialRef
     **/

    public String getSpatialRef() {
        return accuracy;
    }

    public void setSpatialRef(String spatialRef) {
        this.spatialRef = spatialRef;
    }

    /**
     * Indicates the type of resource
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * A link to the schema describing this REST Resource
     *
     * @return schemaLocation
     **/

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public GeographicLocation geometry(List<GeographicPoint> geometry) {
        this.geometry = geometry;
        return this;
    }

    public GeographicLocation addGeometryItem(GeographicPoint geometryItem) {
        if (this.geometry == null) {
            this.geometry = new ArrayList<GeographicPoint>();
        }
        this.geometry.add(geometryItem);
        return this;
    }

    /**
     * A list of geographic points (GeographicPoint [*]). A GeographicPoint defines a geographic point through coordinates
     *
     * @return geometry
     **/

    public List<GeographicPoint> getGeometry() {
        return geometry;
    }

    public void setGeometry(List<GeographicPoint> geometry) {
        this.geometry = geometry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GeographicLocation geographicLocation = (GeographicLocation) o;
        return Objects.equals(this.id, geographicLocation.id) &&
                Objects.equals(this.name, geographicLocation.name) &&
                Objects.equals(this.href, geographicLocation.href) &&
                Objects.equals(this.geometryType, geographicLocation.geometryType) &&
                Objects.equals(this.accuracy, geographicLocation.accuracy) &&
                Objects.equals(this.spatialRef, geographicLocation.spatialRef) &&
                Objects.equals(this.type, geographicLocation.type) &&
                Objects.equals(this.schemaLocation, geographicLocation.schemaLocation) &&
                Objects.equals(this.geometry, geographicLocation.geometry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, href, geometryType, accuracy, spatialRef, type, schemaLocation, geometry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GeographicLocation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    geometryType: ").append(toIndentedString(geometryType)).append("\n");
        sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
        sb.append("    spatialRef: ").append(toIndentedString(spatialRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
        sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
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
