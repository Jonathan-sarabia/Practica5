/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import modelo.Auto;

/**
 *
 * @author jy
 */
public class AutoDao extends AdaptadorDao<Auto> {
    private Auto auto;

    public AutoDao() {
        super(Auto.class);
    }

    public Auto getAuto() {
        if(auto==null)
            auto = new Auto();
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    
    public boolean guardar(){
        return this.guardar(auto);
    }
}
