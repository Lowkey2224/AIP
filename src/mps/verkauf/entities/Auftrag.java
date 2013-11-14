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
}
