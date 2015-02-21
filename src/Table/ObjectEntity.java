package Table;

import java.io.Serializable;

/**
 * Created by Marolok on 07.02.2015.
 */
public class ObjectEntity implements Serializable{
    private int id;
    private String name;
    private String img;
    private String mod3D;
    private Integer x;
    private Integer y;
    private Integer z;
    private boolean link;
    private Integer type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMod3D() {
        return mod3D;
    }

    public void setMod3D(String mod3D) {
        this.mod3D = mod3D;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public boolean getLink() {
        return link;
    }

    public void setLink(boolean link) {
        this.link = link;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectEntity that = (ObjectEntity) o;

        if (id != that.id) return false;
        if (link != that.link) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (mod3D != null ? !mod3D.equals(that.mod3D) : that.mod3D != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (z != null ? !z.equals(that.z) : that.z != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (mod3D != null ? mod3D.hashCode() : 0);
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (z != null ? z.hashCode() : 0);
        if(link) result = 31 * result + 1;
        else result = 31 * result;
        result = 31 * result + type;
        return result;
    }

    public String toString(){
        String str = "";
        if(link) str += this.type + ", '" + this.name + "','"+this.img+"','"+this.mod3D+"',"+x+","+y+","+z+","+1;
        else str += this.type + ", '" + this.name + "','"+this.img+"','"+this.mod3D+"',"+x+","+y+","+z+","+0;
        //str += this.type + ", '" + this.name + "','"+this.img+"','"+this.mod3D+"',"+x+","+y+","+z+",'"+link+"'";
        return str;
    }
}
