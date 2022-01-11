package eu._5gzorro.tm_forum.models;

import java.util.Objects;

/**
 * A GeographicPoint defines a geographic point through coordinates
 */
public class GeographicPoint {

    private String id = null;
    private String x;
    private String y;
    private String z;

    /**
     * Unique identifier of the geographic point
     *
     * @return id
     **/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeographicPoint id(String id) {
        this.id = id;
        return this;
    }

    /**
     * x coordinate (usually latitude)
     *
     * @return x
     **/
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public GeographicPoint x(String x) {
        this.x = x;
        return this;
    }

    /**
     * y coordinate (usually longitude)
     *
     * @return y
     **/
    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public GeographicPoint y(String y) {
        this.y = y;
        return this;
    }

    /**
     * z coordinate (usually elevation)
     *
     * @return z
     **/
    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public GeographicPoint z(String z) {
        this.z = z;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GeographicPoint that = (GeographicPoint) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(x, that.x) &&
                Objects.equals(y, that.y) &&
                Objects.equals(z, that.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y, z);
    }

    @Override
    public String toString() {
        return "GeographicPoint{" +
                "id='" + id + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                '}';
    }

}
