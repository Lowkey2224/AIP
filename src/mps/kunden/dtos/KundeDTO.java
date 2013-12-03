package mps.kunden.dtos;

/**
 * User: Loki
 * Date: 02.12.13
 * Time: 17:53
 */
public class KundeDTO {
    private String name;
    private String address;
    private int nr;

    public KundeDTO(String name, String address, int nr)
    {
        this.name = name;
        this.address = address;
        this.nr = nr;
    }

    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(!(other instanceof KundeDTO))
            return false;
        KundeDTO o = (KundeDTO)other;
        if (o.getNr() != this.getNr())
            return false;
        if (!o.getName().equals(this.getName()))
            return false;
        if(!o.getAddress().equals(this.getAddress()))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNr() {
        return nr;
    }
}
