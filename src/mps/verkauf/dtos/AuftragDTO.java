package mps.verkauf.dtos;

import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:25
 * To change this template use File | Settings | File Templates.
 */
public class AuftragDTO {
	private int nr;
	private boolean istAbgeschlossen;
	private Date beauftragAm;
	private AngebotDTO angebot;

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(!(o instanceof AuftragDTO))
            return false;
        AuftragDTO a = (AuftragDTO)o;
        if(a.getNr() != nr || a.getIstAbgeschlossen() != istAbgeschlossen)
            return false;
        if(!a.getBeauftragAm().equals(beauftragAm))
            return false;
        if(!a.getAngebot().equals(angebot))
            return false;
        return true;
    }

    public int getNr() {
        return nr;
    }

    public boolean getIstAbgeschlossen() {
        return istAbgeschlossen;
    }

    public Date getBeauftragAm() {
        return beauftragAm;
    }

    public AngebotDTO getAngebot() {
        return angebot;
    }

    public AuftragDTO(int nr, boolean istAbgeschlossen, Date beauftragAm, AngebotDTO angebot)
	{
		this.nr = nr;
		this.istAbgeschlossen = istAbgeschlossen;
		this.beauftragAm = beauftragAm;
		this.angebot = angebot;
	}
}
