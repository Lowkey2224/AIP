package mps.materialwirtschaft;

import mps.Persistence;
import mps.TransactionManager;
import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.repositories.*;


/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class MaterialwirtschaftFacade implements MaterialwirtschaftForVerkauf{
	private MaterialwirtschaftBusinesslogic bl;

	public MaterialwirtschaftFacade()
	{
		bl = new MaterialwirtschaftBusinesslogic();
	}

    public boolean isComplex(int bauteilNr) {
    	TransactionManager transactionManager = new TransactionManager( Persistence.getSessionFactory() );
		BauteilRepository bauteilRepo = new BauteilRepository(Persistence.getSessionFactory());

		//transactionManager.beginTransaction();
        TransactionManager tm = new TransactionManager( Persistence.getSessionFactory() );
        tm.beginTransaction();

		Bauteil bauteil = bauteilRepo.findOneByNr(bauteilNr);

        tm.commit();

        return bl.isComplex(bauteil);  
    }

    public StuecklisteDTO getStueckliste(int bauteilNr)
    {
    	TransactionManager transactionManager = new TransactionManager( Persistence.getSessionFactory() );
		BauteilRepository bauteilRepo = new BauteilRepository(Persistence.getSessionFactory());

		//transactionManager.beginTransaction();

		Bauteil bauteil = bauteilRepo.findOneByNr(bauteilNr);
        return bl.getStueckliste(bauteil);
    }
}
