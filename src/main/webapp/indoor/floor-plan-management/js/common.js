/*
 * create:duhw
 * ���õ�js����
 */


/*
 * @author:duhw
 * ��,����,ʡ,��,������(��������)(��������)(��������)(��������)(��������)
 * selectNode:��һ��select��ǩ��class����
 * data:POST������(val��flag��������)
 * classArray:��Ҫ��ն����class����
 */
function ajaxLink(selectNode,data,classArray){
	$.ajax({
		type:'POST',
		url:'ea.php?r=GetProvCityDist/AjaxRequest',
		data:data,
		dataType:'json', 
		success:function(json){
		    if(json.e_longitude) e_longitude = json.e_longitude/3600/1000;
		    if(json.w_longitude) w_longitude = json.w_longitude/3600/1000;
		    if(json.n_latitude)  n_latitude  = json.n_latitude/3600/1000;
		    if(json.s_latitude)  s_latitude  = json.s_latitude/3600/1000;
		    if(json.longitude)   longitude   = json.longitude/3600/1000;
		    if(json.latitude)    latitude    = json.latitude/3600/1000;
			if(json.html && $("."+selectNode)){
				$("."+selectNode).empty();
				$("."+selectNode).append(json.html);
			}
			if(typeof classArray != 'string' && classArray.length>0){
				for(var i=0;i<classArray.length;i++){
					$("."+classArray[i]).empty().append("<option value=''>-��ѡ��-</option>");//����Ҫɾ����Ԫ����Ϊ��
				}
			}
		}
	});
}
/*
* @author:duhw
* ����,ʡ,��,������(Ŀ�ĵ�)(Ŀ�ĵ�)(Ŀ�ĵ�)(Ŀ�ĵ�)(Ŀ�ĵ�)(Ŀ�ĵ�)
* selectNode:��һ��select��ǩ��class����
* data:POST������(val��flag��������)
* classArray:��Ҫ��ն����class����
*/
function ajaxDestLink(selectNode,data,classArray){
	$.ajax({
		type:'POST',
		url:'ea.php?r=GetProvCityDist/AjaxDestRequest',
		data:data,
		dataType:'json', 
		success:function(json){
			if(json.html && $("."+selectNode)){
				$("."+selectNode).empty();
				$("."+selectNode).append(json.html);
			}
			if(typeof classArray != 'string' && classArray.length>0){
				for(var i=0;i<classArray.length;i++){
					$("."+classArray[i]).empty().append("<option value=''>-��ѡ��-</option>");//����Ҫɾ����Ԫ����Ϊ��
				}
			}
		}
	});
}
//����country_id,prov_id,city_id,dist_id��ȡ����
function ajaxGetAreaList(area_id,continent_id,country_id,prov_id, city_id, dist_id, img_id)
{
	if(typeof(img_id)!="undefined"&&img_id!=null) $("#"+img_id).fadeIn("slow");
	$.ajax({
		type : "get",
		url : "ea.php?r=GetProvCityDist/ajaxAreaList",
		dataType : "text",
		data : {
			continent : $("#"+continent_id).val(),
			country : $("#"+country_id).val(),
			prov : $("#"+prov_id).val(),
			city : $("#"+city_id).val(),
			district : $("#"+dist_id).val()
		},
		success : function(msg){
			$("#"+area_id).empty();
			$("#"+area_id).append(msg);
		},
		error : function(data){
			alert(data);
			return false;
		},
		complete : function(){
			$("#"+img_id).fadeOut("slow");
		}
	});
	return true;
}

//ajaxģ����ѯ���������ݾ�������
function ajaxGetAreas(area_name,area_id,img_id)
{
	if(!area_name)
		return false;
	if(typeof(img_id)!="undefined"&&img_id!=null) $("#"+img_id).fadeIn("slow");
	$.ajax({
		type : "get",
		url : "ea.php?r=GetProvCityDist/AjaxGetAreas",
		dataType : "text",
		data : {
			name : $("#"+area_name).val()
		},
		success : function(msg){
			$("#"+area_id).empty();
			$("#"+area_id).append(msg);
		},
		error : function(data){
			alert(data);
			return false;
		},
		complete : function(){
			$("#"+img_id).fadeOut("slow");
		}
	});
	return true;
}
//��ȡGE���ͼģʽ���ż���
function getMap2Zoom(rangevalue){
	var map2Zoom = 10;
    var range = parseInt(rangevalue);
	if(range >= 800000)
		map2Zoom = 7;
	else if(range >= 400000 && range <800000)
		map2Zoom = 8;
	else if(range >= 200000 && range <400000)
		map2Zoom = 9;
	else if(range >= 100000 && range <200000)
		map2Zoom = 10;
	else if(range >= 50000 && range <100000)
		map2Zoom = 11;
	else if(range >= 25000 && range <50000)
		map2Zoom = 12;
	else if(range >= 10000 && range <25000)
		map2Zoom = 13;
	else if(range >= 5000 && range <10000)
		map2Zoom = 14;
	else if(range >= 2500 && range <5000)
		map2Zoom = 15;
	else if(range >= 1250 && range <2500)
		map2Zoom = 16;
	else if(range >= 500 && range <1250)
		map2Zoom = 17;
	else
		map2Zoom = 18;
	
	return map2Zoom;
	
}