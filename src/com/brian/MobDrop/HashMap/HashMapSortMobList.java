package com.brian.MobDrop.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brian.MobDrop.Database.MobItemList;

public class HashMapSortMobList {
	// �Q�̷өm�W�Φ��Z�P�C�L�X�Ҧ���ơA���N�Ҧ�HashMap�̪�entry��JList
	public List<Map.Entry<String, List<MobItemList>>> list_Data;
	
    public HashMapSortMobList(HashMap<String, List<MobItemList>> inputdata) {

        // �Q�̷өm�W�Φ��Z�P�C�L�X�Ҧ���ơA���N�Ҧ�HashMap�̪�entry��JList
    	list_Data = new ArrayList<Map.Entry<String, List<MobItemList>>>(inputdata.entrySet());

        // �̩m�W�ƧǨæC�L
        Collections.sort(list_Data, new Comparator<Map.Entry<String, List<MobItemList>>>(){
            public int compare(Map.Entry<String, List<MobItemList>> entry1, Map.Entry<String, List<MobItemList>> entry2){
                return (entry1.getKey().compareTo(entry2.getKey()));
            }
        });
    }
}