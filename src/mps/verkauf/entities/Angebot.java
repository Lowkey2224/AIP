package mps.verkauf.entities;

import mps.verkauf.dtos.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "angebot")
public class Angebot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(nullable = false,  unique = true)
    private int nr;

    @Column(nullable = false)
    private Date gueltigAb;

    @Column(nullable = false)
    private Date gueltigBis;

    @Column(nullable = false)
    private int preis;

    @Column(nullable = false)
    private int kundeNr;

    @Column(nullable = false)
    private int bauteilNr;

    @OneToOne(mappedBy = "angebot")
    private Auftrag auftrag;

    public Angebot()
    {
        gueltigAb = new Date();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(!(o instanceof Angebot))
            return false;
        Angebot a = (Angebot)o;
        if(a.getKundeNr()!= kundeNr || a.getNr() != nr || a.getPreis() != preis || a.getBauteilNr() != bauteilNr)
            return false;
        if(!a.getGueltigAb().equals(getGueltigAb()))
            return false;
        if(!a.getGueltigBis().equals((getGueltigBis())))
            return false;
        return true;
    }

    public static Angebot fromDTO(AngebotDTO angebot) {
        Angebot ang = new Angebot();

        ang.nr = angebot.getNr();
        ang.gueltigAb = angebot.getGueltigAb();
        ang.gueltigBis = angebot.getGueltigBis();
        ang.preis = angebot.getPreis();
        ang.kundeNr = angebot.getKundeNr();
        ang.bauteilNr = angebot.getBauteilNr();
        return ang;
    }

    public AngebotDTO toDTO()
    {
        return new AngebotDTO(nr, gueltigAb, gueltigBis, preis, kundeNr, bauteilNr);
    }

    public int getNr() {
        return nr;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public int getPreis() {
        return preis;
    }

    public int getKundeNr() {
        return kundeNr;
    }

    public int getBauteilNr() {
        return bauteilNr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setKundeNr(int kundeNr) {
        this.kundeNr = kundeNr;
    }

    public void setBauteilNr(int bauteilNr) {
        this.bauteilNr = bauteilNr;
    }

    public void setAuftrag(Auftrag auftrag) {
        this.auftrag = auftrag;
    }

}
