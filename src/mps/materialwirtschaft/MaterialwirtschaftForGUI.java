package mps.materialwirtschaft;

import mps.materialwirtschaft.dtos.BauteilDTO;
import mps.materialwirtschaft.entities.Stueckliste;

/**
 * User: Loki
 * Date: 03.12.13
 * Time: 11:59
 */
public interface MaterialwirtschaftForGUI {

    public BauteilDTO createBauteil(Stueckliste stueckliste, String name);
}
