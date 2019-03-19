package com.brian.MobDrop.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brian.MobDrop.Database.Items;

public class HashMapSortItemList {
	// �Q�̷өm�W�Φ��Z�P�C�L�X�Ҧ���ơA���N�Ҧ�HashMap�̪�entry��JList
	public List<Map.Entry<String, Items>> list_Data;
	
    public HashMapSortItemList(HashMap<String, Items> inputdata) {

        // �Q�̷өm�W�Φ��Z�P�C�L�X�Ҧ���ơA���N�Ҧ�HashMap�̪�entry��JList
    	list_Data = new ArrayList<Map.Entry<String, Items>>(inputdata.entrySet());

        // �̩m�W�ƧǨæC�L
        Collections.sort(list_Data, new Comparator<Map.Entry<String, Items>>(){
            public int compare(Map.Entry<String, Items> entry1, Map.Entry<String, Items> entry2){
                return (entry1.getKey().compareTo(entry2.getKey()));
            }
        });
        
        /*for (Map.Entry<String, Items> entry:list_Data) {
            System.out.print(entry.getKey() + "\t" + inputdata.get(entry.getKey()));
        }*/
    }
}