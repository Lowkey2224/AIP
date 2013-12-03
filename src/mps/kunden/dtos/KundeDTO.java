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
