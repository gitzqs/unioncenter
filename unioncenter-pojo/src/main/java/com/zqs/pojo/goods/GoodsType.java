package com.zqs.pojo.goods;

import java.util.Date;
import java.util.List;

import com.zqs.pojo.base.REntity;

/**
 * 商品类别
 * 
 * @author qiushi.zhou  
 * @date 2017年3月2日 下午2:14:54
 */
public class GoodsType extends REntity{

	private static final long serialVersionUID = -2775020860461604405L;
	
	private Long typeId;
	
	/** 名称 */
	private String name;
	
	/** 级别 */
	private int level;
	
	/** 排序 */
	private int sort;
	
	/** 父id */
	private Long parentId;
	
	/** 图片介绍 */
	private String image;
	
	/** 状态 */
	private int status;
	
	/** 创建人 */
	private Long creatorId;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最新更改人 */
	private Long lastOperatorId;
	
	/** 最新更改时间 */
	private Date lastOperatedTime;
	
	/** 存放下属类别*/
	private List<GoodsType> list;
	
	/** 存放下属商品 */
	private List<Goods> goodsList;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getLastOperatorId() {
		return lastOperatorId;
	}

	public void setLastOperatorId(Long lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}

	public Date getLastOperatedTime() {
		return lastOperatedTime;
	}

	public void setLastOperatedTime(Date lastOperatedTime) {
		this.lastOperatedTime = lastOperatedTime;
	}

	public List<GoodsType> getList() {
		return list;
	}

	public void setList(List<GoodsType> list) {
		this.list = list;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	
}
