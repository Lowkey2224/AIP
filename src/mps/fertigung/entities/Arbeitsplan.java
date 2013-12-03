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
@Table(name = "arbeitsplan")
public class Arbeitsplan{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(nullable = false, unique = true)
    private int nr;

    @Column(nullable = false, unique = true)
    private int bauteilNr;

    public Arbeitsplan() {

    }

    public static Arbeitsplan fromDTO(ArbeitsplanDTO dto)
    {
        Arbeitsplan fp = new Arbeitsplan();
        fp.id = dto.getId();
        fp.nr = dto.getNr();
        fp.bauteilNr = dto.getBauteilNr();
        return fp;
    }

    public ArbeitsplanDTO toDTO()
    {
        ArbeitsplanDTO dto = new ArbeitsplanDTO(this.nr, this.bauteilNr);
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

    public int getBauteilNr() {
        return bauteilNr;
    }

    public void setBauteilNr(int produktId) {
        this.bauteilNr = produktId;
    }

}
