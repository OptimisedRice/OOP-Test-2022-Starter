package ie.tudublin;

import processing.data.TableRow;

public class Nematode
{
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow row)
    {
        this
        (row.getString("name"), row.getInt("length"), row.getInt("limbs") == 1, row.getString("gender"), row.getInt("eyes") == 1);
    }

    @Override
    public String toString() {
        return "Nematode [Name =" + name + ", Gender =" + gender + ", Length =" + length + " ] ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

}
