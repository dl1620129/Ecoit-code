package com.web.article.listnews.portlet;

import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.portlet.RenderRequest;

public class TreeCategory {
	private StringBuffer result ;
	private int depth = 0;
	private long[] parentCurrent;
	private List<Long>pathParent=null;
	private long selectedNode=0;
public TreeCategory()
	{
		result = new StringBuffer();
	}

private boolean checkNode(long node) {
	for (int i = 0; i < parentCurrent.length; i++) {
		if (node == parentCurrent[i]) return true;
	}

	return false;
}

private void recursiveCategoryTree( long parentid) throws Exception {
	List<Long> allNode = CategoryLocalServiceUtil.getAllChild(parentid);
	depth++;
	for (Iterator<Long> iterator = allNode.iterator(); iterator.hasNext();) {
		Long node = iterator.next();
		if(node >0){
		result.append("<option value = '"+node+"'");
		if (checkNode(node) ) result.append("selected");
		result.append(">");
		for (int i=0;i<5*depth;i++) result.append("&nbsp;");
		result.append(CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
		recursiveCategoryTree(node);
		}
	}

	depth--;
}
private void recursiveCategoryTree(long groupId, String language,long parentid,List<Long> allChild, String selected,String showCategory,int typeView,RenderRequest renderRequest) throws Exception {
	List<Long> allNode = null;
	depth++;
	for (Iterator<Long> iterator = allChild.iterator(); iterator.hasNext();) {
		long node = iterator.next();
		if((","+showCategory.trim()+",").contains(","+node+",") || showCategory.trim().equals("")){
			String nodeId="";
			pathParent.add(node);
			for(int k=0;k<=depth;k++){
				if(nodeId.equals(""))nodeId=""+pathParent.get(k);
				else nodeId+="_"+pathParent.get(k);
			}
			allNode = CategoryLocalServiceUtil.getAllChild(node, groupId, language);
			if(typeView==0){
				result.append("<option value = '"+node+"'");
				if ((","+selected+",").contains(","+node+",")) result.append("selected");
				result.append(">");
				for (int i=0;i<5*depth;i++) result.append("&nbsp;");
				result.append(CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
				if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
			}
			else if(typeView==1){
				if(allNode!=null && allNode.size()>0){
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
					result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")) {
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
		    		result.append("<div id=\"div_"+nodeId+"\" >");
		    		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
		    		result.append("</div>");
				}
				else{
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;");
					result.append("</div><div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")){
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
				}
				
	    	}
			else if(typeView==2){
	        	if(allNode!=null && allNode.size()>0){
	        		result.append("<div style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
	        		for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
	        		result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
	        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
	        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div>");
	        		
	        		result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
	        		result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;'><a href='' style='color: red !important;float: right;margin-left: 10px;'><i class='icon-remove'></i></a><a href='' style='float: right;'><i class='icon-pencil'></i></a></div>");
	        		
	        		result.append("</div>\n");
	        		result.append("<div id=\"div_"+node+"\" >");
	        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
		    		result.append("</div>");
	        	}
	        	else{
	        		result.append("<div style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
	        		for (int i=0;i<5*depth;i++) result.append("&nbsp;");
	        		result.append("</div><div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
	        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
	        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div>");
                    result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
                    result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;'><a href='' style='color: red !important;float: right;margin-left: 10px;'><i class='icon-remove'></i></a><a href='' style='float: right;'><i class='icon-pencil'></i></a></div>");
	        		
	        		result.append("</div>\n");
	        	}
	        }
			else if(typeView==3){
				if(allNode!=null && allNode.size()>0){
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
					result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"radio\"  id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")) {
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
		    		result.append("<div id=\"div_"+nodeId+"\" >");
		    		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
		    		result.append("</div>");
				}
				else{
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
					result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"radio\"  id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")){
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
				}
				
	    	}else if(typeView==4){
				if(allNode!=null && allNode.size()>0){
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
					result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")) {
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
		    		result.append("<div id=\"div_"+nodeId+"\" >");
		    		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
		    		result.append("</div>");
				}
				else{
					result.append("<div id='node_"+node+"' ><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;");
					result.append("</div><div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")){
		    			result.append("checked='checked' ");
		    			if(selectedNode<=0)selectedNode=node;
		    		}
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
				}
				
	    	}
			else {if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);}
			pathParent.remove(pathParent.size()-1);
		}
		
	}
	depth--;
}
private void recursiveCategoryTree(long groupId, String language,long parentid,List<Long> allChild, String selected,String showCategory,int typeView,String urlEdit,String urlDelete,HashMap hCate,RenderRequest renderRequest) throws Exception {
	List<Long> allNode = null;
	depth++;
	for (Iterator<Long> iterator = allChild.iterator(); iterator.hasNext();) {
		long node = iterator.next();
		if((","+showCategory.trim()+",").contains(","+node+",") || showCategory.trim().equals("")){
			String nodeId="";
			pathParent.add(node);
			for(int k=0;k<=depth;k++){
				if(nodeId.equals(""))nodeId=""+pathParent.get(k);
				else nodeId+="_"+pathParent.get(k);
			}
			allNode = CategoryLocalServiceUtil.getAllChild(node, groupId, language);
			if(typeView==0){
				result.append("<option value = '"+node+"'");
				if ((","+selected+",").contains(","+node+",")) result.append("selected");
				result.append(">");
				for (int i=0;i<5*depth;i++) result.append("&nbsp;");
				result.append(CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
				if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
			}
			else if(typeView==1){
				if(allNode!=null && allNode.size()>0){
					result.append("<div><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
					result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
		    		result.append("<div id=\"div_"+nodeId+"\" >");
		    		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
		    		result.append("</div>");
				}
				else{
					result.append("<div><div style='display: table-row;'><div style='display: table-cell;'>");
					for (int i=0;i<5*depth;i++) result.append("&nbsp;");
					result.append("</div><div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
		    		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
		    		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
				}
				
	    	}
			else if(typeView==2){
	        	if(allNode!=null && allNode.size()>0){
	        		result.append("<div class='elementCategory' id='div_div_" +nodeId +"' style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
	        		for (int i=0;i<5*depth;i++) result.append("&nbsp;</div><div style='display: table-cell;'>");
	        		result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+nodeId+"\" style=\"width: 11px; padding-top: 4px;padding-left: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
					result.append("</div><div style='display: none;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
	        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
	        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;'><span id='span_"+nodeId+"'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+" (<b style='color:blue'>"+(hCate.containsKey(node)?hCate.get(node):0)+"</b>)"+"</span></div></div>");
	        		
	        		result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
	        		result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;text-align: center;width: 15%;'><a href='"+urlEdit.replace("id-edit=0", "id-edit="+node)+"' style='padding-right: 5px;padding-left: 5px;'><i class='icon-pencil'></i></a><a href='"+urlDelete.replace("id-delete=0", "id-delete="+node)+"' style='color: red !important;padding-right: 5px;padding-left: 5px;'><i class='icon-remove'></i></a></div>");
	        		
	        		result.append("</div>\n");
	        		result.append("<div id=\"div_"+node+"\" >");
	        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
		    		result.append("</div>");
	        	}
	        	else{
	        		result.append("<div class='elementCategory' id='div_div_" +nodeId +"' style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
	        		for (int i=0;i<5*depth;i++) result.append("&nbsp;");
	        		result.append("</div><div style='display: none;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+nodeId+"\" value='"+node+"' ");
	        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
	        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'><span style='padding-left: 13px;' id='span_"+nodeId+"'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+" (<b style='color:blue'>"+(hCate.containsKey(node)?hCate.get(node):0)+"</b>)"+"</span></div></div>");
                    result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
                    result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;text-align: center;width: 15%;'><a href='"+urlEdit.replace("id-edit=0", "id-edit="+node)+"' style='padding-right: 5px;padding-left: 5px;'><i class='icon-pencil'></i></a><a href='"+urlDelete.replace("id-delete=0", "id-delete="+node)+"' style='color: red !important;padding-right: 5px;padding-left: 5px;'><i class='icon-remove'></i></a></div>");
	        		
	        		result.append("</div>\n");
	        	}
	        }
			else {if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);}
			pathParent.remove(pathParent.size()-1);
		}
		
	}
	depth--;
}
public String createCategoryTree(long[] parentCurrent) throws Exception {
	this.parentCurrent = parentCurrent;
	List<Long> root = CategoryLocalServiceUtil.getAllChild(0);
	for (Iterator<Long> iterator = root.iterator(); iterator.hasNext();) {
		long node = iterator.next();
		depth = 0;

		result.append("<option value = '"+node+"'");
		if (checkNode(node)) result.append("selected");
		result.append(">"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
		recursiveCategoryTree( node);
	}

	return result.toString();
}


public String createCategoryTree(long[] parentCurrent, long selected) throws Exception {
	this.parentCurrent = parentCurrent;
	List<Long> root = CategoryLocalServiceUtil.getAllChild(0);
	for (Iterator<Long> iterator = root.iterator(); iterator.hasNext();) {
		long node = iterator.next();
		depth = 0;

		result.append("<option value = '"+node+"'");
		if (node == selected) result.append("selected");
		result.append(">"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
		recursiveCategoryTree(node);
	}

	return result.toString();
}
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
public String createCategoryTree(long[] parentCurrent, long groupId, String language, String selected,String showCategory,int typeView,RenderRequest renderRequest) throws Exception {
	this.parentCurrent = parentCurrent;
	List<Long> root=null;
	List<Long> allNode=null;
	long firstNode=0;
	for(int i=0;i<parentCurrent.length;i++){
		if((","+showCategory.trim()+",").contains(","+parentCurrent[i]+",") || showCategory.trim().equals("") || parentCurrent[i]==0)
		{
			root = CategoryLocalServiceUtil.getAllChild(parentCurrent[i], groupId,language);
			for (Iterator<Long> iterator = root.iterator(); iterator.hasNext();) {
				long node = iterator.next();
				if((","+showCategory.trim()+",").contains(","+node+",") || showCategory.trim().equals("")){
					pathParent=new ArrayList<Long>();
					allNode = CategoryLocalServiceUtil.getAllChild(node, groupId, language);
					depth = 0;pathParent.add(node);
			        if(typeView==0){
			        	result.append("<option value = '"+node+"'");
			    		if ((","+selected+",").contains(","+node+",")) result.append("selected");
			    		result.append(">"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
			    		if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
			        }
			        else if(typeView==1){
			        	if(firstNode<=0)firstNode=node;
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'>");
			        		result.append("<div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        	}
			        }
			        else if(typeView==2){
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div>");
			        		
			        		result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
			        		result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;'><a href='' style='color: red !important;float: right;margin-left: 10px;'><i class='icon-remove'></i></a><a href='' style='float: right;'><i class='icon-pencil'></i></a></div>");
			        		result.append("</div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'>");
			        		result.append("<div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div>");
                            result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
                            result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;'><a href='' style='color: red !important;float: right;margin-left: 10px;'><i class='icon-remove'></i></a><a href='' style='float: right;'><i class='icon-pencil'></i></a></div>");
			        		result.append("</div>\n");
			        	}
			        }
			        else if(typeView==3){
			        	if(firstNode<=0)firstNode=node;
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"radio\"  id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
			        		result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"radio\"  id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        	}
			        }
			        else if(typeView==4){
			        	if(firstNode<=0)firstNode=node;
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div id='node_"+node+ "' ><div style='display: table-row;'>");
			        		result.append("<div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) {
			        			result.append("checked='checked' ");
			        			if(selectedNode<=0)selectedNode=node;
			        		}
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        	}
			        }
			        else{
			        	if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,renderRequest);
			        }
			        pathParent=null;
				}
				
			}
		}
		
		
	}
	result.append("<script>");
	if(selectedNode>0 && firstNode>0){
		result.append("var container = $('#node_"+firstNode+"').parent(), scrollTo = $('#node_"+selectedNode+"');container.scrollTop(scrollTo.offset().top - container.offset().top + container.scrollTop());");
	}
	if((typeView!=3) && (typeView != 4)){
		System.out.println(typeView+" :typeView");
		result.append("function imgClick(e){var id=e.id.replace('img','div');var dv=document.getElementById(id);");
		result.append("	if(dv.style.display!='none'){	dv.style.display='none';e.src='"+renderRequest.getContextPath()+"/images/03_plus.png';");
		result.append("$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_plus.png';	 document.getElementById(this.id.replace('img','div')).style.display='none';});	}");
		result.append("	else {dv.style.display='block';e.src='"+renderRequest.getContextPath()+"/images/03_minus.png';");
		result.append("	$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_minus.png';  document.getElementById(this.id.replace('img','div')).style.display='block';	});	}}");
		
		result.append("function chkChange(e){  var id=e.id.replace('chk','div');var parentId=e.id.replace('chk_','');var i=0;");
		result.append("if (!$(e).is(':checked')) {$('#'+id+' input').each(function(){this.checked =false;});");
		result.append("if(parentId.indexOf('_')>0){parentId=parentId.substring(0,parentId.lastIndexOf('_'));/* $('#div_'+parentId+' input').each(function(){if ($(this).is(':checked') )i++;});");
		result.append("if(i<=0)document.getElementById('chk_'+parentId).checked =false; */ }}");
		result.append("else{$('#'+id+' input').each(function(){	this.checked =true;	});if(parentId.indexOf('_')>0){parentId=parentId.substring(0,parentId.lastIndexOf('_'));");
		result.append("/* $('#div_'+parentId+' input').each(function(){if (!$(this).is(':checked') )i++;});if(i<=0) */ document.getElementById('chk_'+parentId).checked =true;");
		result.append("}}");
		result.append("}");
	}else if(typeView == 4 ){
		System.out.println(typeView+" : imgClick typeView");
		result.append("function imgClick(e){var id=e.id.replace('img','div');var dv=document.getElementById(id);");
		result.append("	if(dv.style.display!='none'){	dv.style.display='none';e.src='"+renderRequest.getContextPath()+"/images/03_plus.png';");
		result.append("$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_plus.png';	 document.getElementById(this.id.replace('img','div')).style.display='none';});	}");
		result.append("	else {dv.style.display='block';e.src='"+renderRequest.getContextPath()+"/images/03_minus.png';");
		result.append("	$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_minus.png';  document.getElementById(this.id.replace('img','div')).style.display='block';	});	}}");
		
	}
	result.append("</script>");
	return result.toString();
}
public String createCategoryTree(long[] parentCurrent, long groupId, String language, String selected,String showCategory,int typeView,String urlEdit,String urlDelete,RenderRequest renderRequest) throws Exception {
	List<Object>lstCate=CategoryArticleLocalServiceUtil.getDuLieuTheoSql("select categoryid,count(articleid) from ecoit_cms_categoryarticle group by categoryid");
	HashMap<Long,Long>hCate=new HashMap<Long,Long>();
	if(lstCate!=null && lstCate.size()>0){
		for(Object obj:lstCate){
			Object[]o=(Object[])obj;
			hCate.put(Long.valueOf(o[0].toString()), Long.valueOf(o[1].toString()));
		}
	}
	this.parentCurrent = parentCurrent;
	List<Long> root=null;
	List<Long> allNode=null;
	for(int i=0;i<parentCurrent.length;i++){
		if((","+showCategory.trim()+",").contains(","+parentCurrent[i]+",") || showCategory.trim().equals("") || parentCurrent[i]==0)
		{
			root = CategoryLocalServiceUtil.getAllChild(parentCurrent[i], groupId,language);
			for (Iterator<Long> iterator = root.iterator(); iterator.hasNext();) {
				long node = iterator.next();
				if((","+showCategory.trim()+",").contains(","+node+",") || showCategory.trim().equals("")){
					pathParent=new ArrayList<Long>();
					allNode = CategoryLocalServiceUtil.getAllChild(node, groupId, language);
					depth = 0;pathParent.add(node);
			        if(typeView==0){
			        	result.append("<option value = '"+node+"'");
			    		if ((","+selected+",").contains(","+node+",")) result.append("selected");
			    		result.append(">"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</option><br>\n");
			    		if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
			        }
			        else if(typeView==1){
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div><div style='display: table-row;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-right: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: table-cell;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div><div style='display: table-row;'>");
			        		result.append("<div style='display: table-cell;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;line-height: 20px;'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+"</div></div></div>\n");
			        	}
			        }
			        else if(typeView==2){
			        	if(allNode!=null && allNode.size()>0){
			        		result.append("<div class='elementCategory' id='div_div_"+node +"' style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'><div style='display: table-cell;'>");
							result.append("<img src=\""+renderRequest.getContextPath()+"/images/03_minus.png\" id=\"img_"+node+"\" style=\"width: 11px; padding-top: 4px;padding-left: 2px;cursor: pointer;\" onclick='imgClick(this)' />");
							result.append("</div><div style='display: none;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;'><span id='span_"+node+"'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+" (<b style='color:blue'>"+(hCate.containsKey(node)?hCate.get(node):0)+"</b>)"+"</span></div></div>");
			        		
			        		result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
			        		
			        		result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;text-align: center;width: 15%;'><a href='"+urlEdit.replace("id-edit=0", "id-edit="+node)+"' style='padding-right: 5px;padding-left: 5px;'><i class='icon-pencil'></i></a><a href='"+urlDelete.replace("id-delete=0", "id-delete="+node)+"' style='color: red !important;padding-right: 5px;padding-left: 5px;'><i class='icon-remove'></i></a></div>");
			        		result.append("</div>\n");
			        		result.append("<div id=\"div_"+node+"\" >");
			        		recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
				    		result.append("</div>");
			        	}
			        	else{
			        		result.append("<div class='elementCategory' id='div_div_"+node +"' style='float: left;width: 99%;font-size: 18px;border-bottom: 1px solid #ececec; border-left: 1px solid #ececec;border-right: 1px solid #ececec;line-height: 30px;'><div style='display: table-row;width: 60%;float: left;'>");
			        		result.append("<div style='display: none;padding-left: 13px;'><input name='checked-category' type=\"checkbox\" onchange='chkChange(this)' id=\"chk_"+node+"\" value='"+node+"' ");
			        		if ((","+selected+",").contains(","+node+",")) result.append("checked='checked' ");
			        		result.append("/></div><div style='display: table-cell;padding-left: 5px;padding-top: 2px;position: relative;top: 3px;'><span style='padding-left: 13px;' id='span_"+node+"'>"+ CategoryLocalServiceUtil.getCategory(node).getTitle()+" (<b style='color:blue'>"+(hCate.containsKey(node)?hCate.get(node):0)+"</b>)"+"</span></div></div>");
                            result.append("<div style='float: left;width: 25%;display: table-cell;padding-top: 2px;position: relative;top: 3px;'>"+sdf.format(CategoryLocalServiceUtil.getCategory(node).getCreatedDate())+"</div>");
                            result.append("<div style='float: left;display: table-cell;padding-top: 2px;position: relative;top: 3px;text-align: center;width: 15%;'><a href='"+urlEdit.replace("id-edit=0", "id-edit="+node)+"' style='padding-right: 5px;padding-left: 5px;'><i class='icon-pencil'></i></a><a href='"+urlDelete.replace("id-delete=0", "id-delete="+node)+"' style='color: red !important;padding-right: 5px;padding-left: 5px;'><i class='icon-remove'></i></a></div>");
			        		result.append("</div>\n");
			        	}
			        }
			        else{
			        	if(allNode!=null && allNode.size()>0)recursiveCategoryTree(groupId, language, node,allNode,selected,showCategory,typeView,urlEdit,urlDelete,hCate,renderRequest);
			        }
			        pathParent=null;
				}
				
			}
		}
		
		
	}
	
	result.append("<script>function imgClick(e){var id=e.id.replace('img','div');var dv=document.getElementById(id);");
	result.append("	if(dv.style.display!='none'){	dv.style.display='none';e.src='"+renderRequest.getContextPath()+"/images/03_plus.png';");
	result.append("$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_plus.png';	 document.getElementById(this.id.replace('img','div')).style.display='none';});	}");
	result.append("	else {dv.style.display='block';e.src='"+renderRequest.getContextPath()+"/images/03_minus.png';");
	result.append("	$('#'+id+' img').each(function(){ this.src='"+renderRequest.getContextPath()+"/images/03_minus.png';  document.getElementById(this.id.replace('img','div')).style.display='block';	});	}}");
	
	result.append("function chkChange(e){  var id=e.id.replace('chk','div');var parentId=e.id.replace('chk_','');var i=0;");
	result.append("if (!$(e).is(':checked')) {$('#'+id+' input').each(function(){this.checked =false;});");
	result.append("if(parentId.indexOf('_')>0){parentId=parentId.substring(0,parentId.lastIndexOf('_'));/* $('#div_'+parentId+' input').each(function(){if ($(this).is(':checked') )i++;});");
	result.append("if(i<=0)document.getElementById('chk_'+parentId).checked =false; */ }}");
	result.append("else{$('#'+id+' input').each(function(){	this.checked =true;	});if(parentId.indexOf('_')>0){parentId=parentId.substring(0,parentId.lastIndexOf('_'));");
	result.append("/* $('#div_'+parentId+' input').each(function(){if (!$(this).is(':checked') )i++;});if(i<=0) */ document.getElementById('chk_'+parentId).checked =true;");
	result.append("}}");
	result.append("} </script>");
	return result.toString();
}
public String createCategoryTree(long parentCurrent) throws Exception {
	return this.createCategoryTree(new long[]{parentCurrent});
}

public String createCategoryTree(long parentCurrent, long selected) throws Exception {
	return this.createCategoryTree(new long[]{parentCurrent}, selected);
}



}