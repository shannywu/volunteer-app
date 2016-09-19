package com.example.termproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.ExpandableListView.OnGroupClickListener;

public class KnowFrag extends Fragment{

	private int sign= -1;
	private String child1, child2, child3, child4;
	List<Map<String, String>> gruops;
	List<List<Map<String, String>>> childs;
	SimpleExpandableListAdapter adapter;
	private  ExpandableListView  expandableListView_one;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_know, container,
				false);
		 ini();
         
         expandableListView_one =(ExpandableListView)view.findViewById(R.id.mExpandableListView);
	     expandableListView_one.setAdapter(adapter); 
	     expandableListView_one.setOnGroupClickListener(new OnGroupClickListener()
	     {
	    	 public boolean onGroupClick(ExpandableListView parent, View v,  
	             int groupPosition, long id) {  
	             // TODO Auto-generated method stub  
	             if (sign== -1) { 
	            	 //沒開
	            	 expandableListView_one.expandGroup(groupPosition); 
	            	 expandableListView_one.setSelectedGroup(groupPosition);  
	                 sign= groupPosition;  
	             } else if (sign== groupPosition) {  
	            	 //收起來
	            	 expandableListView_one.collapseGroup(sign);  
	                 sign= -1;  
	             } else {  
	            	 expandableListView_one.collapseGroup(sign); 	//收
	            	 expandableListView_one.expandGroup(groupPosition);	//開  
	            	 expandableListView_one.setSelectedGroup(groupPosition);	//至頂  
	                 sign= groupPosition;  
	             }  
	             return true;  
		     }
	     });
		return view;
	}
	private void ini()
	{
		child1 = "所謂「脊髓損傷」是指急性外傷性傷害侵及脊髓與神經，造成運動、感覺及大小便功能失常。這通常是由於巨大的外力，如車禍、墜落、重物壓傷、運動傷害等，使脊柱移位或骨折造成，而有些老年人發生損傷的原因是閃跌、滑交等小傷害。一般脊髓損傷都可發現其脊柱嚴重的破壞，但也有些損傷患者的影像檢查看不到脊柱明顯的變化，當然也有些人雖然傷及脊柱，但並未造成脊髓損傷。有些癱瘓的病人，並不是外傷性傷害造成，而是由於腫瘤、脊血管、發炎等因素，這些脊髓疾病的表現常與外傷性脊髓損傷相似。頸髓受傷會造成四肢癱瘓，約佔所有脊髓損傷患者的半數；若傷及胸髓、腰髓或薦髓，則會造成下半身癱瘓。除了運動與感覺機能障礙外，脊髓損傷還會造成排尿、排便困難及性功能障礙，而呼吸問題、自主神經機能異常也常見。不止如此，心理挫折、經濟問題等也跟著浮現。";
	    child2 = "脊髓損傷發生原因以車禍最為常見約佔50%，其次為由高處跌落或老人家跌倒，其他依次為運動傷害（跳水為主）、激烈鬥毆、槍傷等。以發生部位來看，頸髓是最好發的部位國外統計約佔50─60%。低胸椎及腰椎交界處是第二好發部位。其次是胸椎部位。\n\r\n\r車禍是脊髓損傷最主要的原因，其中又以摩托車騎士面臨較大的危險。汽車車禍會傷及脊髓有兩種主要機制，一種是受到劇烈碰撞或緊急剎車時引起的頸部急遽前屈和後仰造成的頸髓損傷。另一種受傷機制是身體碰撞車身或地面造成的胸腰椎交界處的損傷。\n\r\n\r跌倒所引起的脊髓損傷可分兩類，一類是從高處跌下引起的，多半是在高處工作摔下造成，部份是跳樓自殺不成留下的遺憾。另一類發生在中老年人，可能只是不小心在室內滑倒、摔倒或是騎腳踏車跌倒，就造成嚴重的四肢麻痺。\n\r\n\r運動傷害方面，歐美國家有多種劇烈運動而造成的脊髓損傷，如滑雪、足球、橄欖球等。在台灣則以跳水為最常見的脊髓損傷原因，多半是因為頭部撞到池底或其他東西而造成頸髓損傷。\n\r\n\r當意外發生時，針對保護脊椎而言要注意下面兩點：第一，切忌將傷者從重物下或發生意外地點拖拉出來，應該將壓迫物移除，再將傷者以具有良好固定功能的擔架抬離現場。第二是在搬運傷者過程中要保持脊椎的正中姿勢，避免脊椎有扭曲的可能性。運送的過程中最好有夾板及固定繩帶將傷者頭頸部及軀幹穩穩固定在脊椎正中垂直仰臥的姿勢，可以使脊髓的傷害不再加重。";
	    child3 = "脊髓損傷者大多中途致殘，一夕之間失去正常人的基本能力，嚴重者甚至無法自行進食、如厠、沐浴及翻身，因此大多數脊髓損傷者意志消沈、封閉自我造成人際關係疏離；又由於受傷後無法恢復原有的工作能力，從生產者變為依賴者，且終生需要醫療照顧，對家庭造成極大的負擔。此外，嚴重的後遺病變如大小便失禁、神經根痛、體溫調節功能失常、褥瘡及性功能障礙將一輩子困擾著患者。\n\r\n\r年增加率: 1200人		平均受傷年齡: 27.3歲\n\r女性損傷者: 14.4%		男性損傷者: 85.6%\n\r終身使用輪椅: 92%		耗用社會成本: 2,500萬";
	    child4 = "搶救四字訣：測、套、固、送\n\r\n\r測：測試患者的傷害狀況，以判斷其脊髓受損的情形。\n\r\n\r套：套上頸圈以固定頸部，避免傷者的頸部受到二度傷害。\n\r\n\r固：將傷者的頭、頸和身體呈一直線，固定在搬運板或擔架上。\n\r\n\r送：馬上將傷者送到附近的區域教學醫院或醫學中心進行急救。";
		
		Map<String, String> title_1 = new HashMap<String, String>();   
        Map<String, String> title_2 = new HashMap<String, String>();   
        Map<String, String> title_3 = new HashMap<String, String>();   
        Map<String, String> title_4 = new HashMap<String, String>();   
        
        title_1.put("group", "什麼是脊隨損傷?");
        title_2.put("group", "造成脊隨損傷的原因");   
        title_3.put("group", "台灣脊隨傷者的概況");   
        title_4.put("group", "脊隨損傷的急救處理");   
       
        gruops = new ArrayList<Map<String,String>>();   
        
        gruops.add(title_1);   
        gruops.add(title_2);   
        gruops.add(title_3);   
        gruops.add(title_4);
        
        //内容一    
        Map<String, String> content_1 = new HashMap<String, String>(); 
        content_1.put("child", child1);   
        List<Map<String, String>> childs_1 = new ArrayList<Map<String,String>>();   
        childs_1.add(content_1);   
       
            
        //内容二    
        Map<String, String> content_2 = new HashMap<String, String>();   
        content_2.put("child", child2);   
        List<Map<String, String>> childs_2 = new ArrayList<Map<String,String>>();   
        childs_2.add(content_2);  
        
        //内容三 
        Map<String, String> content_3 = new HashMap<String, String>();   
        content_3.put("child", child3);   
        List<Map<String, String>> childs_3 = new ArrayList<Map<String,String>>();   
        childs_3.add(content_3);  
        
        //内容四    
        Map<String, String> content_4 = new HashMap<String, String>();   
        content_4.put("child", child4);   
        List<Map<String, String>> childs_4 = new ArrayList<Map<String,String>>();   
        childs_4.add(content_4);  
          
        childs = new ArrayList<List<Map<String,String>>>();   
        childs.add(childs_1);   
        childs.add(childs_2);   
        childs.add(childs_3);   
        childs.add(childs_4); 
        
        adapter = new SimpleExpandableListAdapter( getActivity(), gruops,
        		R.layout.group, new String[]{"group"}, new int[]{R.id.group_tv}, childs, 
        		R.layout.child, new String[]{"child"}, new int[]{R.id.child_tv} ); 
	}
}




