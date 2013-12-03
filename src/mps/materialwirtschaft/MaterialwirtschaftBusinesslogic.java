package mps.materialwirtschaft;

import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.entities.*;
import mps.materialwirtschaft.repositories.BauteilRepository;
import org.hibernate.SessionFactory;

/**
 * Created with 1337 H4x0r skillz
 * User: Loki
 * Date: 12.11.13
 * Time: 18:25 
 */
class MaterialwirtschaftBusinesslogic{

    private SessionFactory sf;

    public MaterialwirtschaftBusinesslogic(SessionFactory sf)
    {
        this.sf = sf;
    }

	public boolean isComplex(Bauteil bauteil)
	{
		return (bauteil.getStueckliste() != null);
	}

	public StuecklisteDTO getStueckliste(Bauteil bauteil)
	{
		return bauteil.getStueckliste().toDTO();
	}

    public Bauteil createBauteil(Stueckliste stueckliste, String name) {
        return new Bauteil(stueckliste,name,this.doSomeMagicForBauteilNummer());
    }

    private int doSomeMagicForBauteilNummer() {
        return new BauteilRepository(sf).getMaxNr()+1;
    }
}
