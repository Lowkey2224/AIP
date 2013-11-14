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
