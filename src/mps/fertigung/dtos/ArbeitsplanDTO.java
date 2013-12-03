package mps.fertigung.dtos;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 13.11.13
 * Time: 08:52
 * To change this template use File | Settings | File Templates.
 */
public class ArbeitsplanDTO {

    private int nr;
    private int id;
    private int bauteilNr;

    public int getBauteilNr() {
        return bauteilNr;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof ArbeitsplanDTO))
            return false;
        ArbeitsplanDTO a = (ArbeitsplanDTO) o;
        if(a.getId() != this.getId())
            return false;
        if(a.getBauteilNr() != this.getBauteilNr())
            return false;
        if(a.getNr() !=  this.getNr())
            return false;
        return true;
    }

    public void setBauteilNr(int bauteilNr) {
        this.bauteilNr = bauteilNr;
    }

    public ArbeitsplanDTO(int nr, int bauteilNr) {
        this.bauteilNr = bauteilNr;
        this.nr = nr;
        
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    


    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }
    



}
