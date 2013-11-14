package mps.materialwirtschaft;

import mps.materialwirtschaft.dtos.StuecklisteDTO;

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
}
