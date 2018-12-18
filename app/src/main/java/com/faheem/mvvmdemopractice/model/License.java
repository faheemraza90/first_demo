package com.faheem.mvvmdemopractice.model;

public class License{
	private String name;
	private String spdxId;
	private String key;
	private String url;
	private String nodeId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSpdxId(String spdxId){
		this.spdxId = spdxId;
	}

	public String getSpdxId(){
		return spdxId;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setNodeId(String nodeId){
		this.nodeId = nodeId;
	}

	public String getNodeId(){
		return nodeId;
	}

	@Override
 	public String toString(){
		return 
			"License{" + 
			"name = '" + name + '\'' + 
			",spdx_id = '" + spdxId + '\'' + 
			",key = '" + key + '\'' + 
			",url = '" + url + '\'' + 
			",node_id = '" + nodeId + '\'' + 
			"}";
		}
}
