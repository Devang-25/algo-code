package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mns on 6/26/18.
 */
public class DuplicateFiles {
    public List<List<String>> findDuplicate(String [] paths){
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String> > result = new ArrayList<>();
        for(String path : paths){
            String [] splits = path.split(" ");

            for(int i=1;i<splits.length;i++){
                String file = splits[i].split("\\(")[0];
                String content = splits[i].split("\\(")[1];
                content = content.substring(0,content.length()-1);
                List<String> group = map.get(content);
                if(group == null){
                    group = new ArrayList<>();
                    map.put(content,group);
                }
                group.add(splits[0]+"/"+file);
                if(group.size() == 2){
                    result.add(group);
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        DuplicateFiles df = new DuplicateFiles();
        List<List<String>> result = df.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
        for(List<String> list : result){
            for(String s : list){
                System.out.print(s+ " ");
            }
            System.out.println();
        }
    }

}
