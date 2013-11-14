package mps.fertigung.dtos;

import mps.verkauf.dtos.AuftragDTO;

import java.util.List;

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
