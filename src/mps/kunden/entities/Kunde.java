package mps.kunden.entities;

import mps.kunden.dtos.KundeDTO;

import javax.persistence.*;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:52
 */
@Entity
@Table(name = "kunde")
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ne", unique = true, nullable = false)
    public int nr;

    @Column(nullable = false)
    public String name;

    @Column(nullable =  false)
    public String address;

    @Override
    public boolean equals(Object o )
    {
        if(o == null)
            return false;
        if(!(o instanceof Kunde))
            return false;
        Kunde other = (Kunde)o;
        if (!other.getAddress().equals(this.getAddress()))
            return false;
        if(!other.getName().equals(this.getName()))
            return false;
        if(other.getNr()!= this.getNr())
            return false;
        return true;
    }

    public KundeDTO toDTO()
    {
        return new KundeDTO(name, address,nr);
    }

    public static Kunde fromDTO(KundeDTO dto)
    {
        Kunde k = new Kunde();
        k.name = dto.getName();
        k.nr = dto.getNr();
        k.address = dto.getAddress();
        return  k;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
