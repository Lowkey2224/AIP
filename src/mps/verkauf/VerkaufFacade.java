package mps.verkauf;

import mps.materialwirtschaft.MaterialwirtschaftForVerkauf;
import mps.verkauf.dtos.AngebotDTO;
import mps.verkauf.dtos.AuftragDTO;
import mps.verkauf.entities.Angebot;

/**
 * Created with IntelliJ IDEA.
 * User: r3l4x
 * Date: 12.11.13
 * Time: 18:07
 * To change this template use File | Settings | File Templates.
 */
public class VerkaufFacade {

    private VerkaufBusinesslogic bl;
    private MaterialwirtschaftForVerkauf materialwirtschaftForVerkauf;

    public VerkaufFacade(MaterialwirtschaftForVerkauf materialwirtschaftForVerkauf) {
        this.bl = new VerkaufBusinesslogic();
        this.materialwirtschaftForVerkauf = materialwirtschaftForVerkauf;
    }

    public AuftragDTO createAuftrag( AngebotDTO angebotDTO )
    {
        Angebot angebot = Angebot.fromDTO(angebotDTO);
        return this.bl.createAuftrag( angebot );
    }

}