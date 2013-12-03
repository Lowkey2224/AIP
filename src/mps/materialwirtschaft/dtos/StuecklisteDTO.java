package mps.materialwirtschaft.dtos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with 1337 H4x0r skillz
 * User: Loki
 * Date: 12.11.13
 * Time: 18:25 
 */
public class StuecklisteDTO {

    private int id;
    private Date gueltigAb;
    private Date gueltigBis;
    private List<StuecklistenPositionDTO> stueckliste;
    private BauteilDTO bauteilDTO;

    public StuecklisteDTO() {
        stueckliste = new ArrayList<StuecklistenPositionDTO>();
        this.gueltigAb = new Date();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof StuecklisteDTO))
            return false;
        StuecklisteDTO stl = (StuecklisteDTO)o;
        if(!stl.getBauteil().equals(this.getBauteil()))
            return false;
        if(!stl.getGueltigAb().equals(this.getGueltigAb()))
            return false;
        if(!stl.getGueltigBis().equals(this.getGueltigBis()))
            return false;
        if(stl.getId()!=this.getId())
            return false;
        if(stl.getStueckliste().size() != this.getStueckliste().size())
            return false;
        if (!stl.getStueckliste().equals(this.getStueckliste()))
            return false;
        return true;
    }

    public int add(StuecklistenPositionDTO elem)
	{
		stueckliste.add(elem);
		return stueckliste.size();
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGueltigAb() {
        return gueltigAb;
    }

    public void setGueltigAb(Date gueltigAb) {
        this.gueltigAb = gueltigAb;
    }

    public Date getGueltigBis() {
        return gueltigBis;
    }

    public void setGueltigBis(Date gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public List<StuecklistenPositionDTO> getStueckliste() {
        return stueckliste;
    }

    public void setStueckliste(List<StuecklistenPositionDTO> stueckliste) {
        this.stueckliste = stueckliste;
    }

    public BauteilDTO getBauteil() {
        return bauteilDTO;
    }

    public void setBauteil(BauteilDTO bauteilDTO) {
        this.bauteilDTO = bauteilDTO;
    }
}
