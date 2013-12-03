package mps.verkauf.entities;

import java.util.Date;
import mps.verkauf.dtos.*;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "auftrag")
public class Auftrag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(nullable = false,  unique = true)
    private int nr;

    @Column(nullable = false)
	private boolean istAbgeschlossen;

    @Column(nullable = false)
	private Date beauftragAm;

    //TODO: Not Nullable
    @OneToOne
	private Angebot angebot;


    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(!(o instanceof Auftrag))
            return false;
        Auftrag a = (Auftrag)o;
        if(a.getNr() != nr || a.isIstAbgeschlossen() != istAbgeschlossen)
            return false;
        if(!a.getBeauftragAm().equals(beauftragAm))
            return false;
        if(!a.getAngebot().equals(angebot))
            return false;
        return true;
    }
	
	public static Auftrag fromDTO(AuftragDTO auftrag)
	{
		Auftrag auf = new Auftrag();
		auf.nr = auftrag.getNr();
		auf.istAbgeschlossen = auftrag.getIstAbgeschlossen();
		auf.beauftragAm = auftrag.getBeauftragAm();
		auf.setAngebot(Angebot.fromDTO(auftrag.getAngebot()));
        return auf;
	}

	public Auftrag()
	{
		//TODO Nummer generieren!
		this.nr = 1;
		//TODO jetzt
		beauftragAm = new Date();
		this.angebot = null;
	}
	
	public void setAngebot(Angebot angebot)
	{
		this.angebot = angebot;
	}

	public AuftragDTO toDTO()
	{
		return new AuftragDTO(nr, istAbgeschlossen, beauftragAm, angebot.toDTO());
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

    public boolean isIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    public void setIstAbgeschlossen(boolean istAbgeschlossen) {
        this.istAbgeschlossen = istAbgeschlossen;
    }

    public Date getBeauftragAm() {
        return beauftragAm;
    }

    public void setBeauftragAm(Date beauftragAm) {
        this.beauftragAm = beauftragAm;
    }

    public Angebot getAngebot() {
        return angebot;
    }
}
