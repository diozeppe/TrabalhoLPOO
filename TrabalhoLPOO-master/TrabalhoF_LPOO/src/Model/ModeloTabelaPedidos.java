package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafael
 */
public class ModeloTabelaPedidos extends AbstractTableModel{
    private String[] colunas=new String[]{"Forma","Material","Tamanho","Preco"};

    private List<Pedido> lista=new ArrayList();

    
    public ModeloTabelaPedidos(List<Pedido> lista){
        this.lista=lista;
    }

    public ModeloTabelaPedidos(){
    }


    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return pedido.getForma();
            case 1: return pedido.getMaterial();//if column 1 (name)
            case 2: return pedido.getTamanho();
            case 3: return pedido.getCusto();//if column 2 (birthday)
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
            Pedido pedido = lista.get(row);
            switch (col) {
                case 0:
                    pedido.setForma((String) value); //if column 0 (code)
                    break;
                case 1:
                    pedido.setMaterial((String) value);
                    break;
                case 2:
                    pedido.setTamanho((double) value);
                    break;
                case 3:
                    pedido.setCusto((double) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
    }

    public boolean removePedido(Pedido pedido) {
        int linha = this.lista.indexOf(pedido);
        boolean result = this.lista.remove(pedido);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaPedidos(List<Pedido> pedidos) {
        this.lista = pedidos;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Pedido getPedido(int linha){
        return lista.get(linha);
    }
    
}