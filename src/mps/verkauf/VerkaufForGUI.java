package mps.verkauf;

import mps.kunden.dtos.KundeDTO;
import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.verkauf.dtos.AngebotDTO;
import mps.verkauf.dtos.AuftragDTO;

import java.util.List;

/**
 * User: Loki
 * Date: 03.12.13
 * Time: 15:18
 */
public interface VerkaufForGUI {

    public List<KundeDTO> findKundenByName(String name);
    public KundeDTO findOneKundeByNr(int nr);
    public AngebotDTO createAngebot(KundeDTO kundeDTO);
    public AngebotDTO addBauteil(AngebotDTO angebotDTO, BauteilDTO bauteilDTO);
    public List<BauteilDTO> showBauteile();
    public AuftragDTO createAuftrag( AngebotDTO angebotDTO );

}
