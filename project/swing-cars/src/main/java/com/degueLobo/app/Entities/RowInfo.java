/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.degueLobo.app.Entities;

import com.degueLobo.app.Entities.DAOInterface;
import com.degueLobo.app.Entities.DTO;

/**
 *
 * @author mjdegue
 */
public abstract class RowInfo<MODEL_DTO extends DTO>  {
    protected String[] columnNames;
    protected MODEL_DTO model;
    protected RowInfo(MODEL_DTO model, String[] columnNames){
        this.model = model;
        this.columnNames = columnNames;
    }
    
    public abstract Object[] getRowInfo();
    public abstract int getRowInfoSize();
    
    public String[] getColumnNames()
    {
        return columnNames;
    }
}
