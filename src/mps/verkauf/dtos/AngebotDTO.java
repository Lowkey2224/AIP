package mps.verkauf.dtos;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */
public class AngebotDTO {

    private int nr;
    private Date gueltagAb;
    private Date gueltagBis;
    private int preis;
    private int kundeNr;
    private int bauteilNr;

    public int getPreis() {
        return preis;
    }

    public int getNr() {
        return nr;
    }

    public Date getGueltigAb() {
        return gueltagAb;
    }

    public Date getGueltigBis() {
        return gueltagBis;
    }

    public int getKundeNr() {
        return kundeNr;
    }

    public int getBauteilNr() {
        return bauteilNr;
    }

    public AngebotDTO(int nr, Date gueltagAb, Date gueltagBis, int preis, int kundeNr, int bauteilNr) {
        this.nr = nr;
        this.gueltagAb = gueltagAb;
        this.gueltagBis = gueltagBis;
        this.preis = preis;
        this.kundeNr = kundeNr;
        this.bauteilNr = bauteilNr;
    }

}
