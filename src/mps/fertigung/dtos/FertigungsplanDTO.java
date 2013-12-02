package mps.fertigung.dtos;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 13.11.13
 * Time: 08:52
 * To change this template use File | Settings | File Templates.
 */
public class FertigungsplanDTO {

    private int nr;
    private int id;
    public FertigungsplanDTO(int produktId, int nr, int auftragNr) {
        this.produktId = produktId;
        this.nr = nr;
        this.auftragNr = auftragNr;
    }

    private int auftragNr;
    private int produktId;

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

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int produktId) {
        this.produktId = produktId;
    }



}
