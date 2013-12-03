package mps.materialwirtschaft.dtos;

/**
 * Created with 1337 H4x0r skillz
 * User: Loki
 * Date: 12.11.13
 * Time: 18:25 
 */
public class StuecklistenPositionDTO {

	private BauteilDTO bauteil;
	private int menge;
    private int id;
	
	public StuecklistenPositionDTO(BauteilDTO bauteil, int menge)
	{
		this.bauteil = bauteil;
		this.menge = menge;
	}

    @Override
    public boolean equals(Object o)
    {
        if(o ==  null)
            return false;
        if(this == o)
            return true;
        if(!(o instanceof StuecklistenPositionDTO))
            return false;
        StuecklistenPositionDTO p = (StuecklistenPositionDTO)o;
        if(!p.getBauteil().equals(this.getBauteil()))
            return false;
        if(p.getId() != this.getId())
            return false;
        if(p.getMenge() != this.getMenge())
            return false;
        return true;
    }

    public BauteilDTO getBauteil() {
        return bauteil;
    }

    public void setBauteil(BauteilDTO bauteil) {
        this.bauteil = bauteil;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
