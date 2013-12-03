package mps.materialwirtschaft.entities;

import javax.persistence.*;
import mps.materialwirtschaft.dtos.*;
/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "bauteil")
public class Bauteil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private int nr;
    @Column(unique = false, nullable = false)
    private String name;
    @OneToOne()
    private Stueckliste stueckliste;    

    public Bauteil() {
        this.stueckliste = new Stueckliste();
//        this.name = name;
//        this.nr = nr;
    }

    @Override
    public boolean equals(Object o )
    {
        if(o == null)
            return false;
        if(!(o instanceof Bauteil))
            return false;
        Bauteil b = (Bauteil)o;
        if(b.getNr() != this.getNr())
            return false;
        if(!b.getName().equals(this.getName()))
            return false;
        if(!b.getStueckliste().equals(this.getStueckliste()))
            return false;
        return true;
    }

    public Bauteil (Stueckliste stueckListe, String name, int nr) {
        this.stueckliste = stueckListe;
        this.name = name;
        this.nr = nr;
    }

    public static Bauteil fromDTO(BauteilDTO dto)    
    {
        Bauteil b = new Bauteil();
        b.name = dto.getName();
        b.nr = dto.getNr();
        b.stueckliste = Stueckliste.fromDTO(dto.getStueckliste());
        return b;
    }

    public BauteilDTO toDTO()
    {
        BauteilDTO dto = new BauteilDTO(this.stueckliste.toDTO(), this.name, this.nr);
        return dto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stueckliste getStueckliste() {
        return stueckliste;
    }

    public void setStueckliste(Stueckliste stueckliste) {
        this.stueckliste = stueckliste;
    }
}
