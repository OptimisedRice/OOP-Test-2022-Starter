package ie.tudublin;

import processing.core.PApplet;
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

    public void render(NematodeVisualiser nv)
    {
        float color = PApplet.map(nv.i, 0, nv.nematodes.size() - 1, 0, 255);
        nv.stroke(color, 255, 255);
        int nemaWidth = 40;
        int textsize = 40;
        nv.background(0);
        nv.fill(color, 255, 255);
        nv.textSize(textsize);
        nv.textAlign(PApplet.CENTER, PApplet.CENTER);
        nv.text(name, nv.width/2, (nv.height/2 - (length/2 * nemaWidth) - (textsize * 2)));

        nv.strokeWeight(3);
        nv.noFill();
        for(int seg = 0; seg < length; seg++)
        {
            nv.pushMatrix();
            nv.translate(nv.width/2, (nv.height/2 - (length/2 * nemaWidth)) + (nemaWidth * seg));

            if(eyes && seg == 0)
            {
                nv.line(
                    PApplet.sin(PApplet.radians(180-45)) * nemaWidth/2, 
                    PApplet.cos(PApplet.radians(180-45)) * nemaWidth/2, 
                    PApplet.sin(PApplet.radians(180-45)) * nemaWidth, 
                    PApplet.cos(PApplet.radians(180-45)) * nemaWidth
                );

                nv.circle(PApplet.sin(PApplet.radians(180-45)) * nemaWidth + 5, PApplet.cos(PApplet.radians(180-45)) * nemaWidth - 5, 10);
                
                nv.line(
                    PApplet.sin(PApplet.radians(180+45)) * nemaWidth/2, 
                    PApplet.cos(PApplet.radians(180+45)) * nemaWidth/2, 
                    PApplet.sin(PApplet.radians(180+45)) * nemaWidth, 
                    PApplet.cos(PApplet.radians(180+45)) * nemaWidth
                );

                nv.circle(PApplet.sin(PApplet.radians(180+45)) * nemaWidth - 5, PApplet.cos(PApplet.radians(180+45)) * nemaWidth - 5, 10);
            }
            nv.circle(0, 0, nemaWidth);

            if(limbs)
            {
                nv.line(-nemaWidth, 0, -nemaWidth/2, 0);
                nv.line(nemaWidth/2, 0, nemaWidth, 0);
            }

            if(seg == length - 1)
            {
                switch(gender)
                {
                    case "m":
                    {
                        nv.line(0, nemaWidth/2, 0, nemaWidth);
                        nv.circle(0, nemaWidth + 5, 10);
                        break;
                    }
                    case "f":
                    {
                        nv.circle(0, 0, nemaWidth/2);
                        break;
                    }
                    case "h":
                    {
                        nv.circle(0, 0, nemaWidth/2);

                        nv.line(0, nemaWidth/2, 0, nemaWidth);
                        nv.circle(0, nemaWidth + 5, 10);
                        break;
                    }
                    case "n":
                    {
                        break;
                    }
                }
            }
            nv.popMatrix();

        }
    }

}
