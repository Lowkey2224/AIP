package mps.materialwirtschaft;

import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.materialwirtschaft.dtos.StuecklisteDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Loki
 * Date: 14.11.13
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public interface MaterialwirtschaftForVerkauf {

    public boolean isComplex(int bauteilNr);
    public StuecklisteDTO getStueckliste(int bauteilNr);
    public List<BauteilDTO> getAllBauteile();
}
