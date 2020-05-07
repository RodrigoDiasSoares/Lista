package com.example.lista;

import java.io.Serializable;
import java.util.ArrayList;

public class Crud implements Serializable {
    private ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;

    }

    public void novoItem(String item){
        list.add(item);
    }
    public  void editarItem(){

    }
    public void deletarItem(){

    }
}
