package mps.materialwirtschaft;

import mps.Persistence;
import mps.TransactionManager;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.repositories.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class MaterialwirtschaftFacade implements MaterialwirtschaftForVerkauf{
	private MaterialwirtschaftBusinesslogic bl;
    private TransactionManager tm;
    private BauteilRepository bauteilRepo;

	public MaterialwirtschaftFacade()
	{
        tm = new TransactionManager( Persistence.getSessionFactory() );
		bl = new MaterialwirtschaftBusinesslogic();
        bauteilRepo = new BauteilRepository(Persistence.getSessionFactory());
	}

    public boolean isComplex(int bauteilNr) {
        tm.beginTransaction();
        Bauteil bauteil = bauteilRepo.findOneByNr(bauteilNr);
        tm.commit();

        return bl.isComplex(bauteil);
    }

    public StuecklisteDTO getStueckliste(int bauteilNr)
    {
        tm.beginTransaction();
        Bauteil bauteil = bauteilRepo.findOneByNr(bauteilNr);
        tm.commit();

        return bl.getStueckliste(bauteil);
    }

    @Override
    public List<BauteilDTO> getAllBauteile() {
        tm.beginTransaction();
        List<Bauteil> list = bauteilRepo.findAll();
        tm.commit();
        List<BauteilDTO> returnValue = new ArrayList<BauteilDTO>(list.size());
        for(Bauteil bauteil : list)
        {
            returnValue.add(bauteil.toDTO());
        }
        return returnValue;
    }
}
