package mps.materialwirtschaft.tests;

import mps.Persistence;
import mps.TransactionManager;
import mps.materialwirtschaft.MaterialwirtschaftFacade;
import mps.materialwirtschaft.entities.Bauteil;
import mps.materialwirtschaft.entities.Stueckliste;
import mps.materialwirtschaft.entities.StuecklistenPosition;
import mps.materialwirtschaft.repositories.BauteilRepository;
import mps.materialwirtschaft.repositories.StuecklisteRepository;
import mps.materialwirtschaft.repositories.StuecklistenPositionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created with uber 1337 H4x0r Skillz.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
public class MaterialwirtschaftTest {

    MaterialwirtschaftFacade mat;

    @Before
    public void setUp() throws Exception {
         mat = new MaterialwirtschaftFacade();
    }

    public Bauteil testSystemtestSetup()
    {
        int i = 10;
        // Regal besteht aus Brett & Winkel
        Bauteil
                t1 = new Bauteil( null, "Stuhlbeine (kurz)", i++),
                t2 = new Bauteil( null, "Stuhlbeine (lang)", i++),
                t3 = new Bauteil( null, "Stabilisatorstangen", i++),
                t4 = new Bauteil( null, "Leim, 2g", i++),
                t5 = new Bauteil( null, "Stahlwinkel", i++),
                t6 = new Bauteil( null, "Schrauben (4x2)", i++),
                t7 = new Bauteil( null, "Sitzflaeche (80x60x2)", i++),
                t8 = new Bauteil( null, "Lehne (90x60x2)", i++);

        Stueckliste l1 = new Stueckliste();
        l1.setGueltigAb( new Date() );
        l1.setGueltigBis( new Date() );

        StuecklistenPosition
                p1 = new StuecklistenPosition(t1, 2),
                p2 = new StuecklistenPosition(t2, 2),
                p3 = new StuecklistenPosition(t3, 2),
                p4 = new StuecklistenPosition(t4, 8),
                p5 = new StuecklistenPosition(t5, 4),
                p6 = new StuecklistenPosition(t6, 8),
                p7 = new StuecklistenPosition(t7, 1),
                p8 = new StuecklistenPosition(t8, 1);

        l1.add(p1);l1.add(p2); l1.add(p3);l1.add(p4);l1.add(p5);l1.add(p6);l1.add(p7); l1.add(p8);


        Bauteil produkt = new Bauteil( l1, "Stuhl", i++);

        TransactionManager tm = new TransactionManager( Persistence.getSessionFactory() );

        BauteilRepository               bauteilRepository = new BauteilRepository(Persistence.getSessionFactory() );
        StuecklisteRepository           stuecklisteRepository = new StuecklisteRepository(Persistence.getSessionFactory() );
        StuecklistenPositionRepository  stuecklistenPositionRepository = new StuecklistenPositionRepository(Persistence.getSessionFactory() );

        tm.beginTransaction();
        bauteilRepository.save((t1));
        bauteilRepository.save((t2));
        bauteilRepository.save((t3));
        bauteilRepository.save((t4));
        bauteilRepository.save((t5));
        bauteilRepository.save((t6));
        bauteilRepository.save((t7));
        bauteilRepository.save((t8));

        stuecklisteRepository.save((l1));
        bauteilRepository.save( (produkt) );
        stuecklistenPositionRepository.save((p1));
        stuecklistenPositionRepository.save((p2));
        stuecklistenPositionRepository.save((p3));
        stuecklistenPositionRepository.save((p4));
        stuecklistenPositionRepository.save((p5));
        stuecklistenPositionRepository.save((p6));
        stuecklistenPositionRepository.save((p7));
        stuecklistenPositionRepository.save((p8));
        tm.commit();

        return produkt;

    }

    @Test
    public void testSystemtest()
    {

        MaterialwirtschaftFacade materialwirtschaftFacade = new MaterialwirtschaftFacade();
        Bauteil bau = testSystemtestSetup();
        assert(materialwirtschaftFacade.isComplex(bau.getNr()));
        //materialwirtschaftFacade.getStueckliste(bau.toDTO());

    }

}
