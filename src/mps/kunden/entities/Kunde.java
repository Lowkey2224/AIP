package mps.kunden.entities;

import mps.kunden.dtos.KundeDTOImpl;

import javax.persistence.*;
import java.rmi.RemoteException;

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
    @Column(name = "nr", unique = true, nullable = false)
    public int nr;

    @Column(nullable = false)
    public String name;

    @Column(nullable =  false)
    public String address;

    public KundeDTOImpl toDTO()
    {
        try {
            return new KundeDTOImpl(name, address,nr);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return  null;
        }
    }

    public static Kunde fromDTO(KundeDTOImpl dto)
    {
        Kunde k = new Kunde();
        try {
            k.name = dto.getName();
            k.nr = dto.getNr();
            k.address = dto.getAddress();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
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
