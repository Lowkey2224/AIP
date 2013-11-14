package mps.materialwirtschaft.entities;

import mps.materialwirtschaft.dtos.StuecklistenPositionDTO;

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
@Table(name = "stuecklisten_position")
public class StuecklistenPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    private int menge;
    @ManyToOne()
    private Bauteil bauteil;
    @ManyToOne()
    private Stueckliste stueckliste;

    public StuecklistenPosition(Bauteil bauteil, int menge)
    {
        this.bauteil = bauteil;
        this.menge = menge;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Bauteil getBauteil() {
        return bauteil;
    }

    public void setBauteil(Bauteil bauteil) {
        this.bauteil = bauteil;
    }

    public StuecklistenPosition() {

    }

    public static StuecklistenPosition fromDTO(StuecklistenPositionDTO pos)
    {
        StuecklistenPosition st = new StuecklistenPosition();
    	st.menge = pos.getMenge();
    	st.bauteil = Bauteil.fromDTO(pos.getBauteil());
        st.id = pos.getId();
    	return st;
    }

    public StuecklistenPositionDTO toDTO()
    {
        StuecklistenPositionDTO dto = new StuecklistenPositionDTO(bauteil.toDTO(), menge);
    	dto.setId(this.id);
        return dto;
    }


}
