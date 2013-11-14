package mps.materialwirtschaft;

import mps.materialwirtschaft.dtos.StuecklisteDTO;
import mps.materialwirtschaft.entities.*;
/**
 * Created with 1337 H4x0r skillz
 * User: Loki
 * Date: 12.11.13
 * Time: 18:25 
 */
class MaterialwirtschaftBusinesslogic{

	public boolean isComplex(Bauteil bauteil)
	{
		return (bauteil.getStueckliste() != null);
	}

	public StuecklisteDTO getStueckliste(Bauteil bauteil)
	{
		return bauteil.getStueckliste().toDTO();
	}
}
