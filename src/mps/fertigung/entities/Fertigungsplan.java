package mps.fertigung.entities;

import mps.fertigung.dtos.*;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 13.11.13
 * Time: 08:52
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "fertigungsplan")
public class Fertigungsplan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(nullable = false, unique = true)
    private int nr;
    @Column(nullable = false, unique = true)
    private int auftragNr;
    @Column(nullable = false)
    private int bauteilNr;
    @Column(nullable = false)
    private boolean abgeschlossen;

    public Fertigungsplan() {

    }

    public static Fertigungsplan fromDTO(FertigungsplanDTO dto)
    {
        Fertigungsplan fp = new Fertigungsplan();
        fp.id = dto.getId();
        fp.nr = dto.getNr();
        fp.auftragNr = dto.getAuftragNr();
        fp.bauteilNr = dto.getAuftragNr();
        fp.abgeschlossen = false;
        return fp;
    }

    public FertigungsplanDTO toDTO()
    {
        FertigungsplanDTO dto = new FertigungsplanDTO(this.bauteilNr, this.nr, this.auftragNr);
        dto.setId(this.id);
        return dto;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getAuftragNr() {
        return auftragNr;
    }

    public void setAuftragNr(int auftragNr) {
        this.auftragNr = auftragNr;
    }

    public int getBauteilNr() {
        return bauteilNr;
    }

    public void setBauteilNr(int produktId) {
        this.bauteilNr = produktId;
    }


    public void setAbgeschlossen(boolean abgeschlossen) {
        this.abgeschlossen = abgeschlossen;
    }
    public boolean getAbgeschlossen() {
        return abgeschlossen;
    }

}
