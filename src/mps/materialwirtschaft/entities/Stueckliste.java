package mps.materialwirtschaft.entities;

import mps.materialwirtschaft.dtos.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 * Created with 1337 H4x0r skillz
 * User: Loki
 * Date: 12.11.13
 * Time: 18:25 
 */
@Entity
@Table(name = "stueckliste")
public class Stueckliste {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
	private Date gueltigAb;
	@Column(nullable = false)
	private Date gueltigBis;
	@OneToMany(mappedBy = "stueckliste", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<StuecklistenPosition> positionen;
	@OneToOne(mappedBy = "stueckliste")
	private Bauteil bauteil;

    public Stueckliste() {
        positionen = new ArrayList<StuecklistenPosition>();
    }

    public static Stueckliste fromDTO(StuecklisteDTO liste)
    {
        if (liste == null)
        {
            return null;
        }
    	Stueckliste st = new Stueckliste();
    	st.gueltigBis = liste.getGueltigBis();
    	st.gueltigAb = liste.getGueltigAb();
    	for(StuecklistenPositionDTO elem : liste.getStueckliste())
    	{
    		st.positionen.add(StuecklistenPosition.fromDTO(elem));
    	}
        return st;
    }

    public StuecklisteDTO toDTO()
    {
    	StuecklisteDTO dto = new StuecklisteDTO();
    	dto.setGueltigAb(this.gueltigAb);
    	dto.setGueltigBis(this.gueltigBis);
    	dto.setId(this.id);
    	for(StuecklistenPosition elem : positionen)
        {
            dto.add(elem.toDTO());
        }
    	dto.setBauteil(bauteil.toDTO());
        return dto;
    }

    public int add(StuecklistenPosition elem)
	{
		positionen.add(elem);
		return positionen.size();
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public List<StuecklistenPosition> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<StuecklistenPosition> positionen) {
        this.positionen = positionen;
    }

    public Bauteil getBauteil() {
        return bauteil;
    }

    public void setBauteil(Bauteil bauteil) {
        this.bauteil = bauteil;
    }
}
